<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
		var password='<c:out value="${requestScope.mpw}"/>';
		if (password=="not found"){
			alert("답변이 일치하지 않습니다");
			location.href="DispatcherServlet?command=showmap";
		}else{
			alert("비밀번호는 "+password+" 입니다.");
			location.href="DispatcherServlet?command=showmap";
		}
</script>