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
	}//findPostByPno
	public void updateHit(String pno) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=getConnection(); 
			String sql="update post set phit=phit+1 where pno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pno);	
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
		}
	}//hit
	@SuppressWarnings("resource")
	public int updateLike(String pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int plike = -1;
		try{
			con=getConnection(); 
			String sql="update post set plike=plike+1 where pno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pno);	
			pstmt.executeUpdate();
			sql="select plike from post where pno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pno);	
			rs=pstmt.executeQuery();
			if(rs.next())
				plike=rs.getInt(1);
		}finally{
			closeAll(rs,pstmt,con);
		}
		return plike;
	}//like
	public void deletePost(String pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("DELETE ");
			sql.append("FROM post ");
			sql.append("WHERE pno=? ");		
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1,pno);
			pstmt.executeQuery();
		}finally{
			closeAll(rs,pstmt,con);
		}
	}//delete
	public PostVO updatePost(PostVO pvo) throws SQLException {
		PostVO updatedpvo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String locno = findLocNo(pvo.getLoc(),pvo.getSigungu());
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("UPDATE post ");
			sql.append("SET ptitle=?,pcontent=?,pstar=?,plike=?,paddress=?,ptime=?,ptel=?,pprice=?,petc=?,pdate=sysdate,phit=?,locno=?,mid=? ");
			sql.append("WHERE pno=? ");		
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1,pvo.getPtitle());
			pstmt.setString(2,pvo.getPcontent());
			pstmt.setInt(3,pvo.getPstar());
			pstmt.setInt(4,pvo.getPlike());
			pstmt.setString(5,pvo.getPaddress());
			pstmt.setString(6,pvo.getPtime());
			pstmt.setString(7,pvo.getPtel());
			pstmt.setString(8,pvo.getPprice());
			pstmt.setString(9,pvo.getPetc());
			pstmt.setInt(10,pvo.getPhit());
			pstmt.setString(11,locno);
			pstmt.setString(12,pvo.getMid());
			pstmt.setString(13,pvo.getPno());
			pstmt.executeUpdate();
			updatedpvo=findPostByPno(pvo.getPno());
		}finally{
			closeAll(rs,pstmt,con);
		}
		return updatedpvo;
	}//update
	
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
	}//findImageByPno
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
	public ArrayList<CommentVO> getCommentList(String pno) throws SQLException{
		ArrayList<CommentVO> clist = new ArrayList<CommentVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT c.comno,c.pno,c.mid,c.comcontent,c.comdate ");
			sql.append("FROM post p, comments c ");
			sql.append("WHERE p.pno=? and p.pno=c.pno ORDER BY c.comdate ASC ");		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,pno);
			rs=pstmt.executeQuery();
			while(rs.next()){		
				clist.add(new CommentVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}			
			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return clist;
	}
	@SuppressWarnings("resource")
	public CommentVO addComment(CommentVO cvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CommentVO curr = null;
		String comno=null;
		try{
			con=getConnection();
			String sql="insert into comments(comno,pno,mid,comcontent,comdate)values(com_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,cvo.getPno());
			pstmt.setString(2,cvo.getMid());
			pstmt.setString(3,cvo.getComcontent());
			pstmt.executeQuery();
			sql="select com_seq.currval from dual";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				comno = rs.getString(1);
			sql="select comno,pno,mid,comcontent,comdate from comments where comno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,comno);
			rs=pstmt.executeQuery();
			if(rs.next())
				curr = new CommentVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}finally{
			closeAll(rs, pstmt,con);
		}
		return curr;
	}
	public void deleteComment(String comno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();	
			sql.append("DELETE ");
			sql.append("FROM comments ");
			sql.append("WHERE comno=? ");		
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1,comno);
			pstmt.executeQuery();
		}finally{
			closeAll(rs,pstmt,con);
		}
	}
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
	@SuppressWarnings("resource")
	public String reviewRegister(PostVO vo, String locno) throws SQLException { //글 등록하는 메서드
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String pno=null;
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("insert into post(pno, ptitle, phit, pcontent, pstar, plike, paddress, ptime, ptel, pprice, petc, pdate, mid, locno) ");
			sql.append("values(pno_seq.nextval, ?, 0, ?, 0, 0, ?, ?, ?, ?, ?, sysdate,?, ?) ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getPtitle());
			pstmt.setString(2, vo.getPcontent());
			pstmt.setString(3, vo.getPaddress());
			pstmt.setString(4, vo.getPtime());
			pstmt.setString(5, vo.getPtel());
			pstmt.setString(6, vo.getPprice());
			pstmt.setString(7,  vo.getPetc());
			pstmt.setString(8, vo.getMid());
			pstmt.setString(9, locno);
			rs=pstmt.executeQuery();
			String sql1="select pno_seq.currval from dual";
			pstmt=con.prepareStatement(sql1);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pno=rs.getString(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return pno;
		
	}
	public String mostRecentPost() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String pno=null;
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select pno_seq.nextval-1 from dual");
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pno=rs.getString(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return pno;
	}
	public void registerImage(String pno, ArrayList<String> pictures) throws SQLException { //이미지 저장하는 메서드
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			for(int i=0; i<pictures.size(); i++) {
				if(pictures.get(i)!=null) {
			StringBuilder sql=new StringBuilder();
			sql.append("insert into imagepath(pno, ipath) ");
			sql.append("values(?, ?) ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, pno);
			pstmt.setString(2, pictures.get(i));
			pstmt.executeQuery();
				}
			}
		}finally{
			closeAll(pstmt,con);
		}
	}
}//class
