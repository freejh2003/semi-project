package org.kosta.matzip.model;

import java.util.ArrayList;

public class ListVO<T> {
	private ArrayList<T> list;
	private PagingBean pagingbean;
	public ArrayList<T> getList(){
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}
	public ListVO(ArrayList<T> list, PagingBean pagingbean) {
		super();
		this.list = list;
		this.pagingbean = pagingbean;
	}
	public PagingBean getPagingbean() {
		return pagingbean;
	}
	public void setPagingbean(PagingBean pagingbean) {
		this.pagingbean = pagingbean;
	}
	
}
