package org.kosta.matzip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RequestDAO {
	private static RequestDAO dao=new RequestDAO();
	private DataSource dataSource;
	private RequestDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static RequestDAO getInstance(){
		return dao;
	}
	
	private Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	public void closeAll(PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		closeAll(pstmt,con);
	}
	
	public ArrayList<RequestVO> getRequestList() throws SQLException{
		ArrayList<RequestVO> rlist=new ArrayList<RequestVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT r.reqno,m.mid,r.reqcontent,to_char(reqdate,'YYYY.MM.DD') ");
			sql.append("FROM request r , member m ");
			sql.append("WHERE m.mid=r.mid order by r.reqdate desc");		
			//sql.append("order by pno desc");
			pstmt=con.prepareStatement(sql.toString());		
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){		
				RequestVO rvo=new RequestVO();
				rvo.setReqno(rs.getString(1));
				rvo.setMid(rs.getString(2));
				rvo.setReqcontent(rs.getString(3));
				rvo.setReqdate(rs.getString(4));
				rlist.add(rvo);
			}			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return rlist;
	}//getallreqlist
	
	public void getRequestResgister(String mid, String reqcontent) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			String sql="insert into request(reqno,mid,reqcontent,reqdate)values(req_seq.nextval,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, mid);
			pstmt.setString(2, reqcontent);
			rs=pstmt.executeQuery();
		}finally{
			closeAll(rs,pstmt,con);
		}
	}//reqregister
	public void requestDelete(String reqno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			String sql="delete from request where reqno=?";
			pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, reqno);
			rs=pstmt.executeQuery();
		}finally{
			closeAll(rs,pstmt,con);
		}	
	}// reqdelete
	public RequestVO selectReqByNo(String reqno) throws SQLException {
		RequestVO rvo=new RequestVO();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			String sql="SELECT reqno,mid,reqcontent,to_char(reqdate,'YYYY.MM.DD') from request where reqno=?";
			//sql.append("order by pno desc");
			pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, reqno);
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			rs=pstmt.executeQuery();
			if(rs.next()){		
				rvo=new RequestVO();
				rvo.setReqno(rs.getString(1));
				rvo.setMid(rs.getString(2));
				rvo.setReqcontent(rs.getString(3));
				rvo.setReqdate(rs.getString(4));
			}			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return rvo;
	}//selectreq
	public void requestUpdate(String reqno, String reqcontent) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection(); 
			String sql="update request set reqcontent=? where reqno=?";
			pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, reqcontent);
			pstmt.setString(2, reqno);
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt,con);
		}	
	}// requpdate
	
	public ArrayList<RequestVO> getAllPostList(int start, int end) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<RequestVO> list=new ArrayList<RequestVO>();
		RequestVO rvo=new RequestVO();
		try{
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT r.reqno,m.mid,r.reqcontent,to_char(reqdate,'YYYY.MM.DD') ");
			sql.append("FROM (select row_number() over(order by reqdate desc) rnum, reqno, mid, reqcontent, reqdate from request) r, MEMBER m ");
			sql.append("WHERE (rnum between ? and ?) and (m.mid=r.mid) ");
			sql.append("order by reqdate desc");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			while(rs.next()){
				rvo=new RequestVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(rvo);
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	public int TotalCount() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int tc=0;
		try{
			con=getConnection();
			String sql="select count(*) from request";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				tc=rs.getInt(1);
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return tc;
	}
}//class
