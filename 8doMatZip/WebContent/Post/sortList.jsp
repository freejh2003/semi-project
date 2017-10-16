<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container">
<a href="index.jsp">home</a><br><br>

<table class="table table-bordered">
<thead>
	<tr>
		<th>loc</th><th>sigungu</th><th>ptitle</th><th>pcontent</th><th>pstar</th>
		<th>phit</th><th>pdate</th><th>plike</th><th>mid</th>
	</tr>
</thead>
<tbody>
<c:choose>
<c:when test="${fn:length(requestScope.sortlist)!=0}">
<c:forEach items="${requestScope.sortlist }" var="locpost">
      <tr>
      	<td>${locpost.loc }</td>
      	<td>${locpost.sigungu }</td>
        <td>${locpost.ptitle }</td>       
       	<td>${locpost.pcontent }</td>
        <td>${locpost.pstar}</td>
        <td>${locpost.phit}</td>
        <td>${locpost.pdate }</td>
        <td>${locpost.plike }</td>
        <td>${locpost.mid }</td>
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