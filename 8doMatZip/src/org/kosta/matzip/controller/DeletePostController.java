package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class DeletePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession locsession = request.getSession(false); 
		String pno = request.getParameter("pno");
		PostVO pvo = PostDAO.getInstance().findPostByPno(pno);
		String loc = pvo.getLoc();
		String sigungu = pvo.getSigungu();
		PostDAO.getInstance().deletePost(pno);
		ArrayList<PostVO> sortlist = PostDAO.getInstance().PostSortByLocation(loc, sigungu);
		locsession.setAttribute("sortlist",sortlist);
		request.setAttribute("url","../Post/sortList.jsp");
		return "Template/home.jsp";
	}

}
