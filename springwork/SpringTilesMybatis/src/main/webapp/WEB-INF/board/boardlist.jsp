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
<body>
<!-- (101)boardlist.jsp에 html파트 작성 -->
<div>
<!-- 1)현재 몇개의 글이 있는지 출력 -->
	<h6 class="alert alert-danger">
		총 ${totalCount }개의 글이 있습니다
<!-- 2)로그인을 했을 때에만 글쓰기 버튼이 나오도록 하기  누르면 /board/form으로 이동-->		
		<c:if test="${sessionScope.loginok!=null}">
			<button type="button" class="btn btn-outline-danger btn-sm"
			onclick="location.href='./form'" style="margin-left:300px;">
				글쓰기
			</button>
		</c:if>
	</h6>
	<table class="table table-bordered">
<!-- 3)출력할 어트리뷰트 작성 -->	
		<thead>
			<tr>
				<th width="50">번호</th>
				<th width="350">제목</th>
				<th width="80">작성자</th>
				<th width="100">작성일</th>
				<th width="60">조회</th>
			</tr>
		</thead>
<!-- 4)튜플 출력-->		
		<tbody>
		<!-- 1. 리스트를 받아 반복문 실행 -->
			<c:forEach var="dto" items="${list}">
				<tr>
		<!-- 2. 번호 출력  -->		
					<td>
						${no}
						<c:set var="no" value="${no-1}"/>
					</td>
		<!-- 3. 제목 작성 -->			
					<td>
						
						<!-- 답글 레벨 1당 두칸 띄우기 -->
						<c:forEach begin="1" end="${dto.relevel}">
							&nbsp;&nbsp;
						</c:forEach>
						<!-- level이 0이상인 경우 답글 아이콘 -->
						<c:if test="${dto.relevel>0}">
							<img src="../res/photo/re.png">
						</c:if>
						<!-- 제목 표시 -->
						<a href="./content?num=${dto.num}&currentPage=${currentPage}">
							${dto.subject}
						<!-- 이미지 아이콘 -->	
							<c:if test="${dto.photocount==1}">
								<i class="bi bi-image" style="color:gray;"></i>
							</c:if>
							<c:if test="${dto.photocount>1}">
								<i class="bi bi-images" style="color:gray;"></i>
							</c:if>
						</a>
						
<!-- (143)boardlist에서 목록에서 해당 게시글에 달린 댓글 갯수를 표시할 수 있는 부분 작성 -->
						<c:if test="${dto.acount>0}">
							<a href="./content?num=${dto.num}&currentPage=${currentPage}#answerend">
								<span style="color:red;">(${dto.acount})</span>
							</a>
						</c:if>
					</td>
		<!-- 4.작성자 -->			
					<td>
						${dto.writer}
					</td>
		<!-- 5.작성일 -->			
					<td>
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
					</td>
		<!-- 6.조회수 -->			
					<td>
						${dto.readcount}
					</td>
				</tr>
			</c:forEach>
		</tbody>
<!-- 5)페이징 처리 -->		
	</table>
	<div style="text-align:center;">
		<!-- 1.이전 숫자 나오는 버튼 -->
		<c:if test="${startPage>1}">
			<a href="./list?currentPage=${startPage-1}">이전</a>
		</c:if>
		&nbsp;
		<!-- 2.현재 페이지면 빨간색 아니면 검은색 -->
		<c:forEach var="pno" begin="${startPage}" end="${endPage}">
			<a href="./list?currentPage=${pno}">
				<c:if test="${pno==currentPage}">
					<span style="color:red;">${pno}</span>
				</c:if>
				<c:if test="${pno!=currentPage}">
					<span style="color:black;">${pno}</span>
				</c:if>
			</a>
			&nbsp;
		</c:forEach>
		<!--3. 다음 숫자 나오는 버튼 -->
		<c:if test="${endPage<totalPage}">
			<a href="./list?currentPage=${endPage+1}">다음</a>
		</c:if>
	</div>
</div>
</body>
</html>
































