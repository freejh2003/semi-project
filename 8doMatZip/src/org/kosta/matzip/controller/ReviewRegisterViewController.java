package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReviewRegisterViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("mvo")==null) {
		return "Member/login_request.jsp";
		}else {
		request.setAttribute("url", "../Post/postRegister_view.jsp");
		return "Template/home.jsp";
		}
	}

}
