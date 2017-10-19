package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.ListVO;
import org.kosta.matzip.model.PagingBean;
import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class MyFavoriteViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		int tc=PostDAO.getInstance().TotalMyFavCount(mid);
		int np=0;
		if (request.getParameter("np")==null) {
		np=1;
		}else {
		np=Integer.parseInt(request.getParameter("np"));	
		}
		PagingBean rpg=new PagingBean(tc,np);
		int start=rpg.getStartRowNumber();
		int end=rpg.getEndRowNumber();
		ArrayList<PostVO> list=PostDAO.getInstance().MyFavoriteView(start,end);
		ListVO<PostVO> mflv=new ListVO<PostVO>(list,rpg);
		
		HttpSession locsession = request.getSession(false); 
		locsession.setAttribute("mflist",mflv);
		request.setAttribute("url", "../Post/myFavoriteView.jsp");
		return "Template/home.jsp";
	}

}
