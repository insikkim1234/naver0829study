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
<!-- (57)loginmain.jsp에모달 복붙 -->
<!-- 1)헤더 부분에 복붙 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
   

  
</style>
</head>
<body>
<!-- 2)모달,모달 헤더,모달 몸통,모달 발바닥 작성 -->
<!-- The Modal -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<!-- (56)loginmain.jsp에1) <c 태그를 이용해서 로그인 버튼 만들기,로그인 되어있을 경우 로그아웃 버튼 만들기 -->
	<c:if test="${sessionScope.loginok==null }">
		<button type="button" class="btn btn-success"
		style="width:100px;" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null }">
		<h5>${sessionScope.myid}님</h5>
		<button type="button" class="btn btn-success"
		style="width:100px;">로그아웃</button>
	</c:if>
</body>
</html>