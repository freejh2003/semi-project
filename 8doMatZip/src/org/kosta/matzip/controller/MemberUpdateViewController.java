package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.MemberDAO;
import org.kosta.matzip.model.MemberVO;

public class MemberUpdateViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		MemberVO mvo=MemberDAO.getInstance().FindMemberById(mid);
		request.setAttribute("mvo", mvo);
		request.setAttribute("url", "Member/mupdate.jsp");
		return "home.jsp";
	}

}
