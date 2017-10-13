<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
	<form method="post" action="DispatcherServlet">
		<table class="registerTable">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="가입"></td>
			</tr>
			</tbody>
		</table>
		<input type="hidden" name="command" value="register">
	</form>
	<br>
	<a href="index.jsp">Home</a>
</body>
</html>