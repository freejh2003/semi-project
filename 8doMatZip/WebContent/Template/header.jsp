<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .btn-default {
      background: #000;
      color: #fff; 
      box-shadow: 1px 2px 5px #000000; 
   }
  .btn-default:hover {
      background: #fff;
      color: #000;
   }
  </style>
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
    &nbsp;<h4 style="margin-left: 200px;"><b style="color: white">${sessionScope.mvo.mname} 님 로그인 </b></h4>
       <form name="BForm" style="margin-left: 205px;">
      </h5><a href="DispatcherServlet?command=logout" style="color: white" onclick="return recheck()">Logout</a></h5>
       </form>
</c:when>
 <c:otherwise>
		<div class="container" style="width: 100%;">
			<form method="post" action="DispatcherServlet" class="form-inline">
				<input type="hidden" name="command" value="login"> &nbsp;
				<div class="form-group-sm" style="margin-right: -110px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="form-control" size="6" name="id"
						placeholder="UserId"> <input type="password" class="form-control"
						size="6" name="password" placeholder="Password"> <input
						type="submit" value="로그인" size="4" class="btn btn-default"> <a
						href="DispatcherServlet?command=mregisterview" type="button"
						class="btn btn-default">회원가입</a>
				</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="DispatcherServlet?command=lostpassword"
						style="color: white">Forgot your password?</a>
			</form>
		</div>
	</c:otherwise>
 </c:choose>