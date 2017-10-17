<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script  type="text/javascript">
	function recheck() {
		var f = document.BForm;
		if (confirm("로그아웃 하시겠습니까?")) {
			f.submit();
			return true;
		}
		return false;
	}
  </script>
 <c:choose>
 <c:when test="${sessionScope.mvo!=null}">
 	${sessionScope.mvo.mname} 님 로그인 <br>
 		<form name="BForm">
		<a href="DispatcherServlet?command=logout"  onclick="return recheck()">로그아웃</a> &nbsp;
		<%-- <a href="DispatcherServlet?command=mupdateview&mid=${sessionScope.mvo.mid}">마이페이지</a> --%>
 		</form>
		<br>
 </c:when>
 <c:otherwise>
 <form method="post" action="DispatcherServlet">
 <input type="hidden" name="command" value="login">
	<table class="table table-bordered table-hover">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" size="6" class="form-control"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" size="6" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="로그인" class="btn btn-default"> &nbsp;
				<a href="DispatcherServlet?command=mregisterview"  type="button" class="btn btn-default">회원가입</a>
			</td>
		
		
		</tr>
	</table>
	<a href="DispatcherServlet?command=lostpassword" >아이디까먹음?</a>
</form>
 </c:otherwise>
 </c:choose>
