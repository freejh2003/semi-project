<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script src="http://malsup.github.com/jquery.cycle2.js"></script>
<div class="container">
<a href="index.jsp">home</a><br>
${requestScope.pvo.loc } > ${requestScope.pvo.sigungu} <br>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>제목</th><th>작성일시</th><th>작성자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
      <tr>
      	<td>${pvo.ptitle }</td>
     	<td>${pvo.pdate }</td>
     	<td>${pvo.mid }</td>
      	<td>${pvo.phit }</td>
      </tr>
	<tr>
		<td colspan="4">
			<div class="cycle-slideshow" data-cycle-timeout=2000>
			<c:forEach items="${pvo.pictures }" var="image">
			<img src="pictures/${image}" width="200" height="150">
			</c:forEach>
			</div>
		</td>
	</tr>

<thead>
	<tr>
		<th colspan="4">내용</th>
	</tr>
</thead>
<tbody>
	<tr>
      	<td colspan="4">${pvo.pcontent }</td>
	</tr>
</tbody>

<thead>
	<tr>
		<th colspan="4">작성자별점</th>
	</tr>
</thead>
<tbody>
	<tr>
      	<td colspan="4">${pvo.pstar }</td>
	</tr>
</tbody>

<thead>
	<tr>
		<th>게시글좋아요</th>
		<th>상세주소</th>
		<th>전화번호</th>
		<th>운영시간</th>
		<th>가격</th>
		<th>기타</th>
	</tr>
</thead>	
<tbody>
	<tr>
		<td>${pvo.plike }</td>
      	<td>${pvo.paddress }</td>
      	<td>${pvo.ptel }</td>
      	<td>${pvo.ptime }</td>
      	<td>${pvo.pprice }</td>
      	<td>${pvo.petc }</td>
     </tr>
</tbody>
</table>
</div>