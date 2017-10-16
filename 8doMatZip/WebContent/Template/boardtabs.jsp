<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
<div align="left">
  <a href="DispatcherServlet?command=showmap"><img src="pictures/로고1.png" width="300" height="250"></a>
</div>
<div class="container">
  <div class="btn-group">
  	<button type="button" class="btn btn-primary">Home</button>
    <button type="button" class="btn btn-primary">전체</button>
    <button type="button" class="btn btn-primary">요청</button>
    <div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      마이페이지 <span class="caret"></span></button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">관심맛집</a></li>
        <li><a href="#">회원정보수정</a></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>