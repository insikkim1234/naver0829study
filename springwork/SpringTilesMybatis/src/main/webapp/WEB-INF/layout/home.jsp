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
/* (27)home.jsp에 css작성:페이지 열자마자 보이는 사진 4개에 대한 css(너비 높이 여백 테두리 동그랗게 만들기)
	       자바스크립트에 request.getContextPath()"/>작성
	   		html에 기본 내용 작성 */
   body * {
       font-family: 'Jua';
   }
   
 div.mainimage img{
  	width: 230px;
  	height: 230px;
  	margin: 10px;
  	border: 1px solid gray;
  	border-radius: 100px;
  }
  
</style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
<h2 style="color: red;text-shadow:6px 6px 6px gray">비트캠프에 오신것을 환영합니다</h2>
<div class="mainimage">
	<img src="${root}/res/photo/K-045.png">
	<img src="${root}/res/photo/K-041.png">
	<br>
	<img src="${root}/res/photo/K-042.png">
	<img src="${root}/res/photo/K-043.png">	
</div>
</body>
</html>