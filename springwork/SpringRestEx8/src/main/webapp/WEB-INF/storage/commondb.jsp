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
<!-- (67)commondb.jsp의
javascript</style><script> 부분에 업로드하는 함수,
전송버튼누를 시 함수, 리스트 출력 함수 작성</script></head> -->
<script type="text/javascript">
	$(function(){
		/* 1)리스트를 다시 출력해주는 함수 */
		list();
		/* 2)업로드하는 함수 */
		$("#upload").change(function(){
		/* 3) form에 FormData 집어넣기 */	
			let form=new FormData();
		/* 4) 선택한1개의 파일만 추가 */
			form.append("upload",$("#upload")[0].files[0]);
		/*5) ajax를 이용해 파일 선택 성공시 이미지를 붙여줌 */
			//processData:false,
			//서버에 전달하는 데이터는  query string 이라는 형태로 전달된다
			//파일 전송의 경우 이를 하지 않아야 하는데 그 설정이 false
			//contentType:false,: enetype이 원래 기본값이 application/x-www..이건데
			//multipart/form-data 로 변경해준다
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./addphoto",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					//alert(res);//랜덤 파일명 확인 후 이미지 출력
					$(".photo80").attr("src",res);
				}
			});
		});
		/* 6)전송버튼 누를시 함수 */
		$("#btnsend").click(function(){
			
		});
	});
	/* 7)모든 튜플들을 추가해주는 함수 */
	function list()
	{
		
	}

</script>
</head>
<body>
<!-- (66)commondb.jsp 에 
			1)스토리지에 사진 올리는 부분 (제목, 파일 선택 버튼, 선택된 파일이 출력되는 부분,서버 전송 버튼)
			2)선택한 파일에 대한 사진을 올려주는 부분
			3)목록을 나타내는 부분	 -->
	<h4>스토리지에 사진 올리기</h4>
	<div class="input-group" style="width:600px;">
		<input type="text" id="title" style="width:200px;" class="form-control" placeholder="제목넣기">
		<input type="file" id="upload" style="width:200px;" class="form-control">
		<button type="button" id="btnsend">서버전송</button>
	</div>
	80*80 사진만 확인: <img src="" class="photo80">
	<div class="list" style="margin:20px;">목록</div>
</body>
</html>