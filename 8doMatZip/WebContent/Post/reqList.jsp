<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var reqno="";
	var ajaxval="";
	var reqcon="";
	$(document).ready(function() {
		$("#requesttable").on("click","button[name='updateBtn']",function() {
			reqno=$(this).parent().parent().children().eq(0).html();
			ajaxreqno=($(this).parent().parent().index())+1;
 		$.ajax({
 			type:"post",
			url:"DispatcherServlet",
			data:"command=requestselect&reqno="+reqno,
			dataType:"json",
			success:function(data){
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(2)").html('<textarea class="form-control" name="reqcontent" placeholder="Contents" rows="5" required="required" style="resize: none;">'+data.reqcontent+'</textarea>');
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(4)").html('<button name="updateExecuteBtn" class="btn btn-default" type="button">수정완료</button>');
			}
		}); //ajax
		});//click
		$("#requesttable").on("click","button[name='updateExecuteBtn']",function() {
			reqno=$(this).parent().parent().children().eq(0).html();
			reqcon=$(this).parent().siblings().eq(2).children("textarea").val();
			ajaxreqno=($(this).parent().parent().index())+1;
  		$.ajax({
 			type:"post",
			url:"DispatcherServlet",
			data:"command=requestupdate&reqno="+reqno+"&reqcontent="+reqcon,
			dataType:"json",
			success:function(data){
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(2)").html(reqcon);
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(4)").html('<button name="updateBtn" class="btn btn-default">수정</button>');
			}
		});  //ajax
		});//click2
	});//ready
</script>

<table class="table table-bordered" id="requesttable">
<thead>
	<tr>
		<th>NO</th><th>작성자</th><th>요청사항</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody>
	<c:choose>
	<c:when test="${fn:length(requestScope.rlist)!=0}">
	<c:forEach items="${requestScope.rlist}" var="reqpost">
						<tr>
							<td>${reqpost.reqno}</td>
							<td>${reqpost.mid }</td>
							<td>${reqpost.reqcontent }</td>
							<td>${reqpost.reqdate}</td>
							<c:if test="${sessionScope.mvo.mid==reqpost.mid}">
								<td><button type="button" name="updateBtn" class="btn btn-default">수정</button></td>
								<td><a
									href="DispatcherServlet?command=requestdelete&reqno=${reqpost.reqno }"
									type="button" class="btn btn-default">삭제</a></td>
							</c:if>
						</tr>			
				</c:forEach>
	</c:when>
	<c:otherwise>
	<tr>
		<td colspan="9" align="center">맛집 리뷰 요청이 없습니다.</td>
	</tr>
	</c:otherwise>
	</c:choose>
</tbody>
</table>


<c:if test="${sessionScope.mvo!=null}">
<form method="post" action="DispatcherServlet">
<input type="hidden" value="reqregister" name="command">
<input type="hidden" value="${sessionScope.mvo.mid}" name="mid">
<table class="table table-bordered">
<thead>
	<tr>
		<th></th><th>작성자</th><th colspan="2">요청사항</th>
	</tr>
</thead>
<tbody>
	<tr>
	<td>요청글 작성</td>
	<td>${sessionScope.mvo.mname}</td>
	<td>
	 <textarea class="form-control" id="comments" name="reqcontent" placeholder="Contents" rows="5" required="required" style="resize:none;"></textarea>
	</td>
	<td><input type="submit" value="등록" ></td>
	</tr>
</tbody>
</table>
</form>
</c:if>
