package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class SortByLocation implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loc = request.getParameter("loc");
		String sigungu = request.getParameter("sigungu");
		ArrayList<PostVO> sortlist = PostDAO.getInstance().PostSortByLocation(loc, sigungu);
		
		request.setAttribute("sortlist",sortlist);
		request.setAttribute("url","../Post/sortList.jsp");
		return "Template/home.jsp";
	}

}
