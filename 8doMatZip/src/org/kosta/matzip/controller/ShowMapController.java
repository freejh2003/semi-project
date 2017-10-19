package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;


public class ShowMapController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> pno=PostDAO.getInstance().showTopPostPno();
		ArrayList<String> pictures=PostDAO.getInstance().showTopList();
		System.out.println("pictures:" + pictures);
		request.setAttribute("Top10_Pictures", pictures);
		request.setAttribute("pno", pno);
		request.setAttribute("url_top10", "rightlist.jsp");
		request.setAttribute("url","mainMap.jsp");
		return "Template/home.jsp";
	}

}
