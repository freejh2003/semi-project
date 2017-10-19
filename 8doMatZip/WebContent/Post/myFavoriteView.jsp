<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
  <table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>게시글번호</th>
        <th>제목</th>
        <th>별점</th>
        <th>좋아요</th>
        <th>조회수</th>
      </tr>
    </thead>
   <!-- 
	p.pno, p.ptitle, p.pstar, p.plike, p.phit
 -->
    <tbody>
    <c:set value="${sessionScope.mflist}" var="paging" />
      <c:forEach items="${paging.list}" var="myfavlist">
      <tr>
        <td>${myfavlist.pno}</td>
        <td><a href="DispatcherServlet?command=postdetail&pno=${myfavlist.pno}">${myfavlist.ptitle}</a></td>
        <td>${myfavlist.pstar}</td>
        <td>${myfavlist.plike}</td>
        <td>${myfavlist.phit}</td>
		<td><a href="DispatcherServlet?command=myfavdelete&pno=${myfavlist.pno}&mid=${sessionScope.mvo.mid}" type="button" class="btn btn-default">삭제</a></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
</div>

<ul class="pagination justify-content-center">
		<c:set value="${paging.getPagingbean()}" var="pagingbean" />
		<c:if test="${pagingbean.isPreviousPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=myfavoriteview&np=${pagingbean.getStartPageOfPageGroup()-1}">Previous</a>
			</li>
		</c:if>
		<c:forEach begin="${pagingbean.getStartPageOfPageGroup()}" end="${pagingbean.getEndPageOfPageGroup()}" var="num" step="1">
			<c:choose>
				<c:when test="${pagingbean.getNowPage() != num }">
					<li class="page-item active"><a class="page-link"
						href="DispatcherServlet?command=myfavoriteview&np=${num}&mid=${sessionScope.mvo.mid}">${num}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link"
						href="#">${num}</a></li>
				</c:otherwise>
			</c:choose>
	</c:forEach>
		<c:if test="${pagingbean.isNextPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=myfavoriteview&np=${pagingbean.getEndPageOfPageGroup()+1}">Next</a>
			</li>
		</c:if>
	</ul>
