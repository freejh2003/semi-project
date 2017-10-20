package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;

public class AddFavoriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		String pno=request.getParameter("pno");
		int exist=PostDAO.getInstance().SelectMyFavBy(mid, pno);
		if(exist==0) {
		PostDAO.getInstance().AddFavorite(mid, pno);
		return "redirect:Post/addFavorite_result.jsp";
		} else {
		return "redirect:Post/addFavorite_fail.jsp";
		}
		
	}

}
