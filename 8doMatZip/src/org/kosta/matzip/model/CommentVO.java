package org.kosta.matzip.model;

public class CommentVO {
	private String comno;
	private String pno;
	private String mid;
	private String comcontent;
	private String comdate;
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVO(String comno, String pno, String mid, String comcontent, String comdate) {
		super();
		this.comno = comno;
		this.pno = pno;
		this.mid = mid;
		this.comcontent = comcontent;
		this.comdate = comdate;
	}
	public CommentVO(String comcontent) {
		super();
		this.comcontent = comcontent;
	}
	public CommentVO(String pno, String mid, String comcontent) {
		super();
		this.pno = pno;
		this.mid = mid;
		this.comcontent = comcontent;
	}
	public String getComno() {
		return comno;
	}
	public void setComno(String comno) {
		this.comno = comno;
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
	public String getComcontent() {
		return comcontent;
	}
	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}
	public String getComdate() {
		return comdate;
	}
	public void setComdate(String comdate) {
		this.comdate = comdate;
	}
	@Override
	public String toString() {
		return "CommentVO [comno=" + comno + ", pno=" + pno + ", mid=" + mid + ", comcontent=" + comcontent
				+ ", comdate=" + comdate + "]";
	}
	
}
