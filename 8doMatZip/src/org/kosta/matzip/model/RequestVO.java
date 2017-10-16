package org.kosta.matzip.model;

public class RequestVO {
	private String reqno;
	private String mid;
	private String reqcontent;
	private String reqdate;
	public RequestVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestVO(String reqno, String mid, String reqcontent, String reqdate) {
		super();
		this.reqno = reqno;
		this.mid = mid;
		this.reqcontent = reqcontent;
		this.reqdate = reqdate;
	}
	public String getReqno() {
		return reqno;
	}
	public void setReqno(String reqno) {
		this.reqno = reqno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getReqcontent() {
		return reqcontent;
	}
	public void setReqcontent(String reqcontent) {
		this.reqcontent = reqcontent;
	}
	public String getReqdate() {
		return reqdate;
	}
	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}
	@Override
	public String toString() {
		return "RequestVO [reqno=" + reqno + ", mid=" + mid + ", reqcontent=" + reqcontent + ", reqdate=" + reqdate
				+ "]";
	}
	
}
