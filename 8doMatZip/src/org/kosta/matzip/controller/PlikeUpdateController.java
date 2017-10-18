package org.kosta.matzip.controller;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;

public class PlikeUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		int plike = PostDAO.getInstance().updateLike(pno);
		PrintWriter out=response.getWriter();
		out.print(plike);
		out.close();
		return "Template/home.jsp";
	}

}
