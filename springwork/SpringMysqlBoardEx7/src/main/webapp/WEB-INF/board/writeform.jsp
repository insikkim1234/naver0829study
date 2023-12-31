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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script type="text/javascript">

//(5)writeform.jsp 수정
	/* 1)반응성 이벤트 만들기 */
	$(function(){
			//1.카메라버튼 클릭시 만들어둔 id="upload"에다가 업로드된 파일을 알려주는 이벤트
		$(".uploadcamera").click(function(){
			$("#upload").trigger("click");
		});
			//2.id=upload에 파일을 올려 준다
		$("#upload").change(function(){
			  console.log("1:"+$(this)[0].files.length);
			  console.log("2:"+$(this)[0].files[0]);
			  //정규표현식 (이거 4개만 가능)
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
			
	});
	
</script>
</head>
<body>

<!-- 2)img태그 이용해 출력할 이미지를 미리 볼수 있는곳 만들기 -->
 <img id="showimg" 
 style="position: absolute;left:600px;top:60px;max-width: 300px;">

<div style="margin:30px 50px;">
	<!-- 3)writeform.jsp 에서
	 post방식으로 작성자,제목,내용(사진 포함) 읽고 보내기 위한 틀,사진저장버튼,등록버튼,이전버튼 생성 -->
	<form action="./addprocess" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width:500px;">
			<!-- 글쓰기 -->
			<caption align="top">글쓰기</caption>
			<!-- 작성자 -->
			<tr>
				<th width="100">작성자</th>
				<td>
					<input type="text" name="writer" class="form-control"
					style="width:150px" autofocus="autofocus" required="required">
				</td>
			</tr>
			<!-- 제목 -->
			<tr>
				<th width="100">제목</th>
				<td class="input-group">
					<input type="text" name="subject" class="form-control"
					  required="required">
					  <!-- 파일을 업로드 받기 위해 사진을 업로드하면 어떤 파일인지 
					  출력해 줄 것이지만, 미관상 안보이게 만든다 -->
					<input type="file" name="upload" id="upload"
					style="display:none;"> 
					&nbsp;&nbsp;
					<!-- 카메라 이이콘 -->
					<i class="bi bi-camera-fill uploadcamera" ></i> 
				</td>
			</tr>
			<!-- 내용 -->
			<tr>
				<th width="100">내용</th>
				<td>
					<textarea style="width:100%;height:150px;"
					name="content" required="required" class="form-control"></textarea>
				</td>
			</tr>
			<!-- 등록버튼,이전버튼 -->
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success"
					style="width:100px;" onclick="history.back()">등록</button>
				
					<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="history.back()">이전</button>
				</td>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>