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
<!-- (52)testresult.jsp에 사진(원본,좌우80,좌우150)출력해주기 위한 폼 작성 -->
<h5>80*80사진</h5>
<img src="${photo80 }" border="1">
<hr>
<h5>150*150사진</h5>
<img src="${photo150 }" border="1">
<hr>
<h5>원본사진</h5>
<img src="${photo }" border="1">
<hr>

</body>
</html>