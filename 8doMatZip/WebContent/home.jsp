<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item list</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/home.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
				<div class="col-sm-8">

			</div>
			<div class="col-sm-4">
					<jsp:include page="Template/header.jsp" />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-10 main">
				 <jsp:include page="cityTest.jsp" />
			</div>
				<div class="col-sm-2">

			</div>
		</div>
	</div>
			<div class="footer">
			<jsp:include page="Template/footer.jsp" />
		</div>
</body>
</html>