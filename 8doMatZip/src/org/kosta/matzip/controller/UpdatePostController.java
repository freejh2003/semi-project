package org.kosta.matzip.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.matzip.model.PostDAO;
import org.kosta.matzip.model.PostVO;

public class UpdatePostController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
         HttpSession locsession = request.getSession(false);       
         String pno = request.getParameter("pno");
          String ptitle=request.getParameter("title");
          ArrayList<String> pictures = PostDAO.getInstance().findImageByPno(pno);
            String pcontent=request.getParameter("content");
            int pstar =(Integer.parseInt(request.getParameter("pstar")));
            int plike = PostDAO.getInstance().findPostByPno(pno).getPlike();
            String paddress=request.getParameter("address");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            String ptime=startTime+"~"+endTime;
            String tel1=request.getParameter("tel1");
            String tel2=request.getParameter("tel2");
            String tel3=request.getParameter("tel3");
            String ptel=tel1+"-"+tel2+"-"+tel3;
            String pprice=request.getParameter("price");
            String petc=request.getParameter("etc");
            String mid=request.getParameter("mid");
            int phit=(Integer.parseInt(request.getParameter("phit")));
            String loc=request.getParameter("loc");
            String sigungu=request.getParameter("sigungu");
            locsession.setAttribute("loc",loc);
          locsession.setAttribute("sigungu",sigungu);
            PostVO pvo=new PostVO(pno,ptitle,pictures, pcontent,pstar,plike,paddress, ptime, ptel, pprice, petc,phit,loc,sigungu, mid);
            PostVO updatedpvo = PostDAO.getInstance().updatePost(pvo);
            return "DispatcherServlet?command=postdetail&pno="+updatedpvo.getPno();
   }

}