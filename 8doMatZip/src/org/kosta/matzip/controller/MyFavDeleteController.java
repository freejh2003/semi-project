package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;

public class MyFavDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		String pno=request.getParameter("pno");
		PostDAO.getInstance().DeleteFavorite(mid, pno);
		return "redirect:Post/goPrevPage.jsp";
	}

}
