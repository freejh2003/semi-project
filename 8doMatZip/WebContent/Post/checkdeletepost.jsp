<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var flag = confirm("리뷰를 삭제하시겠습니까?");
	if(flag)
		location.href="DispatcherServlet?command=deletepost";
	else
		history.go(-1);
</script>