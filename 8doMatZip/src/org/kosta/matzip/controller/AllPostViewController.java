package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.ListVO;
import org.kosta.matzip.model.PagingBean;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class AllPostViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
			int tc=PostDAO.getInstance().TotalPostCount();
			int np=0;
			if (request.getParameter("np")==null) {
			np=1;
			}else {
			np=Integer.parseInt(request.getParameter("np"));	
			}
			PagingBean rpg=new PagingBean(tc,np);
			int start=rpg.getStartRowNumber();
			int end=rpg.getEndRowNumber();
			ArrayList<PostVO> sortlist = PostDAO.getInstance().getPostingList(start,end);
			ListVO<PostVO> allplv=new ListVO<PostVO>(sortlist,rpg);
			HttpSession locsession = request.getSession(false); 
			locsession.setAttribute("allplist",allplv);
	      request.setAttribute("url","../Post/allPostList.jsp");
	      return "Template/home.jsp";
	   }

}
