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
	public void insertLocation() throws SQLException {
	      Connection con=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      String[][] area = {{"제주특별자치도","서귀포시","제주시"},
	            {"전라남도","목포시","무안군","고흥군","광양시","강진군","곡성군","구례군","나주시","담양군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군","장성군 북일면","담양군 담양읍","목포시 석현동","순창군","장수군"},{"부산광역시","금정구","강서구","기장군","남구","동구","서구","부산진구","북구","동래구","사상구","사하구","수영구","연제구","영도구","중구","해운대구"},
	            {"울산광역시","남구","북구","울주군","동구","중구"},
	            {"경상남도","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","거창군","고성군","남해군","산청군","의령군","창녕군","통영시","하동군","함안군","함양군","합천군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구"},
	              {"광주광역시","광산구","북구","서구","남구","동구"},
	              {"전라북도","정읍시","군산시","완주군","익산시","고창군","김제시","남원시","무주군","부안군","순창군","임실군","장수군","진안군","고창군 대산면","전주시","무안군"},
	              {"대구광역시","달서구","수성구","남구","서구","북구","달성군","중구","동구"},
	              {"경상북도","고령군","경산시","경주시","구미시","김천시","문경시","영천시","포항시","군위군","봉화군","상주시","안동시","영덕군","영양군","영주시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군","포항시 남구","포항시 북구"},
	              {"대전광역시","대덕구","동구","서구","유성구","중구"},
	                {"충청남도","공주시","금산군","논산시","당진시","보령시","부여군","서산시","아산시","연기군","예산군","천안시","태안군","홍성군","계룡시","서천군","청양군","당진군"},
	                {"충청북도","단양군","제천시","진천군","청원군","청주시","충주시","증평군","영동군","옥천군","음성군","괴산군","보은군","청주시 흥덕구"},
	                {"경기도","고양시","가평군","과천시","광명시","광주시","평택시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","양평군","용인시 처인구","분당구","연천군","오산시","용인시","의정부시","의왕시","이천시","파주시","포천시","화성시","하남시","용인시 기흥구","수원시 영통구","고양시 덕양구","남원시","광주시 곤지암읍","여주시","용인시 수지구"},
	                {"강원도","강릉시","고성군","강릉시","동해시","속초시","원주시","횡성군","철원군","춘천시","평창군","홍천군","양양군","삼척시","양구군","영월군","인제군","정선군","태백시","화천군"},
	                {"인천광역시","계양구","강화군","남구","동구","남동구","부평구","서구","연수구","중구","옹진군"},
	                {"서울특별시","강동구","강남구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"},
	                {"세종특별자치시","반곡동", "소담동", "보람동", "대평동", "가람동", "한솔동", "나성동", "새롬동", "다정동", "어진동", "종촌동", "고운동", "아름동", "도담동", "조치원읍", "연기면", "연동면", "부강면", "금남면", "장군면", "연서면", "전의면", "전동면","소정면"}
	             };
	      String loc = null;
	      String sigungu=null;           
	      try{
	         con=getConnection(); 
	         String sql = "insert into location(locno,loc,sigungu)values(locno_seq.nextval,?,?) ";
	         pstmt=con.prepareStatement(sql);      
	         for(int x = 0; x < area.length; x++){
	            loc=area[x][0];
	             for(int y = 1; y < area[x].length; y++){
	                sigungu=area[x][y];  
	                pstmt.setString(1,loc);   
	                 pstmt.setString(2,sigungu);
	                 pstmt.executeQuery();
	              }//inner for
	         }//outter for   
	      }//try
	      finally{
	      closeAll(rs,pstmt,con);
	      }
	   }//method
	
	public void AddFavorite(String mid, String pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="insert into post_myfav(mid, pno) values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pno);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<PostVO> MyFavoriteView(String mid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PostVO pvo=null;
		ArrayList<PostVO> list=null;
		try {
			list=new ArrayList<PostVO>();
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT p.pno, p.ptitle, p.pstar, p.plike, p.phit");
			sql.append(" FROM post_myfav pm, post p");
			sql.append(" WHERE pm.mid=? and pm.pno=p.pno ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, mid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				pvo=new PostVO();
			pvo.setPno(rs.getString(1));
			pvo.setPtitle(rs.getString(2));
			pvo.setPstar(rs.getInt(3));
			pvo.setPlike(rs.getInt(4));
			pvo.setPhit(rs.getInt(5));
			list.add(pvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}//class
