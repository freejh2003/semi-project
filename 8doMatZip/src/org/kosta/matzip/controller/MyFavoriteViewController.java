package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class MyFavoriteViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		ArrayList<PostVO> list=new ArrayList<PostVO>();
		list=PostDAO.getInstance().MyFavoriteView(mid);
		request.setAttribute("list", list);
		request.setAttribute("url", "../Post/myFavoriteView.jsp");
		return "Template/home.jsp";
	}

}
