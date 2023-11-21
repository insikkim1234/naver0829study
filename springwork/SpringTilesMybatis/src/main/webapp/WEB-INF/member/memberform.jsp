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
<style>
   body * {
       font-family: 'Jua';
   }
   

  
</style>
<script type="text/javascript">
/* (23)memberform.jsp에 자바스크립트  파트작성
$(function() ,check()함수(비번이 일치하는지 체크) 생성 */
	let idok=false;
	$(function(){
/* (25)memberform.jsp에  $(function() 파트 작성  */	
		/* 1) 사진선택 버튼을 눌렀을 때 반응성 $("#upload").change(function()
		만약 이미지 파일jpg,jpeg,png,bmp이 아니면 경고창 출력,맞으면 해당 이미지 출력*/
		 $("#upload").change(function(){
			  console.log("1:"+$(this)[0].files.length);
			  console.log("2:"+$(this)[0].files[0]);
			  //정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			var f=$(this)[0].files[0];//현재 선택한 파일
			if(!f.type.match(reg)){
			   alert("확장자가 이미지파일이 아닙니다");
			   return;
			}
			if($(this)[0].files[0]){
			   var reader=new FileReader();
			   reader.onload=function(e){
			    $("#showimg").attr("src",e.target.result);
			   }
			   reader.readAsDataURL($(this)[0].files[0]);
			  }
			 });
		 //2)중복체크 버튼을 눌렀을 때 반응성 $("#btnidcheck").click(function()
		 $("#btnidcheck").click(function(){
			 	//1.입력한 아이디를 myid 변수에 저장
			 let myid=$("#myid").val();
			 	//2.아약스 방식으로 get타입으로 제이슨 데이터를 얻고
			 	// /member/idcheck 로 이동하며 데이터는 
			 	//키:myid,값:myid로 전달
			 $.ajax({
				 type:"get",
				 dataType:"json",
				 url:"./idcheck",
				 data:{"myid":myid},
				 //3. 같은 이름의 아이디가 하나라도 있으면(res.count!=0)
				 //이미 가입된 아이디가 있다고 뜨고idok는 false로 유지
				 //아이디 새로 입력할 수 있도록 초기화 해준다
				 success:function(res){
					 if(res.count!=0){
						 alert("이미 가입된 아이디입니다");
						 idok=false;
						 $("#myid").val("");
					 }
				 //4.만약 같은 아이디가 하나도 없으면 
				 //사용 가능한 아이디라고 경고창이 뜨며
				 //idok를 true로 바꿔준다
					 else{
						 alert("사용 가능한 아이디");
						 idok=true;
					 }
				 }
			 })
		 });
		 
		 //3)아이디를 거듭하여 입력할 경우 반응성 $("#myid").keyup(function()
		
		 $("#myid").keyup(function(){
			//아이디에 뭔가를 입력한다며 idok=false로 바꿔준다
			 idok=false;
		 })
			
	});//close $function
	
	
/* (24)function check()작성 : 아이디 중복확인과 비밀번호 중복 확인 할것임 */	
 		/*1)위에 전역변수로 idok(기본값 false)생성(아이디가 데베상에 존재하는 다른 아이디와 겹치는지 판단) */
	function check(){
		/* 2)idok==false이면 중복체크 버튼 눌러달라고 경고창 출력 */
		if(!idok){
			alert("중복체크 버튼을 눌러주세요");
			return false;
		}
		/* 3)pass1에 첫번째로 입력한 비밀번호 저장,pass2에 두번째로 입력한 비밀번호 저장 */
		let pass1=$("#pass1").val();
		let pass2=$("#pass2").val();
		/* 4)만약 pass1==pass2이면 
		html파트에서 만들어 둔 form:action을 통해 회원 가입되게 할것임 */
		if(pass1==pass2)
			return true;//action호출
		/* 5)그렇지 않다면 두개의 비밀번호가 맞지 않다는 경고창 출력 */
			else{
				alert("두개의 비밀번호가 맞지 않습니다");
				return false;//action이 호출되지 않는다
			}
		
	}

</script>
</head>
<body>
<!--(19)memberform.jsp에 html파트 작성  -->
<div>
<!-- 1)회원현황 버튼 작성 (클릭시/member/list로 이동하여 튜플이 몇개인지 나타내줌) -->
	<button type="button" class="btn btn-outline-success"
	style="width: 100px;margin-left:300px;"
	 onclick="location.href='./list'">회원현황</button>
<!-- 2)회원가입 폼 양식 작성 (내부는 테이블 형태이고, post방식으로 /member/addmember로 매핑 시켜 줄것임) -->	 
	 <form action="./addmember" method="post" enctype="multipart/form-data"
	 onsubmit="return check()"> <!--onsubmit="return check()"를 통해서
true이면 form의 action false이면 action 안됨  -->
	 <table class="table table-bordered" 
	 style="width:500px;margin:30px;">
	 	<caption align="top"><b>회원가입</b></caption>
	 	<tr>
		<!-- 1.사진 선택 기능 -->	 	
	 		<td rowspan="4" width="150">
	 			<img id="showimg" style="width:150px;height:150px;" 
	 			src="../res/photo/noimage.png" >
	 			<br>
	 			<button type="button" class="btn btn-secondary"
	 			onclick="$('#upload').trigger('click')">사진선택</button>
	 			
	 			<input type="file" name="upload" id="upload" style="display:none;">
	 		</td>
	 	<!-- 2.이름 입력 기능 -->	
	 		<td width="100">이름</td>
	 		<td>
	 			<input type="text" class="form-control" required="required"
	 			autofocus="autofocus" name="name">
	 		</td>
	 	</tr>
	 	<!-- 3.비밀번호를 두번 입력하고 똑같아야만 통과되는 기능 -->
	 	<tr>
	 		<td rowspan="2" valign="middle">비밀번호</td>
	 		<td>
	 			<input type="password" name="pass" id="pass1" class="form-control"
	 			required="required">
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 			<input type="password" id="pass2" class="form-control">
	 		</td>
	 	</tr>
	 	<!-- 4.아이디 입력하고 중복 체크 버튼을 눌러서 데베에 겹치는게 없다면 통과 -->
	 	<tr>
	 		<td>아이디</td>
	 		<td class="input-group">
	 			<input type="text" name="myid" id="myid" class="form-control" required="required">
	 			<button type="button" class="btn btn-danger btn-sm" id="btnidcheck">중복체크</button>
	 		</td>
	 	</tr>
	 	<!-- 5.폰번호를required옵션을 이용해 반드시 입력 받는다 -->
	 	<tr>
	 		<td>핸드폰</td>
	 		<td colspan="2">
	 			<input type="text" name="hp" class="form-control" required="required">
	 		</td>
	 	</tr>
	 	<!-- 6.이메일은 type="email"을 이용하여 골뱅이가 들어가야만 통과판정 -->
	 	<tr>
	 		<td>이메일</td>
	 		<td colspan="2">
	 			<input type="email" name="email" class="form-control">
	 		</td>
	 	</tr>
	 	<!-- 7.회원가입 버튼 클릭하면 회원가입 완성 -->
	 	<tr>
	 		<td colspan="3" align="center">
	 			<button type="submit" class="btn btn-secondary">회원가입</button>
	 		</td>
	 	</tr>
	 
	 </table>
	 </form>
</div>
</body>
</html>













