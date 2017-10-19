<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<table class="table table-bordered">
<thead>
	<tr>
		<th>NO</th><th>도</th><th>시.군.구</th><th>제목</th><!-- <th>pcontent</th><th>pstar</th> -->
		<th>phit</th><th>pdate</th><!-- <th>plike</th> --><th>mid</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${sessionScope.allplist.list }" var="post">
      <tr>
      	<td>${post.pno }</td>
      	<td>${post.loc }</td>
      	<td>${post.sigungu }</td>
        <td><a href="DispatcherServlet?command=postdetail&pno=${post.pno }">${post.ptitle }</a></td>       
      	<%-- <td>${post.pcontent }</td>
        <td>${post.pstar}</td> --%>
        <td>${post.phit}</td>
        <td>${post.pdate }</td>
        <%-- <td>${post.plike }</td> --%>
        <td>${post.mid }</td>
      </tr>
   </c:forEach>
</tbody>
</table>

<ul class="pagination justify-content-center">
		<c:set value="${sessionScope.allplist.getPagingbean()}" var="pagingbean" />
		<c:if test="${pagingbean.isPreviousPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=allPostView&np=${pagingbean.getStartPageOfPageGroup()-1}">Previous</a>
			</li>
		</c:if>
		<c:forEach begin="${pagingbean.getStartPageOfPageGroup()}" end="${pagingbean.getEndPageOfPageGroup()}" var="num" step="1">
			<c:choose>
				<c:when test="${pagingbean.getNowPage() != num }">
					<li class="page-item active"><a class="page-link"
						href="DispatcherServlet?command=allPostView&np=${num}">${num}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link"
						href="#">${num}</a></li>
				</c:otherwise>
			</c:choose>
	</c:forEach>
		<c:if test="${pagingbean.isNextPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=allPostView&np=${pagingbean.getEndPageOfPageGroup()+1}">Next</a>
			</li>
		</c:if>
	</ul>

</div>