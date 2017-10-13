<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/home.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script  type="text/javascript">
	function recheck() {	
		if (confirm("탈퇴 하시겠습니까?")) {
			return true;
		}
		return false;
	}
  </script>
<div class="row">
<div class="col-sm-12">
<form method="post" action="DispatcherServlet">
		<table class="table table-bordered ">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" required="required" value="${requestScope.mvo.mid}" readonly></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required" value="${requestScope.mvo.mpassword}"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required="required" value="${requestScope.mvo.mname}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" required="required" value="${requestScope.mvo.maddress}"></td>
			</tr>
			<tr>
				<td>Tel</td>
				<td><input type="text" name="tel" required="required" value="${requestScope.mvo.mtel}"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정">
				
			</tr>
			</tbody>
		</table>
		<input type="hidden" name="ano" value="1">
		<input type="hidden" name="command" value="mupdate">
	</form>
	</div>
	</div>
	<br>
	<a href="DispatcherServlet?command=mleave&mid=${requestScope.mvo.mid}"  type="button" class="btn btn-default" onclick="return recheck()">회원탈퇴</a>
	<br><br>
	<a href="index.jsp">Home</a>