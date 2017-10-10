<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://koreamz.com/js/jquery-1.8.3.min.js"></script>
<script src="http://koreamz.com/js/common.js"></script>
<script src="http://koreamz.com/js/wrest.js"></script>
<script src="http://koreamz.com/js/owl.carousel.js"></script>

<script src="http://koreamz.com/js/Wo_slide.js"></script>
<script src="http://koreamz.com/js/favorite.js"></script>


<script src="http://koreamz.com/js/Wo_Banner2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.ShopTitle {
		width: 940px;
		margin: 30px auto 10px;
		font-size: 22px;
		font-family: NanumgothicB;
	}

	.ShopTitle span {
		color: red;
		font-family: NanumgothicB;
	}

	#MAP{
		height:450px;
		padding:60px 10px 0px;
	}
	
	#MAP_title{
		font-size: 24px;
		font-family: NanumGothicB;
		position: absolute;
		margin-top: -45px;
		letter-spacing: -2px;
	}
	
	#MAP_title #icon{
		background: url(http://itvplus5.cafe24.com/img/map/icon.svg);
		width: 25.584px;
		height: 39.582px;
		display: block;
		float: left;
		margin-top: -10px;
		margin-right: 5px;
		margin-left: -10px;
	}

	#MAP_title #submsg{
		font-size: 12px;
		color:#777;
		letter-spacing: 0px;
	}

	#MAP #VIEW{
		background: url(http://itvplus5.cafe24.com/img/map/map.png);
		width: 320px;
		height: 420px;
		font-size: 13px;
		float: left;
		background-size: 100% 100%;
		margin-left: 300px;
	}
#MAP #VIEW2{
		background: url(http://itvplus5.cafe24.com/img/map/map.png);
		width: 320px;
		height: 420px;
		font-size: 13px;
		float: left;
		background-size: 100% 100%;
		margin-left: 16px;
	}
	#MAP #VIEW span{
		color: #939393;
		font-family: NanumGothic;
		cursor: pointer;
		text-shadow: 1px 1px 1px #FFF;
		position: absolute;
		font-weight:bold;
		font-size:14px;

	}

	#MAP #VIEW span em{
		font-family: NanumGothicB;
		font-style: normal;
		margin-left: 1px;
	}

	#MAP #VIEW .select{
		color: #DF1E37;
	}

	#MAP #VIEW span:hover{
		color: #DF1E37;
	}

	#MAP #VIEW span:hover em{
		display:inline;
	}

	#MAP #context{
		background: rgba(255, 255, 255, 0.8);
		width: 559px;
		height: 415px;
		margin: 20px 0px 0px 25px;
		border: 6px solid #DF1E37;
		float: left;
		padding: 25px;
	}	

	#MAP #context_title{
		color: white;
		width: 200px;
		height: 40px;
		float: left;
		position: absolute;
		line-height: 40px;
		font-size: 14px;
		text-align: center;
		background: #DF1E37;
		margin: 0px 0px 0px 379px;
	} 
	
	#MAP #context_title #from{
		font-size: 20px;
		font-family: NanumGothicB;
	} 
	
	#context .for{
		float: left;
		width: 23%;
		margin: 4px;
		padding: 4px 2px;
		font-size: 15px;
		cursor: pointer;
		font-weight: 600;
	}
	
	#context .for:hover{
		background:#DF1E37;
		color:white;
	}

	#context .select{
		background:#DF1E37;
		color:white;
	}

	.category_bar{
		border-bottom: 1px solid #CCCCCC;
		border-top: 1px solid #CCCCCC;
		margin: 10px auto
	}

	.category_form{
		display: block;
		float: left;
		padding: 10px 21px;
		font-size: 15px;
		font-weight: 600;
	}

	.category_form.select{
		background: #DF1E37;
		color: white;
	}
</style>
<script type="text/javascript">

$(function(){   
	$("#mycontext").hide();
	var froms = "서울특별시";
	var fors = "강남구";
	var area = [
	["제주특별자치도","서귀포시","제주시"],
	["전라남도","목포시","무안군","고흥군","광양시","강진군","곡성군","구례군","나주시","담양군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군","장성군 북일면","담양군 담양읍","목포시 석현동","순창군","장수군"],
	["부산광역시","금정구","강서구","기장군","남구","동구","서구","부산진구","북구","동래구","사상구","사하구","수영구","연제구","영도구","중구","해운대구"],
	["울산광역시","남구","북구","울주군","동구","중구"],
	["경상남도","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","거창군","고성군","남해군","산청군","의령군","창녕군","통영시","하동군","함안군","함양군","합천군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구"],
	["광주광역시","광산구","북구","서구","남구","동구"],
	["전라북도","정읍시","군산시","완주군","익산시","고창군","김제시","남원시","무주군","부안군","순창군","임실군","장수군","진안군","고창군 대산면","전주시","무안군"],
	["대구광역시","달서구","수성구","남구","서구","북구","달성군","중구","동구"],
	["경상북도","고령군","경산시","경주시","구미시","김천시","문경시","영천시","포항시","군위군","봉화군","상주시","안동시","영덕군","영양군","영주시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군","포항시 남구","포항시 북구"],
	["대전광역시","대덕구","동구","서구","유성구","중구"],
	["충청남도","공주시","금산군","논산시","당진시","보령시","부여군","서산시","아산시","연기군","예산군","천안시","태안군","홍성군","계룡시","서천군","청양군","당진군"],
	["충청북도","단양군","제천시","진천군","청원군","청주시","충주시","증평군","영동군","옥천군","음성군","괴산군","보은군","청주시 흥덕구"],
	["경기도","고양시","가평군","과천시","광명시","광주시","평택시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","양평군","용인시 처인구","분당구","연천군","오산시","용인시","의정부시","의왕시","이천시","파주시","포천시","화성시","하남시","용인시 기흥구","수원시 영통구","고양시 덕양구","남원시","광주시 곤지암읍","여주시","부평구","용인시 수지구"],
	["강원도","강릉시","고성군","강릉시","동해시","속초시","원주시","횡성군","철원군","춘천시","평창군","홍천군","양양군","삼척시","양구군","영월군","인제군","정선군","태백시","화천군"],
	["인천광역시","계양구","강화군","남구","동구","남동구","부평구","서구","연수구","중구","옹진군"],
	["서울특별시","강동구","강남구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"],
	["세종특별자치시","반곡동", "소담동", "보람동", "대평동", "가람동", "한솔동", "나성동", "새롬동", "다정동", "어진동", "종촌동", "고운동", "아름동", "도담동", "조치원읍", "연기면", "연동면", "부강면", "금남면", "장군면", "연서면", "전의면", "전동면","소정면"]
	];
	
	for(var x = 0; x < area.length; x++){
		if(area[x][0] == froms){
			for(var y = 1; y < area[x].length; y++){
				var select = "";
				if(area[x][y] == fors){select = " select";}
				$("#context").append("<a href='city1.jsp?s="+encodeURI(area[x][0])+"&g="+encodeURI (area[x][y])+"'><div class='for"+select+"'>"+area[x][y]+"</div></a>");
			}//if END
			break;
		}// if END			
	}//for END
	
	$("#VIEW .from").removeClass("select");
	$("#VIEW .from[from='서울특별시']").addClass("select");
	
		
	$("#VIEW .from").on("click",function(){
		$("#mycontext").show();
		$("#VIEW .from").removeClass("select");
		$(this).addClass("select");
		froms = $(this).attr("from");
		$("#from").text(froms);
		$("#context").html("");
		for(var x = 0; x < area.length; x++){
			if(area[x][0] == froms){
				for(var y = 1; y < area[x].length; y++){
					$("#context").append("<a href='city1.jsp?s="+encodeURI(area[x][0])+"&g="+encodeURI(area[x][y])+"'><div class='for'>"+area[x][y]+"</div></a>");
				}//if END
				break;
			}// if END			
		}//for END
	});	
});
</script>
</head>
<body>
<div class="highlight-line" style="background: #f3f3f3;">
	<div id="MAP" class="frame">
		<div id="MAP_title"><em id="icon"></em><span style="color:#DF1E37;font-family: NanumGothicB;">지역별</span> 맛집찾기<span id="submsg">  지도에서 지역을 선택한 후 상세지역명을 선택해주세요.</span></div>

		<div id="VIEW">

			<span from="제주특별자치도" class="from" style="margin: 376px 0px 0px 47px;">제주</span>
			<span from="전라남도" class="from" style="margin: 289px 0px 0px 72px;">전남</span>
			<span from="부산광역시" class="from" style="margin: 272px 0px 0px 240px;">부산</span>
			<span from="울산광역시" class="from" style="margin: 242px 0px 0px 249px;">울산</span>
			<span from="경상남도" class="from" style="margin: 255px 0px 0px 163px;">경남</span>
			<span from="광주광역시" class="from" style="margin: 264px 0px 0px 50px;">광주</span>
			<span from="전라북도" class="from" style="margin: 212px 0px 0px 79px;">전북</span>
			<span from="대구광역시" class="from" style="margin: 211px 0px 0px 191px;">대구</span>
			<span from="경상북도" class="from" style="margin: 164px 0px 0px 188px;">경북</span>
			<span from="대전광역시" class="from" style="margin: 162px 0px 0px 95px;">대전</span>
			<span from="충청남도" class="from" style="margin: 135px 0px 0px 50px;">충남</span>
			<span from="세종특별자치시" class="from" style="margin:148px 0px 0px 74px">세종</span>
			<span from="충청북도" class="from" style="margin: 127px 0px 0px 108px;">충북</span>
			<span from="경기도" class="from" style="margin: 95px 0px 0px 78px;">경기</span>
			<span from="강원도" class="from" style="margin: 64px 0px 0px 144px;">강원</span>
			<span from="인천광역시" class="from" style="margin: 74px 0px 0px 68px;">인천</span>
			<span from="서울특별시" class="from select" style="margin: 58px 0px 0px 89px;">서울</span>
		</div>

		<div id="mycontext">
			<div id="context_title"><span id="from">서울특별시</span> 맛집찾기</div>
			<div id="context">
			</div>
		</div>

		<div class="clear"></div>
	</div>
	
	<div class="clear"></div>
</div>
</body>
</html>