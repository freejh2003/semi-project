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
	}
}
