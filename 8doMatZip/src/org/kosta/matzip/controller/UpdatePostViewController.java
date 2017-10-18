package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class UpdatePostViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pno = request.getParameter("pno");
		PostVO updatepvo = PostDAO.getInstance().findPostByPno(pno);
		request.setAttribute("updatepvo",updatepvo);
		request.setAttribute("url","../Post/updatePostView.jsp");
		return "Template/home.jsp";
	}

}
