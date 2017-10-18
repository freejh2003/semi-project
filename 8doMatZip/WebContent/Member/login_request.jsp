<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var flag=confirm("로그인하셔야 이용가능합니다 로그인 하시겠습니까?");
	if(flag){
		location.href="index.jsp";
	}else{
		history.go(-1);
	}
</script>