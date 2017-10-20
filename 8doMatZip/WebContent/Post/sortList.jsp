<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style type="text/css">
.mytable{
 background: rgba(255, 255, 255, 0.9);
}
</style>
<div class="container">
${sessionScope.loc } > ${sessionScope.sigungu} <br>
<c:set value="${sessionScope.sortlist}" var="locpaging" />

<table class="table table-bordered mytable">
<thead>
	<tr>
		<th>NO</th><th>제목</th><th>작성일시</th>
		<th>작성자</th><th>조회수</th>
	</tr>
</thead>
<tbody>
<c:choose>
<c:when test="${fn:length(sessionScope.sortlist.list)!=0}">
<c:forEach items="${locpaging.list}" var="locpost">
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


<ul class="pagination justify-content-center">
		<c:set value="${locpaging.getPagingbean()}" var="locpagingbean" />
		<c:if test="${locpagingbean.isPreviousPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=sortbyloc&np=${locpagingbean.getStartPageOfPageGroup()-1}&loc=${sessionScope.loc }&sigungu=${sessionScope.sigungu}">Previous</a>
			</li>
		</c:if>
		<c:forEach begin="${locpagingbean.getStartPageOfPageGroup()}" end="${locpagingbean.getEndPageOfPageGroup()}" var="num" step="1">
			<c:choose>
				<c:when test="${locpagingbean.getNowPage() != num }">
					<li class="page-item active"><a class="page-link"
						href="DispatcherServlet?command=sortbyloc&np=${num}&loc=${sessionScope.loc }&sigungu=${sessionScope.sigungu}">${num}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link"
						href="#">${num}</a></li>
				</c:otherwise>
			</c:choose>
	</c:forEach>
		<c:if test="${locpagingbean.isNextPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=sortbyloc&np=${locpagingbean.getEndPageOfPageGroup()+1}&loc=${sessionScope.loc }&sigungu=${sessionScope.sigungu}">Next</a>
			</li>
		</c:if>
	</ul>
</div>