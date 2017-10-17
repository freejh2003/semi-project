package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.RequestDAO;
import org.kosta.matzip.model.RequestVO;

public class RequestBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<RequestVO> rlist=RequestDAO.getInstance().getRequestList();
		request.setAttribute("rlist",rlist);
		request.setAttribute("url","../Post/reqList.jsp");
		return "Template/home.jsp";
	}

}
