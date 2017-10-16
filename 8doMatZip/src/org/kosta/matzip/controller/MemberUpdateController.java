package org.kosta.matzip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.matzip.model.MemberDAO;
import org.kosta.matzip.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid=request.getParameter("id");
		String ano=request.getParameter("ano");
		String mpassword=request.getParameter("password");
		String mname=request.getParameter("name");
		String maddress=request.getParameter("address");
		String mtel=request.getParameter("tel");
		MemberVO umvo=new MemberVO(mid,ano,mpassword,mname,maddress,mtel);
		MemberDAO.getInstance().memberUpdate(umvo);
		//request.setAttribute("url", "Member/mupdate.jsp");
		return "redirect:Member/mupdate_result.jsp";
	}

}
