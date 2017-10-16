package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.MemberDAO;

public class MemberLeaveController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		MemberDAO.getInstance().memberLeave(mid);
		return "redirect:DispatcherServlet?command=logout";
	}

}
