package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.CommentVO;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class DeleteCommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		String comno = request.getParameter("comno");
		PostDAO.getInstance().deleteComment(comno);
		PostVO pvo = PostDAO.getInstance().findPostByPno(pno);
		ArrayList<CommentVO> clist = PostDAO.getInstance().getCommentList(pno);
		pvo.setCommentList(clist);
		request.setAttribute("pvo",pvo);
		request.setAttribute("url","../Post/postDetail.jsp");
		return "Template/home.jsp";
	}

}
