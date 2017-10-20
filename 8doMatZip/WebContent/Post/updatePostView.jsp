<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	function checkConfirm() {
		return confirm("수정 하시겠습니까?");
	}
	function goback(){
		history.go(-1);
	}
 $(document).ready(function() {
	 $(".star_rating a").removeClass("on");
	 $( ".star_rating a" ).click(function() {
	     $(this).addClass("on").prevAll("a").addClass("on");
	     var star = $(this).prevAll("a").length+1;
	     $("#pstar").text(star);
	     $("#pstarhidden").val(star);
	     $( ".star_rating a" ).click(function() {
	     	if(($(this).prevAll("a").length+1)<star){
	     		$(".star_rating a").removeClass("on");    	
	     		$(this).addClass("on").prevAll("a").addClass("on");
	     	}
	     });
	});
 });//ready
</script>

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
<div class="panel panel-default" style="padding: 30px;margin-left: 130px; margin-top: 10px;">
  <div class="panel-body" style="padding: 15px;"><font size="12px">맛집 리뷰 수정</font></div>
<div align="left" class="form-group" >
<form action="DispatcherServlet" method="post" enctype="multipart/form-data" onsubmit="return checkConfirm()">
<input type="hidden" name="command" value="updatepost">
<input type="hidden" name="mid" value="${sessionScope.mvo.mid}">
<input type="hidden" name="phit" value="${requestScope.updatepvo.phit}">
<input type="hidden" name="pno" value="${requestScope.updatepvo.pno}">

제목 <input type="text"  class="form-control" name="title" value="${requestScope.updatepvo.ptitle }"><br>
내용
<textarea name="content" class="form-control" rows="8" cols="100"></textarea><br><br>
<span class="glyphicon glyphicon-search"></span>사진1<input type="file" name="filename"><br>
<span class="glyphicon glyphicon-search"></span>사진2<input type="file" name="filename2"><br>
별점&nbsp;
<span class="star_rating">
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
</span>
<input type="hidden" name="pstar" value="" id="pstarhidden">
<span id="pstar"></span><br>
이용시간&nbsp;
<select name="startTime">
    <option value="">시간선택</option>
    <option value="00:00">00:00</option>
    <option value="01:00">01:00</option>
    <option value="02:00">02:00</option>
    <option value="03:00">03:00</option>
    <option value="04:00">04:00</option>
    <option value="05:00">05:00</option>
    <option value="06:00">06:00</option>
    <option value="07:00">07:00</option>
    <option value="08:00">08:00</option>
    <option value="09:00">09:00</option>
    <option value="10:00">10:00</option>
    <option value="11:00">11:00</option>
    <option value="12:00">12:00</option>
    <option value="13:00">13:00</option>
    <option value="14:00">14:00</option>
    <option value="15:00">15:00</option>
    <option value="16:00">16:00</option>
    <option value="17:00">17:00</option>
    <option value="18:00">18:00</option>
    <option value="19:00">19:00</option>
    <option value="20:00">20:00</option>
    <option value="21:00">21:00</option>
    <option value="22:00">22:00</option>
    <option value="23:00">23:00</option>
    <option value="24:00">24:00</option>
</select> &nbsp;&nbsp; ~ &nbsp;&nbsp;
<select name="endTime">
  <option value="">close</option>
    <option value="24:00">00:00</option>
    <option value="01:00">01:00</option>
    <option value="02:00">02:00</option>
    <option value="03:00">03:00</option>
    <option value="04:00">04:00</option>
    <option value="05:00">05:00</option>
    <option value="06:00">06:00</option>
    <option value="07:00">07:00</option>
    <option value="08:00">08:00</option>
    <option value="09:00">09:00</option>
    <option value="10:00">10:00</option>
    <option value="11:00">11:00</option>
    <option value="12:00">12:00</option>
    <option value="13:00">13:00</option>
    <option value="14:00">14:00</option>
    <option value="15:00">15:00</option>
    <option value="16:00">16:00</option>
    <option value="17:00">17:00</option>
    <option value="18:00">18:00</option>
    <option value="19:00">19:00</option>
    <option value="20:00">20:00</option>
    <option value="21:00">21:00</option>
    <option value="22:00">22:00</option>
    <option value="23:00">23:00</option>
    <option value="24:00">24:00</option>
</select>
<br>
전화번호&nbsp;
<select name="tel1">
  <option value="">지역 번호</option>
    <option value="02">02</option>
    <option value="031">031</option>
    <option value="032">032</option>
    <option value="033">033</option>
    <option value="041">042</option>
    <option value="042">042</option>
    <option value="043">043</option>
    <option value="051">051</option>
    <option value="052">052</option>
    <option value="053">053</option>
    <option value="054">054</option>
    <option value="055">055</option>
    <option value="061">061</option>
    <option value="062">062</option>
    <option value="063">063</option>
    <option value="064">064</option>
</select>
<script type="text/javascript">
function checkNumber(check_form){
    var numPattern = /([^0-9])/;
    var numPattern = check_form.value.match(numPattern);
    if(numPattern != null){
        alert!("숫자만 입력해 주세요!");
        check_form.value = "";
        check_form.focus();
        return false;
    }
}
</script>
&nbsp;-&nbsp;
 <input type="text" name="tel2" size=4  onchange="checkNumber(this.form.elements['number'])" maxlength=4>
&nbsp;-&nbsp;
 <input type="text" name="tel3" size=4  onchange="checkNumber(this.form.elements['number'])" maxlength=4>
 <br><br>
가격&nbsp;<input type="text" name="price" value="${requestScope.updatepvo.pprice }"><br>
<script type="text/javascript">
$('document').ready(function() {
 var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
   var area3 = ["대덕구","동구","서구","유성구","중구"];
   var area4 = ["광산구","남구","동구","북구","서구"];
   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
   var area6 = ["남구","동구","북구","중구","울주군"];
   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
   var area15 = ["거제시","김해시","밀양시","사천시","양산시","진주시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
   var area16 = ["서귀포시","제주시"];
 
 // 시/도 선택 박스 초기화
 $("select[name^=loc]").each(function() {
  $selloc = $(this);
  $.each(eval(area0), function() {
   $selloc.append("<option value='"+this+"'>"+this+"</option>");
  });
  $selloc.next().append("<option value=''>구/군 선택</option>");
 });
 
 // 시/도 선택시 구/군 설정
 $("select[name^=loc]").change(function() {
  var loc = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
  var $sigungu = $(this).next(); // 선택영역 군구 객체
  $("option",$sigungu).remove(); // 구군 초기화
  if(loc == "area0")
   $sigungu.append("<option value=''>구/군 선택</option>");
  else {
   $.each(eval(loc), function() {
    $sigungu.append("<option value='"+this+"'>"+this+"</option>");
   });
  }
 });

});
</script>
시/도:
<select name="loc" id="loc"></select>
&nbsp;&nbsp;
시/군/구:
<select name="sigungu" id="sigungu"></select>
<br><br>
상세 주소:<input type="text" name="address" value="${requestScope.updatepvo.paddress }"><br>
특이사항:<input type="text" name="etc" value="${requestScope.updatepvo.petc }"><br>
<br>
<div align="right">
<input type="submit" class="btn btn-danger" value="수정 하기">
<input type="button" class="btn btn-danger" value="취소" onclick="return goback()">
</div>
</form>
</div>
</div>