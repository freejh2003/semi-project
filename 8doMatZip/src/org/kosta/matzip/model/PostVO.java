package org.kosta.matzip.model;

import java.util.ArrayList;

public class PostVO {
	private String pno;
	private String mid;
	private String ptitle;
	private ArrayList<String> pictures;
	private String pcontent;
	private int pstar;
	private String pdate;
	private int phit;
	private int plike;
	private String loc;
	private String sigungu;
	private ArrayList<CommentVO> commentList;
	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostVO(String pno, String mid, String ptitle, String pcontent, int pstar, String pdate, int phit, int plike,
			String loc, String sigungu) {
		super();
		this.pno = pno;
		this.mid = mid;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.pdate = pdate;
		this.phit = phit;
		this.plike = plike;
		this.loc = loc;
		this.sigungu = sigungu;
	}

	public PostVO(String pno, String mid, String ptitle, String pcontent, int pstar, String pdate, int phit, int plike,
			String loc, String sigungu, ArrayList<CommentVO> commentList) {
		super();
		this.pno = pno;
		this.mid = mid;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.pdate = pdate;
		this.phit = phit;
		this.plike = plike;
		this.loc = loc;
		this.sigungu = sigungu;
		this.commentList = commentList;
	}

	public PostVO(String pno, String mid, String ptitle, ArrayList<String> pictures, String pcontent, int pstar,
			String pdate, int phit, int plike, String loc, String sigungu, ArrayList<CommentVO> commentList) {
		super();
		this.pno = pno;
		this.mid = mid;
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.pdate = pdate;
		this.phit = phit;
		this.plike = plike;
		this.loc = loc;
		this.sigungu = sigungu;
		this.commentList = commentList;
	}
	
	public PostVO(String ptitle, ArrayList<String> pictures, String pcontent, int pstar, String loc, String sigungu) {
		super();
		this.ptitle = ptitle;
		this.pictures = pictures;
		this.pcontent = pcontent;
		this.pstar = pstar;
		this.loc = loc;
		this.sigungu = sigungu;
	}
	
	public ArrayList<String> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
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

	public int getPlike() {
		return plike;
	}

	public void setPlike(int plike) {
		this.plike = plike;
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

	public ArrayList<CommentVO> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<CommentVO> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "PostVO [pno=" + pno + ", mid=" + mid + ", ptitle=" + ptitle + ", pictures=" + pictures + ", pcontent="
				+ pcontent + ", pstar=" + pstar + ", pdate=" + pdate + ", phit=" + phit + ", plike=" + plike + ", loc="
				+ loc + ", sigungu=" + sigungu + ", commentList=" + commentList + "]";
	}

	
	
}
