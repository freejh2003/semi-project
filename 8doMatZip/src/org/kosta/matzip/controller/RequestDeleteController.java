package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.RequestDAO;

public class RequestDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reqno=request.getParameter("reqno");
		RequestDAO.getInstance().requestDelete(reqno);
		
		return "redirect:DispatcherServlet?command=requestboard";
	}

}
