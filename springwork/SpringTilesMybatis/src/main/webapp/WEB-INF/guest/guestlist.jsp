<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
   
   div.guest_box{
   		width:400px;
   		padding:10px;
   		margin-bottom: 10px;
   		height:300px;
   		border:1px solid gray;
   		overflow:auto;
   }
   

  
</style>
<script type="text/javascript">
/* (170)스크립트 파트에 한국말 보이스랑 영어 보이스 출력해주는 함수 작성 */
	$(function(){
		//1)nara에 localStorage.nara저장
		let nara=localStorage.nara;
		//2)id=nara에 nara의 val값 저장
		$("#nara").val(nara);
		//3)nara의 원래 값은 en(default값)
		if(nara==null) nara='en';
		//4)class=selnara에 nara의 val값 저장 
		$(".selnara").val(nara);
		
		
		//5)한국말 보이스 버튼 클릭시 한국말 목소리를 출력해주는 함수 작성
		$(".voicekr").click(function(){
			console.log(1);
		//6)voicekr의 이전의 텍스트인 한국말로 쓰인 내용	${dto.guest_content}가져오기
			let m=$(this).prev().text();
		//7)get 방식으로 text를 받아 제이슨 형태로 내용과 한국어를 /voice로 보낸다
		//성공시 오디오를 생성하고 재생한다
			$.ajax({
				type:"get",
				dataType:"text",
				url:"./voice",
				data:{"message":m,"lang":"ko"},
				success:function(res){
					//오디오 생성
					let audio=new Audio("../res/voice/"+res);
					audio.play();
			    }
			});
		});
		
		//8)번역 보이스 버튼 클릭시 번역된말 목소리를 출력해주는 함수 작성
		$(".voicetrans").click(function(){
		//9)${dto.trans_lang}를 m에다 저장	
			let m=$(this).prev().text();
		//10)lang에 나라를 저장
			let lang=$(".selnara").val();
		//11)get방식으로 text를 받아서 메시지와 언어를 받아 전송하고
		//성공 시 audio에 해당 언어ㅓ에 해당하는 보이스를 저장하고 재생
			$.ajax({
				type:"get",
				dataType:"text",
				url:"./voice",
				data:{"message":m,"lang":lang},
				success:function(res){
					//오디오 생성
					let audio=new Audio("../res/voice/"+res);
					audio.play();
			    }
			});
		});			
	});
</script>
</head>
<body>
<!-- (169)모달 복붙
id="myPhotoModal"
모달 해더->원본 사진 확인
모달 바디-> <img src="" class="largephoto" style="width:100%"> -->

<!-- The Modal -->
<div class="modal" id="myPhotoModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">원본 사진 확인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <img src="" class="largephoto" style="width:100%">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<!-- (161)guestlist.jsp의 html파트에 사진한장 선택,방명록 저장,n개의 방명록 글이 있음 출력 -->
	<div>
		<form action="./insert" method="post" enctype="multipart/form-data">
			
			<input type="hidden" name="nara" id="nara">
			<b>사진한장</b>
			<input type="file" name="upload" required><br>
			<b>닉네임 : </b>
			<input type="text" name="guest_nickname" required><br>
			<textarea style="width:300px;height:100px;" name="guest_content" required></textarea>
			<br>
			<button type="submit">방명록 저장</button>
		</form>
	</div>
	<hr>
<!--(164)guestlist.jsp에 몇개의 방명록 글이 있는지, 선택가능한 언어를 셀렉트 박스로 출력 -->	
	<div>
		<h5>총 ${totalCount}개의 방명록 글이 있습니다</h5>
		<div class="input-group" style="width:300px;margin-left: 100px;">
			<h6><b>번역할 나라 선택: </b></h6>
			<select class="form-select selnara" style="margin-left: 30px;">
				<option value="en">영어</option>
				<option value="ja">일어</option>
				<!-- <option value="fr">불어</option> -->
				<option value="es">스페인어</option>
				<option value="zh-CN">중국어</option>
				<!-- <option value="de">독일어</option> -->
				
			</select>
<!-- (165) 셀렉트 박스가 바뀌면 nara변수에 값 저장후 로컬스토리지의
나라 변수에다 저장 후 nara=입력받은 나라로 위치 이동-->			
			<script type="text/javascript">
				$(".selnara").change(function(){
					let nara=$(this).val();
					localStorage.nara=nara;
					location.href="./list?nara="+nara;
				});
			</script>
	</div>
<!-- (166)반복문으로 튜플 출력(작성자 작성시점 출력) -->	
		<c:forEach var="dto" items="${glist}">
			<div class="guest_box">
				<div style="clear:both;" class="input-group">
					<h6><b>${dto.guest_nickname}</b></h6>
					<span style="margin-left:30px;margin-right:10px;color:gray;font-size:0.9em;">
						<fmt:formatDate value="${dto.guest_writeday }"
						pattern="yyyy-MM-dd HH:mm"/>
					</span>
				</div>
<!-- (167)src에 이미지 링크 주소 넣기
 https://iquqmczr1746.edge.naverncp.com/dHDPHtV96D/guest/${dto.guest_photo}?type=f&w=100&h=100&faceopt=true&ttype=jpg
 마우스를 올리면 원본사진을 보려면 클릭하라는 문구 출력-->				
				<img src="https://iquqmczr1746.edge.naverncp.com/dHDPHtV96D/guest/${dto.guest_photo}?type=f&w=100&h=100&faceopt=true&ttype=jpg" 
				class="img-thumbnail smallphoto" 
				style="float:left;margin-right: 10px;cursor:pointer;" 
				photoname="${dto.guest_photo}" data-bs-toggle="modal" data-bs-target="#myPhotoModal"
				title="원본사진을 보려면 클릭하세요">
				<pre>${dto.guest_content}</pre>
				<i class="bi bi-megaphone voicekr" style="cursor:pointer;font-size: 1.5em;"></i>
				
				<hr>
<!-- (177)guestlist.jsp에 번역 서비스 출력하는 html파트 추가 -->				
				<h6 style="color:red;">papago번역 서비스</h6>
				<pre>${dto.trans_lang}</pre>
				<i class="bi bi-megaphone voicetrans" style="cursor:pointer;font-size: 1.5em;"></i>
						
			</div>
		</c:forEach>
	</div>
<!-- (178)guestlist.jsp에 사진명을 얻어서 모달 다이얼로그에 사진을 넣는 코드 작성 -->	
	<script type="text/javascript">
		$("img.smallphoto").click(function(){
			//사진명 얻기
			let photoname=$(this).attr("photoname");
			//모달다이얼로그에 사진 넣기
			$("img.largephoto").attr("src",`https://kr.object.ncloudstorage.com/bitcamp-kis/guest/\${photoname}`);
		});
	</script>
</body>
</html>