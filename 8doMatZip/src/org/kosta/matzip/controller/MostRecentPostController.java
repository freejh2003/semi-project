package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;

public class MostRecentPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno=PostDAO.getInstance().mostRecentPost();
		return "DispatcherServlet?command=postdetail&pno="+pno;
	}

}
