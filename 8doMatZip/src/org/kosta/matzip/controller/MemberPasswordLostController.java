package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberPasswordLostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("url", "../Member/passwordrecover.jsp");
		return "Template/home.jsp";
	}

}
