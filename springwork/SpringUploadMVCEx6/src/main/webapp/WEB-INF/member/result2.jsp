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
<!-- (22)result2.jsp에서 uploadform2.jsp에서 post방식으로 읽은 데이터  출력 -->
<h2>form2로부터 얻은 결과 출력하기</h2>
<h3>
	이름: ${mdto.name }<br>
	핸드폰: ${mdto.hp }<br>
	주소:${mdto.addr }<br>
</h3>
<hr>
<c:forTokens var="photo" items=" ${mdto.photo }" delims="," varStatus="n">
	<div style="font-size:20px;">
		${n.count }/${photo }<br>
		<img src="../photo/${photo}" width="200" border="2">
		<hr>
	</div>
</c:forTokens>	
</body>
</html>