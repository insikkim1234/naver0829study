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
   /* (33)info.jsp에 
   		css작성 : 밑에서 작성한 html태그의 스타일 작성(너비,높이,테두리,끝부분 둥글게,패딩,배경색
		html 작성:div태그 안에 주소,전화번호,이름이 적히도록 세팅 */
    div.bitinfo{
  	width: 150px;
  	height: 160px;
  	border: 2px solid gray;
  	border-radius: 10px;
  	padding: 10px;
  	background-color: #ddd;
  }

  
</style>
</head>
<body>
<div class="bitinfo">
 	비트캠프<br>
 	강남본원<br><br>
 	<i class="bi bi-telephone-fill"></i>&nbsp;02-555-6666<br>
 	<i class="bi bi-person-heart" style="font-size: 1.5em;"></i>&nbsp;&nbsp;이문희
 </div>

</body>
</html>