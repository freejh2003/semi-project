<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<table class="table table-bordered">
<thead>
	<tr>
		<th>loc</th><th>sigungu</th><th>ptitle</th><th>pcontent</th><th>pstar</th>
		<th>phit</th><th>pdate</th><th>plike</th><th>mid</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.plist }" var="post">
      <tr>
      	<td>${post.loc }</td>
      	<td>${post.sigungu }</td>
        <td>${post.ptitle }</td>       
       	<td>${post.pcontent }</td>
        <td>${post.pstar}</td>
        <td>${post.phit}</td>
        <td>${post.pdate }</td>
        <td>${post.plike }</td>
        <td>${post.mid }</td>
      </tr>
   </c:forEach>
</tbody>
</table>
</div>