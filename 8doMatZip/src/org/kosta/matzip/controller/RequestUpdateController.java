package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.RequestDAO;

public class RequestUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reqno=request.getParameter("reqno");
		String reqcontent=request.getParameter("reqcontent");
		RequestDAO.getInstance().requestUpdate(reqno,reqcontent);
		
		return "redirect:DispatcherServlet?command=requestselect";
	}

}
