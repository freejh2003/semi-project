package org.kosta.matzip.model;

import java.util.ArrayList;

public class PostVO {
	private String pno;
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
	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostVO(String ptitle, String pcontent,int pstar, String paddress, String ptime, String ptel, String pprice,
			String petc, String mid) {
		super();
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.mid = mid;
	}
	

	public PostVO(String pno, String ptitle, String pcontent, int pstar, int plike, String paddress, String ptime,
			String ptel, String pprice, String petc, int phit, String loc, String sigungu, String mid) {
		super();
		this.pno = pno;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.plike = plike;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.phit = phit;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
	}

	public PostVO(String pno, String ptitle, ArrayList<String> pictures, String pcontent, int pstar, int plike,
			String paddress, String ptime, String ptel, String pprice, String petc, String pdate, int phit, String loc,
			String sigungu, String mid, ArrayList<CommentVO> commentList) {
		super();
		this.pno = pno;
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.plike = plike;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.pdate = pdate;
		this.phit = phit;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
		this.commentList = commentList;
	}
	public PostVO(String pno, String ptitle, ArrayList<String> pictures, String pcontent, int pstar, int plike,
			String paddress, String ptime, String ptel, String pprice, String petc, String pdate, int phit, String loc,
			String sigungu, String mid) {
		super();
		this.pno = pno;
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.plike = plike;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.pdate = pdate;
		this.phit = phit;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
	}
	public PostVO(String pno, String ptitle, String pdate, int phit, String loc, String sigungu, String mid) {
		super();
		this.pno = pno;
		this.ptitle = ptitle;
		this.pdate = pdate;
		this.phit = phit;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
	}
	
	public PostVO(String ptitle, ArrayList<String> pictures, String pcontent, int pstar, String paddress, String ptime,
			String ptel, String pprice, String petc, String pdate, String loc, String sigungu,
			ArrayList<CommentVO> commentList) {
		super();
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.pdate = pdate;
		this.loc = loc;
		this.sigungu = sigungu;
		this.commentList = commentList;
	}
	
	public PostVO(String pno, String ptitle, ArrayList<String> pictures, String pcontent, int pstar, int plike,
			String paddress, String ptime, String ptel, String pprice, String petc, int phit, String loc,
			String sigungu, String mid) {
		super();
		this.pno = pno;
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.plike = plike;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.phit = phit;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
	}
	
	public PostVO(String ptitle, String pcontent, int pstar, String paddress, String ptime, String ptel, String pprice,
			String petc, String loc, String sigungu, String mid) {
		super();
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.paddress = paddress;
		this.ptime = ptime;
		this.ptel = ptel;
		this.pprice = pprice;
		this.petc = petc;
		this.loc = loc;
		this.sigungu = sigungu;
		this.mid = mid;
	}

	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public ArrayList<String> getPictures() {
		return pictures;
	}
	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPstar() {
		return pstar;
	}
	public void setPstar(int pstar) {
		this.pstar = pstar;
	}
	public int getPlike() {
		return plike;
	}
	public void setPlike(int plike) {
		this.plike = plike;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPetc() {
		return petc;
	}
	public void setPetc(String petc) {
		this.petc = petc;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getPhit() {
		return phit;
	}
	public void setPhit(int phit) {
		this.phit = phit;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public ArrayList<CommentVO> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<CommentVO> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "PostVO [pno=" + pno + ", ptitle=" + ptitle + ", pictures=" + pictures + ", pcontent=" + pcontent
				+ ", pstar=" + pstar + ", plike=" + plike + ", paddress=" + paddress + ", ptime=" + ptime + ", ptel="
				+ ptel + ", pprice=" + pprice + ", petc=" + petc + ", pdate=" + pdate + ", phit=" + phit + ", loc="
				+ loc + ", sigungu=" + sigungu + ", mid=" + mid + ", commentList=" + commentList + "]";
	}
	
}
