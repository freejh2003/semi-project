<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container">
${requestScope.loc } > ${requestScope.sigungu} <br>
<table class="table table-bordered">
<thead>
	<tr>
		<th>NO</th><th>제목</th><th>작성일시</th>
		<th>작성자</th><th>조회수</th>
	</tr>
</thead>
<tbody>
<c:choose>
<c:when test="${fn:length(requestScope.sortlist)!=0}">
<c:forEach items="${requestScope.sortlist }" var="locpost">
      <tr>
      	<td>${locpost.pno }</td>
        <td><a href="DispatcherServlet?command=postdetail&pno=${locpost.pno }">${locpost.ptitle }</a></td>       
        <td>${locpost.pdate }</td>
        <td>${locpost.mid }</td>
        <td>${locpost.phit}</td>
      </tr>
   </c:forEach>
</c:when>
<c:otherwise>
	<tr>
		<td colspan="9" align="center">해당 지역의 맛집 리뷰가 없습니다.</td>
	</tr>
</c:otherwise>
</c:choose>
</tbody>
</table>
</div>