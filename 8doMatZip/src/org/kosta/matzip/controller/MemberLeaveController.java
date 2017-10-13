package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.MemberDAO;

public class MemberLeaveController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		MemberDAO.getInstance().memberLeave(mid);
		/*HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();*/
		//request.setAttribute("url", "cityTest.jsp");
		return "redirect:DispatcherServlet?command=logout";
	}

}
