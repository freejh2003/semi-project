<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<form method="post" action="DispatcherServlet">
<input type="hidden" value="findpassword" name="command">
<table class="table table-bordered">
<tr>
<td>아이디</td>
<td><input type="text" name="mid" required="required"></td>
</tr>
<tr>
<td>질문</td>
<td>질문</td>
</tr>
<tr>
<td>답변</td>
<td><input type="text" name="answer" required="required"></td>
</tr>
<Tr><td colspan="2" align="right"><input type="submit" value="비밀번호 찾기"></td></Tr>
</table>
</form>
</body>
</html>