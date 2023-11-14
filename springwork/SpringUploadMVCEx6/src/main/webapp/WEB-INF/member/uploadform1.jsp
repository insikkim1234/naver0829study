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
<!-- (5)uploadform1.jsp에서 post방식으로 이름,사진(1장),핸드폰,주소를 읽고 보내기 위한
		틀, 전송버튼 생성   -->
	<form action="./upload1" method="post" enctype="multipart/form-data">
		이름:<input type="text" name="name" ><br>
		사진:<input type="file" name="upload"><br>
		핸드폰: <input type="text" name="hp"><br>
		주소: <input type="text" name="addr"><br>
		<button type="submit" >서버 전송 #1</button>
	
	</form>
</body>
</html>


















