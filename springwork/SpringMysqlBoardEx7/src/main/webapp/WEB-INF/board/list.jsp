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
   

  
</style>
</head>
<body>
<!-- (4)list.jsp작성 -->
	<div style="margin:30px;">
		<!-- 1)h3태그 안에 총 몇개의 글이 있는지 출력하고, 글쓰기 모드로 전환하는 버튼 생성 -->
		<h3 class="alert alert-danger">총 ${totalCount} 개의 글이 있습니다
		<button type="button" class="btn btn-outline-success"
		onclick="location.href='./writeform'" style="float:right;">글쓰기</button>
		</h3>
		<!-- 2)작성된 글을 나타낼 테이블 생성  -->
		<table class="table table-striped" style="margin-top:30px;width:600px;">
			<!-- 1.작성된 글의 번호,제목,작성자,작성일,조회수를 나타내는 어트리뷰트 생성 -->
			<thead>
				<tr>
					<th width="50">번호</th>
					<th width="300">제목</th>
					<th width="80">작성자</th>
					<th width="100">작성일</th>
					<th width="50">조회수</th>
				</tr>
			</thead>
			<!-- 2.글의 갯수 만큼 반복문을 이용하여 출력(만약 사진이 있다면 조건문으로 글의 제목 옆에 그림아이콘을 넣어 준다) -->
			<tbody>
			<c:forEach var="dto" items="${list}" varStatus="n">
				<tr>
					<!-- 번호 -->
					<td>${totalCount-n.index}</td>
					<!-- 제목(만약 사진이 있다면 조건문으로 글의 제목 옆에 그림아이콘을 넣어 준다) -->
					<td>
						<a href="./content?num=${dto.num}" style="color:black;text-decoration:none;">
						${dto.subject}
						<c:if test="${dto.photo!='no'}">
							<i class="bi bi-image photoicon"></i>
						</c:if>
<!-- (24)list.jsp에서 달린 댓글의 갯수를 알려주는 부분 작성 -->						
						<c:if test="${dto.acount>0}">
							&nbsp;
							<span style="color:red;">(${dto.acount})</span>
						</c:if>
						</a>
					</td>
					<!-- 작성자 -->
					<td>${dto.writer}</td>
					<!-- 작성일 -->
					<td>
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd."/>
					</td>
					<!-- 조회수 -->
					<td>${dto.readcount}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

























