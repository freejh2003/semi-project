package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class MainListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//PagingBean bean = new PagingBean(PostDAO.getInstance().getTotalPostCount());
	      ArrayList<PostVO> plist = PostDAO.getInstance().getPostingList();
	      /*if(request.getParameter("nowPage") != null) {
	         int nowPage = Integer.parseInt(request.getParameter("nowPage"));
	        // bean = new PagingBean(PostDAO.getInstance().getTotalPostCount(),nowPage);
	         bean.setNowPage(nowPage);
	}*/
	   
	      //ListVO<PostVO> lvo = new ListVO<PostVO>(plist,bean);
	      request.setAttribute("plist",plist);
	      request.setAttribute("url","allPostList.jsp");
	      return "home.jsp";
	}

}
