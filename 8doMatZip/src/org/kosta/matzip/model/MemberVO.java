package org.kosta.matzip.model;

import java.util.ArrayList;

public class MemberVO {
	private String mid;
	private String ano;
	private String mpassword;
	private String mname;
	private String maddress;
	private String mtel;
	private RecentBean recentbean;
	private ArrayList<PostVO> myFavList;
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String mid, String mpassword) {
		super();
		this.mid = mid;
		this.mpassword = mpassword;
	}
	
	public MemberVO(String mid, String ano, String mpassword, String mname, String maddress, String mtel,
			RecentBean recentbean, ArrayList<PostVO> myFavList) {
		super();
		this.mid = mid;
		this.ano = ano;
		this.mpassword = mpassword;
		this.mname = mname;
		this.maddress = maddress;
		this.mtel = mtel;
		this.recentbean = recentbean;
		this.myFavList = myFavList;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public RecentBean getRecentbean() {
		return recentbean;
	}

	public void setRecentbean(RecentBean recentbean) {
		this.recentbean = recentbean;
	}

	public ArrayList<PostVO> getMyFavList() {
		return myFavList;
	}

	public void setMyFavList(ArrayList<PostVO> myFavList) {
		this.myFavList = myFavList;
	}

	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", ano=" + ano + ", mpassword=" + mpassword + ", mname=" + mname + ", maddress="
				+ maddress + ", mtel=" + mtel + ", recentbean=" + recentbean + ", myFavList=" + myFavList + "]";
	}
	
}
