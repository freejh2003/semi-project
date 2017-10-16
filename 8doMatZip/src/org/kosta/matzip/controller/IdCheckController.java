package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.MemberDAO;

public class IdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String idcomfirm=(String)MemberDAO.getInstance().IdCheck(id);
		String result=null;
				if(idcomfirm==null) {
					result="ok";
				}else {
					result="fail";
				}
				request.setAttribute("responseBody", result);
				return "AjaxView";
	}

}
