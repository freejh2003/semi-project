<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/home.css"> -->
</head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
function checkForm(){
		var f=document.registerForm;	
		if(f.password.value!=f.repeatpassword.value){
		alert("패스워드와 패스워드 확인이 일치하지 않습니다");
		return false;
		}
}
$(document).ready(function() {
	$("#id").keyup(function() {
		var idValue=$(this).val();
		if(idValue.length < 4 || idValue.length > 10){
			$("#checkResult").text("아이디는 4자이상 10자 이하이어야 합니다.").css("background-color", "red");
			$("#registersubmit").prop("disabled", true);
		}else{
			$.ajax({
				type:"get",
				url:"DispatcherServlet",
				data:"command=idcheck&id="+idValue,
				success:function(data){
					// callback을 의미한다. 성공했을 경우
					// alert(data);
					if(data=="ok"){
						$("#checkResult").text("사용가능").css("background-color", "yellow");
						$("#registersubmit").prop("disabled", false);
					}else{
						$("#checkResult").text("사용불가").css("background-color", "red");
						//alert(idValue+"는 사용할 수 없습니다.");				
							$("#registersubmit").prop("disabled", true);
					}
				}//success
			}); //ajax
		}//else
	})//keyup
})//ready
</script>
  <style type="text/css">
.mytable{
 background: rgba(255, 255, 255, 0.9);
}
</style>
<body>
<div class="row">
<div class="col-sm-12" style="margin-left: 90px;margin-top: 10px;" align="center">
   <form method="post" action="DispatcherServlet" id="newRegisterForm" name="registerForm" onsubmit="return checkForm()">
      <table class="table table-bordered mytable" style="width: 500px;height:400px;">
         <tr>
            <td>아이디</td>
            <td><input type="text" name="id" id="id" required="required"><br><div id="checkResult" style="max-width: 270px;"></div></td>
         </tr>
         <tr>
            <td>패스워드</td>
            <td><input type="password" name="password" required="required"></td>
         </tr>
          <tr>
            <td>패스워드확인</td>
            <td><input type="password" name="repeatpassword" required="required"></td>
         </tr>
         <tr>
            <td>이름</td>
            <td><input type="text" name="name" required="required"></td>
         </tr>
         <tr>
            <td>주소</td>
            <td><input type="text" name="address" required="required"></td>
         </tr>
         <tr>
            <td>전화번호</td>
            <td><input type="text" name="tel" required="required"></td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="가입" id="registersubmit"></td>
         </tr>
         </tbody>
      </table>
      <input type="hidden" name="command" value="mregister">
      <input type="hidden" name="ano" value="1">
      <input type="hidden" name="command" value="idcheck">
   </form>
</div>
</div>
   <br>
</body>
</html>