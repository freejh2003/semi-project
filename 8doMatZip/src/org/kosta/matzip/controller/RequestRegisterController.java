package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.RequestDAO;

public class RequestRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		String reqcontent=request.getParameter("reqcontent");
		RequestDAO.getInstance().getRequestResgister(mid, reqcontent);
		return "redirect:DispatcherServlet?command=requestboard";
	}

}
