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
</head>
<!-- (102)boardform.jsp의 html파트작성 -->
<body>
<!-- 1) 로그인을 했을때와 안했을때 케이스 작성
				(로그인을 안했으면 로그인을 한 후 글을 써달라고 작성 
				로그인을 했으면 글 작성 폼이 보임) -->
<c:if test="${sessionScope.loginok==null}">
	<h3>먼저 로그인을 한 후 글을 써주세요</h3>
</c:if>
<c:if test="${sessionScope.loginok!=null}">
	<div>
<!-- 2)폼은 /board/addboard로  포스트 방식으로 보낼 것임 -->	
		<form action="./addboard" method="post" enctype="multipart/form-data">
<!-- 3)현재 쓰는 글이 어느 위치인지 알기 위해서 currentPage,num,regroup,restep,relevel을
hidden으로 생성 -->
		<input type="hidden" name="currentPage" value="${currentPage}">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="regroup" value="${regroup}">
		<input type="hidden" name="restep" value="${restep}">
		<input type="hidden" name="relevel" value="${relevel}">
		
		
			<table class="table table-bordered" style="width:500px;">
<!-- 4)만약 num이 0이면 새글쓰기, 아니면 답글쓰기라고 캡션에 출력 -->			
				<caption align="top">
					<b>${num==0?"새글쓰기":"답글쓰기"}</b>
				</caption>
				<tr>
<!-- 5)제목 입력 텍스트박스 만들기 -->				
					<th width="100">제목</th>
					<td>
						<input type="text" name="subject" class="form-control"
						required autofocus value="${subject}">
					</td>
				</tr>
				<tr>
<!-- 6) 사진 입력 박스 만들기 -->				
					<th width="100">사진</th>
					<td>
						<input type="file" name="upload" multiple class="form-control">
					</td>
				</tr>
				<tr>
<!-- 7) 내용 입력 박스 만들기 -->				
					<td colspan="2">
						<textarea name="content" class="form-control" required
						style="width:100%;height:100px;"></textarea>
					</td>
				</tr>
				<tr>
<!-- 8) 글저장, 이전으로 박스 만들기 -->				
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success">글저장</button>
						<button type="button" class="btn btn-outline-success"
						onclick="history.back()">이전으로</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</c:if>
</body>
</html>