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
<!-- (58)header.jsp에 모달 사용하기 위한 스크립트 작성 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

​

<style>
   body * {
       font-family: 'Jua';
   }
   

  
</style>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<script type="text/javascript">
	$(function(){
		//(60)header.jsp의 js 파트에 $function에 로그인 버튼 클릭시 반응성 만들기
		$("#btnlogin").click(function(){
			//1).val()은 체크 여부와 상관없이 무조건 on이므로 이렇게 받는다
			//saveid에 만약 아이디 저장이 체크되었다면 아이디를 입력받는다
			let saveid=$("#saveid").is(":checked");
			//2)입력한 아이디와 비밀번호를 각각 myid,pass에 저장한다
			let myid=$("#login_myid").val();
			let pass=$("#login_pass").val();
			
			
			
			//3)ajax방식으로 get방식으로 제이슨 데이터를  얻어 /login/process로 매핑하며
			//데이터는 제이슨 형식으로 saveid여부,입력한 아이디,입력한 비밀번호 보낸다
			$.ajax({
				type:"get",
				dataType:"json",
				url:"${root}/login/process",
				data:{"saveid":saveid,
					"myid":myid,
					"pass":pass},
			//4)만약 로그인에 성공했다면 열린 모달창을 닫고 로그인 후 다시 원래 페이지로 돌아간다
			//그 외에는 아이디와 비밀번호가 맞지 않다는 출력창 띄우고 다시 원래 페이지로 돌아간다
				success:function(res){
					//성공여부:res.success
					if(res.success){
						$("#btnclose").trigger("click");
						//강제로 닫기 버튼클릭
						location.reload();
					}
					else{
						alert("아이디나 비밀번호가 맞지 않습니다");
					}
				}
			});
		});
		
		//(64)header.jsp의 $(function)내부에 로그아웃 버튼 클릭시 반응성 만들기
		$("#btnlogout").click(function(){
			//1)ajax형태로 get방식으로 text방식의 자료행을 /login/logout으로 매핑
			$.ajax({
				type:"get",
				dataType:"text",
				url:"${root}/login/logout",
			//2)만약 성공 하면 로그아웃 하고 웹페이지를 새로고침	
				success:function(res){
					location.reload();//새로고침
				}
			});
		});
	});
</script>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
<!-- (59) 모달 파트 작성 -->
<!-- The Modal -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h6 class="modal-title">회원 로그인</h6>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<table class="table table-bordered" >
      		<caption align="top">
      <!-- (66) 로그인 모달창에서 아이디 저장을 체크후 로그인을 했을 경우 아이디저장을 체크 아이디 나오게하기
      1)체크 안했으면 아이디저장 체크박스에 체크 안되있고, 
      체크 했으면 아이디저장 체크박스에 체크가 되어 있다 -->		
      			<label>
      				<c:if test="${sessionScope.saveid==null
      					|| sessionScope.saveid=='no'}">
      					<input type="checkbox" id="saveid">&nbsp;아이디저장
      				</c:if>
      				<c:if test="${sessionScope.saveid=='yes'}">
      					<input type="checkbox" id="saveid" checked>&nbsp;아이디저장
      				</c:if>
      			</label>
      		</caption>
      		
      		<tr>
      			<th width="100">아이디</th>
      		<!-- 2)체크 했으면 텍스트박스에 원래 데이터 저장 
      			체크 안했으면 텍스트박스가 비어 있음 -->	
      			<td>
      				<c:if test="${sessionScope.saveid==null
      					|| sessionScope.saveid=='no'}">
      					<input type="text" id="login_myid" class="form-control">
      				</c:if>
      				<c:if test="${sessionScope.saveid=='yes'}">
      					<input type="text" id="login_myid" class="form-control"
      					value="${sessionScope.myid}">
      				</c:if>
      			</td>
      		</tr>	
      		<tr>
      			<th width="100">비밀번호</th>
      			<td>
      				<input type="password" id="login_pass" class="form-control">
      			</td>
      		</tr>	
      	</table>
     
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-success" 
        id="btnlogin">로그인</button>
        
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
        id="btnclose">close</button>
      </div>

    </div>
  </div>
</div>

<!-- (6)header.jsp에 사진 하나와 제목을 나타내 주는 a 태그 작성 -->
<a href="${root}/" style="font-size:30px;">
	<img src="${root}/res/photo/K-041.png" width="50" hspace="20">
Spring5 mini project
</a>
<div style="width:200px;position:fixed;right:50px;top:30px;">
	<c:if test="${sessionScope.loginok==null }">
		
		<button type="button" class="btn btn-success"
		style="width:100px;" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null }">
		<img src="${root}/res/upload/${sessionScope.myphoto}" class="rounded-circle profile_photo"
			width=70 height="70" hspace="10" border=1
			onerror="this.src='${root}/res/photo/noimage.png'"><br>
		<i class="bi bi-gear photochange" 
		style="font-size:2em;cursor:pointer;"></i>
		<!-- 기어버튼을 클릭하면 파일을 열리게 해야 하는데 숨겨놓기 위해 display:none -->
		<input type="file" id="profile_upload" style="display:none;">
		<div class="input-group">
			<h5>${sessionScope.myname}님</h5>&nbsp;&nbsp;
			<button type="button" class="btn btn-success btn-sm"
			style="width:100px;" id="btnlogout">로그아웃</button>
		</div>
	</c:if>
	</div>
	
	<script type="text/javascript">
	//(65)header.jsp아래에 톱니 아이콘 클릭시 파일 업로드 이벤트 트리거,파일 업로드 이벤트
		//1)톱니 아이콘 클릭시(톱니 아이콘의 id인 photochange)
		//type="file"인 곳의 id인 profile_upload에 업로드
		$(".photochange").click(function(){
			$("#profile_upload").trigger("click");
		});
		//2)파일 업로드 이벤트
		$("#profile_upload").change(function(){
			//1.form 변수 생성
			let form=new FormData();
			//2.form에 upload:0번째 사진 업로드
			form.append("upload",$("#profile_upload")[0].files[0]);
			//3.ajax방식으로 post형식으로 json데이터를 입력받아 /login/photochange와
			//매핑
			$.ajax({
				type:"post",
				dataType:"json",
				url:"${root}/login/photochange",
				//파일 업로드할때만 들어가는 것 두개
				processData:false,
				contentType:false,
				data:form,
			//4.성공시 프로필에 해당 이미지 업로드 후 새로고침
				success:function(res){
					$("img.profile_photo").attr("src",`${root}/res/upload/\${res.fileName}`);
					location.reload();
				}
			});
		});
	</script>
</body>
</html>








