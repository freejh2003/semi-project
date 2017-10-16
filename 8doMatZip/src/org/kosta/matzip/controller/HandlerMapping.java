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
		}else if(command.equals("logout")){
			c=new LogoutController();
		}else if(command.equals("mregister")){
			c=new MemberRegisterController();
		}else if(command.equals("mregisterview")){
			c=new MemberRegisterViewController();
		}else if(command.equals("mupdate")){
			c=new MemberUpdateController();
		}else if(command.equals("mupdateview")){
			c=new MemberUpdateViewController();
		}else if(command.equals("mleave")){
			c=new MemberLeaveController();
		}else if(command.equals("lostpassword")){
			c=new MemberPasswordLostController();
		}else if(command.equals("idcheck")) {
	    	  c=new IdCheckController(); 
	      }
		return c;
	}
}










