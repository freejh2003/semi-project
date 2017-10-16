package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.MemberDAO;

public class MemberPasswordFindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		String answer=request.getParameter("answer");
		String mpassword=MemberDAO.getInstance().FindPassword(mid,answer);
		request.setAttribute("mpw", mpassword);
		return "Member/findPassword_result.jsp";
	}

}
