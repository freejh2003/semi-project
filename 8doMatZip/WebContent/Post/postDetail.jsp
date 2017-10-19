<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script src="http://malsup.github.com/jquery.cycle2.js"></script>
 <style type="text/css">
.star_rating {font-size:0; letter-spacing:-4px;}
.star_rating a {
    font-size:22px;
    letter-spacing:0;
    display:inline-block;
    margin-left:5px;
    color:#ccc;
    text-decoration:none;
}
.star_rating a:first-child {margin-left:0;}
.star_rating a.on {color:#ffcc00;}
 </style>
 
 <script type="text/javascript">
 (function(d, s, id) {
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) return;
   js = d.createElement(s); js.id = id;
   js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.10";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));
 
 $( ".star_rating a" ).click(function() {
     $(this).parent().children("a").removeClass("on");
     $(this).addClass("on").prevAll("a").addClass("on");
     return false;
});
 
</script>
<script type="text/javascript">
$(document).ready(function() {
	$("#like").click(function() {
		 $.ajax({
			type:"get",
			url:"DispatcherServlet",
			data:"command=plikeupdate&pno=${requestScope.pvo.pno}",
			success:function(data){
				$("#plike").text(data);	
			}
		}); 
	});	
});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		//제일 하단에 있는 depth1의 댓글을 다는 이벤트
	    $("#commentParentSubmit").click(function() {
	        var pText = $("#commentParentText");
	    	if($.trim(pText.val())==""){
	    		 alert("내용을 입력하세요.");
		            pText.focus();
		            return;
	    	}else{
				$.ajax({
				type:"get",
				url:"DispatcherServlet",
				data:"command=addcomment&pno=${pvo.pno}&mid=${sessionScope.mvo.mid}&comcontent="+pText.val(),
				dataType:"json",
				success:function(data){
					var info="<tr>";
					info+="<td>"+data.comno+"</td>";
					info+="<td>"+data.mid+"</td>";
					info+="<td>"+data.comcontent+"</td>";
					info+="<td align=right>"+data.comdate+"</td>";
					info+="<td><button name=deletecomment class=btn btn-default>x</button></td>";	
					info+="</tr>";
				
					//테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
					if($('#commentTable tr').contents().size()==0){
				            $('#commentTable').append(info);
				        }else{
				            $('#commentTable tr:last').after(info);
				        }
				   $("#commentParentText").val("");
				}
			});//ajax	
			}//else
	    });//댓글달기click
		
	    $("#commentTable :button[name=deletecomment]").click(function() {
	    	var comno = $(this).parent().parent().children().eq(0).html();
	    	var flag = confirm("댓글을 삭제하시겠습니까?");
	    	if(flag){
	    	$.ajax({
				type:"get",
				url:"DispatcherServlet",
				data:"command=deletecomment&pno=${pvo.pno}&comno="+comno,
				dataType:"json",
			});//ajax
			location.reload();
	    	}else{
	    		return;
	    	}
		});//deleteclick
	
	});//ready
</script>

<script type="text/javascript">
function deletecheck(){
	return confirm("리뷰를 삭제하시겠습니까?");
}
</script>
<div class="container">
<div class="col-sm-8">
<a href="index.jsp">home</a><br>
${sessionScope.loc } > ${sessionScope.sigungu}
<br>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>제목</th><th>작성일시</th><th>작성자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
      <tr>
      	<td>${pvo.ptitle }</td>
     	<td>${pvo.pdate }</td>
     	<td>${pvo.mid }</td>
      	<td>${pvo.phit }</td>
      </tr>
	<tr>
		<td colspan="4">
			<div class="cycle-slideshow" data-cycle-timeout=2000>
			<c:forEach items="${pvo.pictures }" var="image">
			<img src="pictures/${image}" width="200" height="150">
			</c:forEach>
			</div>
		</td>
	</tr>

<thead>
	<tr>
		<th colspan="4">내용</th>
	</tr>
</thead>
<tbody>
	<tr>
      	<td colspan="4">${pvo.pcontent }</td>
	</tr>
</tbody>

<thead>
	<tr>
		<th colspan="4">작성자별점</th>
	</tr>
</thead>
<tbody>
	<tr>
      	<td colspan="4">
      	<span class="star_rating"> 
      		<c:forEach begin="1" end="${pvo.pstar }">
    			<a href="#" class="on">★</a>
			</c:forEach>
			<c:forEach begin="1" end="${5-pvo.pstar }">
    			<a href="#">★</a>
   			</c:forEach>
       </span>
       &nbsp;${pvo.pstar }
       </td>
	</tr>
</tbody>
</table>
<span style='float:right'>
	<c:if test="${sessionScope.mvo.mid == requestScope.pvo.mid }">
		<a href="DispatcherServlet?command=updatepostview&pno=${pvo.pno}"><input type="button"  class="btn" value="수정" id="updatepost"></a>
		<a href="DispatcherServlet?command=deletepost&pno=${pvo.pno}"><input type="button"  class="btn" value="삭제" id="deletepost" onclick="return deletecheck()"></a>
	</c:if>
<a href="DispatcherServlet?command=sortbyloc&loc=${pvo.loc }&sigungu=${pvo.sigungu}"><button type="button" id="list" class="btn btn-default">목록</button></a>
</span>
<br><br><br>[댓글리스트]
<table id="commentTable" class="table table-condensed">
<c:forEach items="${requestScope.pvo.commentList }" var="comment">
	<tr>
		<td>${comment.comno }</td>
		<td>${comment.mid }</td><td>${comment.comcontent }</td><td align="right">${comment.comdate }</td>
		<c:if test="${sessionScope.mvo.mid == comment.mid }">
			<td>
			<button name="deletecomment" class="btn btn-default">x</button>
			</td>
		</c:if>
	</tr>
</c:forEach>

</table>
   <table class="table table-condensed">
    <tr>
        <td>
           <span class="form-inline" role="form">               
              <textarea id="commentParentText" class="form-control col-lg-12" rows="4" style="resize: none; width:100%;height:30px" required="required"></textarea><br><br>
           	  <span style='float:right'><input type="button" id="commentParentSubmit" name="commentParentSubmit" class="btn btn-default" value="댓글달기"></span>
           </span>
        </td>
    </tr>
  </table>

</div>
<div class="col-sm-4">
<input type="button" class="btn btn-primary"value="좋아요" id="like">
&nbsp;&nbsp;<span id="plike">${requestScope.pvo.plike}</span>
<br><br>
<b>상세주소</b>&nbsp;&nbsp;${pvo.paddress }<br><br>
<b>전화번호</b>&nbsp;&nbsp;${pvo.ptel }<br><br>
<b>운영시간</b>&nbsp;&nbsp;${pvo.ptime }<br><br>
<b>가격</b>&nbsp;&nbsp;${pvo.pprice }<br><br>
<b>기타</b>&nbsp;&nbsp;${pvo.petc }<br><br>

<c:if test="${sessionScope.mvo!=null}">
<form action="DispatcherServlet">
<input type="hidden" name="command" value="addfavorite">
<input type="hidden" name="mid" value="${sessionScope.mvo.mid}">
<input type="hidden" name="pno" value="${requestScope.pvo.pno}">
	<input type="submit" value="관심맛집등록">
</form>
</c:if>
</div>
</div>

