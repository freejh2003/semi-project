<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js"></script>
<style type="text/css">
        .floating { position: fixed;
         right: 60%; top: 390px; margin-right: -680px;
          text-align:center;
           width: 120px; }
</style>
<div class="floating" style="text-align: right;">
	<b>TOP10</b>
	<div class="cycle-slideshow" data-cycle-timeout=2000>
	<div class="cycle-pager"></div>
	<c:forEach items="${requestScope.Top10_Pictures}" var="pictures">
		<img src="pictures/${pictures}" onclick="window.open('DispatcherServlet?command=imagesearch&ipath=${pictures}')" width="170px" height="200px">
	</c:forEach>
	</div>
</div>


