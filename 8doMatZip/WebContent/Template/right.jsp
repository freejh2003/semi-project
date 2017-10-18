<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel"> <!-- top -->
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="pictures/로고1.png" alt="top1" width="400" height="700" >
        <div class="carousel-caption">
          <h5>top1</h5>
          <p>arrrgrrggrgrgrgrgrg</p>
        </div>      
      </div>

      <div class="item">
        <img src="pictures/초밥1.png" alt="top2" width="400" height="700">
        <div class="carousel-caption">
          <h5>top2</h5>
          <p>thwuthwuthwuthwuthwuthwuthwuthwu</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="pictures/초밥2.png" alt="top3" width="400" height="700" >
        <div class="carousel-caption">
          <h5>top3</h5>
          <p>watevawatevawatevawhatever</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div><Br><br>
<c:if test="${sessionScope.mvo!=null&&sessionScope.mvor!=null}">
<c:set value="${requestScope.pvo }" var="pvoinfo"/>
<div id="myCarousel" class="carousel slide" data-ride="carousel"> <!-- recent -->
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${pvoinfo.pictures }" alt="${pvoinfo.pno }" width="400" height="700" >
        <div class="carousel-caption">
          <h5>${pvoinfo.title }</h5>
          <p></p>
        </div>      
      </div>
      </div>
	<c:forEach items="${pvoinfo}" var="pvoinfolist" begin="1">
      <div class="item">
        <img src="${pvoinfolist.pictures }" alt="${pvoinfolist.pno }" width="400" height="700">
        <div class="carousel-caption">
          <h5>${pvoinfolist.title }</h5>
          <p></p>
        </div>      
      </div>
	</c:forEach>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</c:if>

</body>
</html>