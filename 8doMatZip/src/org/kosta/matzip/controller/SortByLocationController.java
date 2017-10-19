package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.ListVO;
import org.kosta.matzip.model.PagingBean;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class SortByLocationController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String loc = request.getParameter("loc");
      String sigungu = request.getParameter("sigungu");
     //ArrayList<PostVO> sortlist = PostDAO.getInstance().PostSortByLocation(loc, sigungu);
      

		int tc=PostDAO.getInstance().TotalCount(loc, sigungu);
		int np=0;
		if (request.getParameter("np")==null) {
			np=1;
		}else {
			np=Integer.parseInt(request.getParameter("np"));	
		}
		PagingBean rpg=new PagingBean(tc,np);
		int start=rpg.getStartRowNumber();
		int end=rpg.getEndRowNumber();
		ArrayList<PostVO> sortlist=PostDAO.getInstance().getAllLocPostList(start,end,loc,sigungu);		
		ListVO<PostVO> loclv=new ListVO<PostVO>(sortlist,rpg);
	      HttpSession locsession = request.getSession(false); 
	      locsession.setAttribute("loc",loc);
	      locsession.setAttribute("sigungu",sigungu);
		locsession.setAttribute("sortlist",loclv);
      request.setAttribute("url","../Post/sortList.jsp");
      return "Template/home.jsp";
   }

}
