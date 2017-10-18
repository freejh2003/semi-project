package org.kosta.matzip.controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller c=null;
		if (command.equals("showmap")) {
			c = new ShowMapController();
		} else if (command.equals("login")) {
			c = new LoginController();
		} else if (command.equals("logout")) {
			c = new LogoutController();
		} else if (command.equals("mregister")) {
			c = new MemberRegisterController();
		} else if (command.equals("mregisterview")) {
			c = new MemberRegisterViewController();
		} else if (command.equals("mupdate")) {
			c = new MemberUpdateController();
		} else if (command.equals("mupdateview")) {
			c = new MemberUpdateViewController();
		} else if (command.equals("mleave")) {
			c = new MemberLeaveController();
		} else if (command.equals("lostpassword")) {
			c = new MemberPasswordLostController();
		} else if (command.equals("idcheck")) {
			c = new IdCheckController();
		} else if (command.equals("sortbyloc")) {
			c = new SortByLocationController();
		} else if (command.equals("findpassword")) {
			c = new MemberPasswordFindController();
		} else if (command.equals("postdetail")) {
			c = new PostDetailController();
		} else if (command.equals("requestboard")) {
			c = new RequestBoardController();
		} else if (command.equals("reqregister")) {
			c = new RequestRegisterController();
		} else if (command.equals("requestdelete")) {
			c = new RequestDeleteController();
		}	else if (command.equals("requestselect")) {
			c = new RequestSelectController();
		}	else if (command.equals("requestupdate")) {
			c = new RequestUpdateController();
		}else if(command.equals("plikeupdate")) {
			c= new PlikeUpdateController();
		}else if(command.equals("updatepostview")) {
			c = new UpdatePostViewController();
		}else if(command.equals("updatepost")) {
			c = new UpdatePostController();
		} else if(command.equals("deletepost")) {
			c = new DeletePostController();
		} else if(command.equals("addcomment")) {
			c = new AddCommentController();
		} else if(command.equals("deletecomment")) {
			c = new DeleteCommentController();
		}else if(command.equals("reviewregister")) {
			c = new ReviewRegisterController();
		}else if(command.equals("reviewregisterView")) {
			c = new ReviewRegisterViewController();
		}else if(command.equals("mostRecentPost")) {
			c= new MostRecentPostController();
		}else if(command.equals("imageupload")) {
			c = new ImageUploadController();
		}
		return c;
	}
}










