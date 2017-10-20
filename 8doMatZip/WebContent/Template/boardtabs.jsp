<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<br><br><br><br><br>
<div align="right">
  <a href="DispatcherServlet?command=showmap"><img src="pictures/로고1.png" width="300" height="250"></a>
</div>
<body>

<!-- <div class="btn-group btn-group-justified" role="group" aria-label="...">
</div> -->


<div class="container" align="center">
  <div class="btn-group btn-group-justified" role="group" aria-label="..." style="width: 100%;">
  	<a href="DispatcherServlet?command=showmap" class="btn btn-danger">HOME</a>
    <a href="DispatcherServlet?command=allPostView" class="btn btn-danger">전체</a>
        <a href="DispatcherServlet?command=reviewregisterView" class="btn btn-danger">리뷰작성</a>
    <a href="DispatcherServlet?command=requestboard" class="btn btn-danger">요청</a>
    <c:if test="${sessionScope.mvo!=null}">
    <div class="btn-group">
      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
      마이페이지 <span class="caret"></span></button>
      <ul class="dropdown-menu" role="menu">
          <li><a href="DispatcherServlet?command=myfavoriteview&mid=${sessionScope.mvo.mid}">관심맛집</a></li>
        <li><a href="DispatcherServlet?command=mupdateview&mid=${sessionScope.mvo.mid}">회원정보수정</a></li>
      </ul>
    </div>
    </c:if>
  </div>
</div>
</body>
</html>