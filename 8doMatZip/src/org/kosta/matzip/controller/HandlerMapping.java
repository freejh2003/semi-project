package org.kosta.matzip.controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller c=null;
		if(command.equals("mainlist")){
			c=new MainListController();
		}else if(command.equals("login")){
			c=new LoginController();
		}
		return c;
	}
}










