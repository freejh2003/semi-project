package org.kosta.matzip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO dao=new MemberDAO();
	private DataSource dataSource;
	private MemberDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance(){
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
	public MemberVO login(String mid, String mpassword) throws SQLException {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql=
					"select ano,mname,maddress,mtel from member where mid=? and mpassword=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpassword);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(mid,rs.getString(1),mpassword,rs.getString(2),rs.getString(3),rs.getString(4));
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return vo;
	}// login
	public MemberVO FindMemberById(String mid) throws SQLException {
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con=null;
		MemberVO mvo=new MemberVO();
		try {
			con=getConnection();
			String sql="select mpassword,ano,mname,maddress,mtel from member where mid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mvo=new MemberVO(mid,rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}//findbyid
	public void memberUpdate(MemberVO umvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql=
					"update member set mpassword=?, mname=?, maddress=?, mtel=? where mid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, umvo.getMpassword());
			pstmt.setString(2, umvo.getMname());
			pstmt.setString(3, umvo.getMaddress());
			pstmt.setString(4, umvo.getMtel());
			pstmt.setString(5, umvo.getMid());
			pstmt.executeUpdate();
		}finally{
			closeAll(rs, pstmt,con);
		}
	}// update
	public void memberLeave(String mid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql=
					"delete from member where mid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		}finally{
			closeAll(rs, pstmt,con);
		}
	}//delete
	public void register(MemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="insert into member(mid,ano,mpassword,mname,maddress,mtel)values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getAno());
			pstmt.setString(3, vo.getMpassword());
			pstmt.setString(4, vo.getMname());
			pstmt.setString(5, vo.getMaddress());
			pstmt.setString(6, vo.getMtel());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}//register
	public String IdCheck(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String idcomfirm=null;
		try {
			con=getConnection();
			String sql="select mid from member where mid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
				idcomfirm=rs.getString(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return idcomfirm;
	}//idcheck
}//class
