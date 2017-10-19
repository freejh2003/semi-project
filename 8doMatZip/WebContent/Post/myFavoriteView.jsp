<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

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
      <c:forEach items="${requestScope.list}" var="myfavlist">
      <tr>
        <td>${myfavlist.pno}</td>
        <td><a href="DispatcherServlet?command=postdetail&pno=${myfavlist.pno}">${myfavlist.ptitle}</a></td>
        <td>${myfavlist.pstar}</td>
        <td>${myfavlist.plike}</td>
        <td>${myfavlist.phit}</td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
