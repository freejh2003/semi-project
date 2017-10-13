<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/home.css">
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
	$(document).ready(function() {
		$("#loginform :submit[value=로그인]").click(function() {
			$("#hiddenvalue").val("login");
		})
		$("#loginform :submit[value=회원가입]").click(function() {
			$("#hiddenvalue").val("mregister");
		})
		
	})
  </script>
 <c:choose>
 <c:when test="${sessionScope.mvo!=null}">
 	${sessionScope.mvo.mname} 님 로그인 <br>
 		<form name="BForm">
		<a href="DispatcherServlet?command=logout" onclick="return recheck()">로그아웃</a>
 		</form>
		<br>
 </c:when>
 <c:otherwise>
 <form id="loginform" method="post" action="DispatcherServlet" name="loginform">
 <input id="hiddenvalue" type="hidden" name="command" value="">
	<table class="table table-bordered table-hover">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" size="6" class="form-control"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password" size="6" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="로그인" class="btn btn-default"> &nbsp;
				<input type="button" value="회원가입" class="btn btn-default">
			</td>
		
		
		</tr>
	</table>
</form>
 </c:otherwise>
 </c:choose>
