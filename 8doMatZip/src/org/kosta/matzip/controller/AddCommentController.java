package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.matzip.model.CommentVO;
import org.kosta.matzip.model.PostDAO;

public class AddCommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		String mid = request.getParameter("mid");
		String comcontent = request.getParameter("comcontent");
		CommentVO cvo = PostDAO.getInstance().addComment(new CommentVO(pno,mid,comcontent));
		JSONObject json = new JSONObject(cvo);
		request.setAttribute("responseBody",json);
		return "AjaxView";
	}

}
