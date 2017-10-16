package org.kosta.matzip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class PostDAO {
	private static PostDAO dao=new PostDAO();
	private DataSource dataSource;
	private PostDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static PostDAO getInstance(){
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
	
	public ArrayList<PostVO> getPostingList() throws SQLException{
		ArrayList<PostVO> plist=new ArrayList<PostVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT p.pno,p.mid,p.ptitle,p.pcontent,p.pstar,to_char(pdate,'YYYY.MM.DD'),p.phit,p.plike,l.loc,l.sigungu ");
			sql.append("FROM post p , location l ");
			sql.append("WHERE p.locno=l.locno ");		
			//sql.append("order by pno desc");
			pstmt=con.prepareStatement(sql.toString());		
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){		
				PostVO pvo=new PostVO();
				pvo.setPno(rs.getString(1));
				pvo.setMid(rs.getString(2));
				pvo.setPtitle(rs.getString(3));
				pvo.setPcontent(rs.getString(4));
				pvo.setPstar(rs.getInt(5));
				pvo.setPdate(rs.getString(6));
				pvo.setPhit(rs.getInt(7));
				pvo.setPlike(rs.getInt(8));
				pvo.setLoc(rs.getString(9));
				pvo.setSigungu(rs.getString(10));
				plist.add(pvo);
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return plist;
	}//getallpostlist
	
	public ArrayList<PostVO> PostSortByLocation(String loc,String sigungu) throws SQLException{
		ArrayList<PostVO> sortlist = new ArrayList<PostVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String locno = findLocNo(loc, sigungu);
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("SELECT p.pno,p.ptitle,to_char(pdate,'YYYY.MM.DD'),p.phit,l.loc,l.sigungu,p.mid ");
			sql.append("FROM post p , location l ");
			sql.append("WHERE p.locno=? and p.locno=l.locno ");		
			pstmt=con.prepareStatement(sql.toString());		
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			pstmt.setString(1,locno);
			rs=pstmt.executeQuery();
			while(rs.next()){		
				PostVO pvo=new PostVO();
				pvo.setPno(rs.getString(1));
				pvo.setPtitle(rs.getString(2));
				pvo.setPdate(rs.getString(3));
				pvo.setPhit(rs.getInt(4));
				pvo.setLoc(rs.getString(5));
				pvo.setSigungu(rs.getString(6));
				pvo.setMid(rs.getString(7));
				sortlist.add(pvo);
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return sortlist;
	}//postbylocation
	/*
	 * private String pno;
	private String ptitle;
	private ArrayList<String> pictures;
	private String pcontent;
	private int pstar;
	private int plike;
	private String paddress;
	private String ptime;
	private String ptel;
	private String pprice;
	private String petc;
	private String pdate;
	private int phit;
	private String loc;
	private String sigungu;
	private String mid;
	private ArrayList<CommentVO> commentList;
	 */
	public PostVO findPostByPno(String pno) throws SQLException {
		PostVO pvo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("SELECT p.pno,p.ptitle,p.pcontent,p.pstar,p.plike,p.paddress,p.ptime,p.ptel,p.pprice,p.petc,to_char(pdate,'YYYY.MM.DD'),p.phit,l.loc,l.sigungu,p.mid ");
			sql.append("FROM post p , location l ");
			sql.append("WHERE p.pno=? and p.locno=l.locno ");		
			pstmt=con.prepareStatement(sql.toString());		
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			pstmt.setString(1,pno);
			rs=pstmt.executeQuery();
			while(rs.next()){		
				pvo=new PostVO();
				pvo.setPno(rs.getString(1));
				pvo.setPtitle(rs.getString(2));
				pvo.setPcontent(rs.getString(3));
				pvo.setPstar(rs.getInt(4));
				pvo.setPlike(rs.getInt(5));
				pvo.setPaddress(rs.getString(6));
				pvo.setPtime(rs.getString(7));
				pvo.setPtel(rs.getString(8));
				pvo.setPprice(rs.getString(9));
				pvo.setPetc(rs.getString(10));
				pvo.setPdate(rs.getString(11));
				pvo.setPhit(rs.getInt(12));
				pvo.setLoc(rs.getString(13));
				pvo.setSigungu(rs.getString(14));
				pvo.setMid(rs.getString(15));
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		
		return pvo;
	}
	public ArrayList<String> findImageByPno(String pno) throws SQLException {
		ArrayList<String> path = new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("SELECT i.ipath ");
			sql.append("FROM post p , imagepath i ");
			sql.append("WHERE p.pno=? and p.pno=i.pno ");		
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1,pno);
			//pstmt.setInt(1,bean.getStartRowNumber());
			//pstmt.setInt(2,bean.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){		
				path.add(rs.getString(1));
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return path;
	}
	public String findLocNo(String loc,String sigungu) throws SQLException {
		String locno=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT locno ");
			sql.append("FROM location ");
			sql.append("WHERE loc=? and sigungu=? ");		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,loc);
			pstmt.setString(2,sigungu);
			rs=pstmt.executeQuery();
			while(rs.next()){		
				locno=rs.getString(1);
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return locno;
	}//findlocno
	public int getTotalPostCount() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int totalCount=-1;
		try{
			con=getConnection();
			String sql="select count(*) from post";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return totalCount;
	}// totalcount
}
