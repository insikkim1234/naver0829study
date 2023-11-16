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
   
   .day{
   		color:gray;
   		font-size: 0.8em;
   		float:right;
   		
   }
   

  
</style>
<script>
/*(20)x버튼을 누르면 댓글이 삭제되도록 하는 반응성 만들기  */
	$(function(){
		$(".answerdel").click(function(){
			let idx=$(this).attr("idx");
			let num=$(this).attr("num");
			
			let a=confirm("해당 댓글을 삭제하려면 확인 클릭");
			if(a){
				location.href=`./answerdel?num=\${num}&idx=\${idx}`;
			}
		});
	});
</script>
</head>
<body>
<!-- (13)content.jsp작성 해당 튜플의 내용, 닉네임,댓글,저정버튼,글쓰기버튼,목록버튼,수정버튼,삭제버튼 -->
	<div style="margin:30px;width:500px;">
		<h3><b>${dto.subject }</b></h3>
		<div style="width:500px;">
			<span>${dto.writer }</span>
			<span class="day">
				조회:${dto.readcount}&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			</span>
			<hr>
			<pre>${dto.content}</pre>
			<c:if test="${dto.photo!='no' }">
				<br><br>
				<img src="../upload/${dto.photo}" style="max-width:400px;">
			</c:if>
			<div style="margin:20px;">
			<i class="bi bi-chat-dots"></i> &nbsp;${acount}<br><br>
				<!-- 댓글 출력 -->
				<c:forEach var="adto" items="${alist}">
					<span>${adto.nickname}: ${adto.content}</span>
					<span style="margin-left:20px;color:gray;font-size:0.9em;">
						<fmt:formatDate value="${adto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
					</span>
<!-- (19) content.jsp에서 idx="${adto.idx}" num="${dto.num}" 추가하기 -->
					<i class="bi bi-x-lg answerdel" style="cursor:pointer;" idx="${adto.idx}" num="${dto.num}"></i>
					<br>
				</c:forEach>
			</div>
			<br><br>
					<div style="margin-bottom:10px;">
						<form action="./addanswer" method="post">
							<input type="hidden" name="num" value="${dto.num}">
							<div class="input-group" style="width:500px;">
								<input type="text" name="nickname" class="form-control"
								style="margin-left:5px;width:100px;" placeholder="닉네임">
								<input type="text" name="content" class="form-control"
								style="margin-left:5px;width:300px;" placeholder="댓글">
								
								<button type="submit" class="btn btn-sm btn-outline-success">저장</button>
							</div>	
						</form>
					
					</div>
			
			<button type="button" class="btn btn-outline-info btn-sm"
			style="width:80px" onclick="location.href='./writeform'">글쓰기</button>
			
			<button type="button" class="btn btn-outline-info btn-sm"
			style="width:80px" onclick="location.href='./list'">목록</button>
			
			<button type="button" class="btn btn-outline-info btn-sm"
			style="width:80px" onclick="location.href='./updateform?num=${dto.num}'">수정</button>
			
			<button type="button" class="btn btn-outline-info btn-sm"
			style="width:80px" onclick="location.href='./delete?num=${dto.num}'">삭제</button>
		</div>
	</div>
</body>
</html>