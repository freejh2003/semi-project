<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.mytable{
 background: rgba(255, 255, 255, 0.9);
}
</style>
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
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(4)").html('<button name="updateExecuteBtn" class="btn btn-danger" type="button">수정완료</button>');
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
				$("#requesttable tr:eq("+ajaxreqno+") td:eq(4)").html('<button name="updateBtn" class="btn btn-danger">수정</button>');
			}
		});  //ajax
		});//click2
	});//ready
</script>

<c:set value="${requestScope.lv}" var="paging" />
<div style="margin-left: 130px;margin-top: 10px;"  align="center">
<table class="table table-bordered mytable" id="requesttable">
<thead>
	<tr>
		<th>NO</th><th>작성자</th><th>요청사항</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody>
	<c:choose>
	<c:when test="${fn:length(requestScope.lv.list)!=0}">
	<c:forEach items="${paging.list}" var="reqpost">
						<tr>
							<td>${reqpost.reqno}</td>
							<td>${reqpost.mid }</td>
							<td>${reqpost.reqcontent }</td>
							<td>${reqpost.reqdate}</td>
							<c:if test="${sessionScope.mvo.mid==reqpost.mid}">
								<td align="center"><button type="button" name="updateBtn" class="btn btn-danger">수정</button></td>
								<td align="center"><a
									href="DispatcherServlet?command=requestdelete&reqno=${reqpost.reqno }"
									type="button" class="btn btn-danger">삭제</a></td>
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
<table class="table table-bordered mytable">
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
	<td align="center"><input type="submit" class="btn btn-danger" value="등록" ></td>
	</tr>
</tbody>
</table>
</form>
</c:if>
</div>
<div style="margin-left: 130px;">
<ul class="pagination justify-content-center">
		<c:set value="${paging.getPagingbean()}" var="pagingbean" />
		<c:if test="${pagingbean.isPreviousPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=requestboard&np=${pagingbean.getStartPageOfPageGroup()-1}">Previous</a>
			</li>
		</c:if>
		<c:forEach begin="${pagingbean.getStartPageOfPageGroup()}" end="${pagingbean.getEndPageOfPageGroup()}" var="num" step="1">
			<c:choose>
				<c:when test="${pagingbean.getNowPage() != num }">
					<li class="page-item active"><a class="page-link"
						href="DispatcherServlet?command=requestboard&np=${num}">${num}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link"
						href="#">${num}</a></li>
				</c:otherwise>
			</c:choose>
	</c:forEach>
		<c:if test="${pagingbean.isNextPageGroup() }">
			<li class="page-item"><a class="page-link"
				href="DispatcherServlet?command=requestboard&np=${pagingbean.getEndPageOfPageGroup()+1}">Next</a>
			</li>
		</c:if>
	</ul>
</div>