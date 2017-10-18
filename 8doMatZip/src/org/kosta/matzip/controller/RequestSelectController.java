package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.matzip.model.RequestDAO;
import org.kosta.matzip.model.RequestVO;

public class RequestSelectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reqno=request.getParameter("reqno");
		RequestVO rvo=RequestDAO.getInstance().selectReqByNo(reqno);
		JSONObject obj = new JSONObject(rvo);
		ArrayList<RequestVO> rlist=RequestDAO.getInstance().getRequestList();
		request.setAttribute("rlist",rlist);
		request.setAttribute("responseBody", obj);
		return "AjaxView";
	}

}
