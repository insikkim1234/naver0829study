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



<style>
   body * {
       font-family: 'Jua';
   }
   
   div.photos{
   	float:left;
   	width:150px;
   	height:150px;
   }
   
   div.photos img{
   	width:100px;
   	height:100px;
   	border:1px solid gray;
   	box-shadow:3px 3px 3px gray;
   }
   
   div.photos .photodel{
   	position:relative;
   	cursor:pointer;
   	
   }

  
</style>
</head>
<body>
<!-- (124)updateform.jsp에 수정 -->
<c:if test="${sessionScope.loginok==null}">
	<h3>먼저 로그인을 한 후 수정해주세요</h3>
</c:if>
<c:if test="${sessionScope.loginok!=null}">
	<div>
		<form action="./updateboard" method="post" enctype="multipart/form-data">
		<!-- hidden -->
		<!-- 1)히든 부분에 reg,res,rel부분 지우고 num을 dto.num으로 바꿈 -->
		<input type="hidden" name="currentPage" value="${currentPage}">
		<input type="hidden" name="num" value="${dto.num}">
		
			<table class="table table-bordered" style="width:500px;">
		<!-- 2)캡션에 글수정으로 바꿈 -->	
				<caption align="top">
					<b>글수정</b>
				</caption>
				<tr>
					<th width="100">제목</th>
					<td>
		<!-- 3)input에 dto.subject로 바꿈 -->			
						<input type="text" name="subject" class="form-control"
						required autofocus value="${dto.subject}">
					</td>
				</tr>
				<tr>
					<th width="100">사진</th>
					<td>
						<input type="file" name="upload" multiple class="form-control">
					</td>
				</tr>
				<tr>
		<!-- 4)textarea에 ${dto.content} 바꿈 -->		
					<td colspan="2">
						<textarea name="content" class="form-control" required
						style="width:100%;height:100px;">${dto.content}</textarea>
						<br>
						<c:forEach var="fdto" items="${flist}">
							<div class="photos">
								<img src="../res/upload/${fdto.photoname}">
								<i class="bi bi-x-circle photodel" idx="${fdto.idx}"></i>
		<!-- (126)updateform.jsp의 script아래  삭제버튼 클릭시 반응성 -->	
			<!-- idx에 클릭한 튜플의 idx값 저장 ajax방식으로 성공시
			사진 삭제 -->					
								<script>
								
									$(document).on("click",".photodel",function(){	
										let idx=$(this).attr("idx");
										let $photodel=$(this);
										$.ajax({
											type:"get",
											dataType:"text",
											url:"./delphoto",
											data:{"idx":idx},
											success:function(res){
												//사진삭제(포토델(삭제아이콘)의 부모 태그 삭제)
												$photodel.parent().remove();
											}
										});
									});
								</script>
							</div>
						</c:forEach>
					</td>
				</tr>
				<!--5) 버튼에 수정만 남기고 삭제  -->
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success">수정</button>		
					</td>
				</tr>
			</table>
		</form>
	</div>
</c:if>
</body>
</html>