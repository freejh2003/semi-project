package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.ListVO;
import org.kosta.matzip.model.PagingBean;
import org.kosta.matzip.model.RequestDAO;
import org.kosta.matzip.model.RequestVO;

public class RequestBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tc=RequestDAO.getInstance().TotalCount();
		//PagingBean pg=new PagingBean(tc);
		int np=0;
		if (request.getParameter("np")==null) {
		//np=pg.getTotalPage();
		np=1;
		}else {
		np=Integer.parseInt(request.getParameter("np"));	
		}
		
		PagingBean rpg=new PagingBean(tc,np);
		int start=rpg.getStartRowNumber();
		int end=rpg.getEndRowNumber();
		ArrayList<RequestVO> list=RequestDAO.getInstance().getAllPostList(start,end);		
		ListVO<RequestVO> lv=new ListVO<RequestVO>(list,rpg);
		request.setAttribute("lv", lv);
		
		//ArrayList<RequestVO> rlist=RequestDAO.getInstance().getRequestList();
		//request.setAttribute("rlist",rlist);
		request.setAttribute("url","../Post/reqList.jsp");
		return "Template/home.jsp";
	}

}
