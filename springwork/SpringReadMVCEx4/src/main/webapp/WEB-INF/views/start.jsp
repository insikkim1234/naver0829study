

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
	<h3>폼 데이터 읽기</h3>
	<hr>
	<ol>
		<li>
			<a href="./form1">폼데이터 읽기-Get방식</a>
		</li>
		<li>
			<a href="./form2">폼데이터 읽기-post방식-각각읽기</a>
		</li>
		<li>
			<a href="./form3">폼데이터 읽기-post방식-dto로 읽기</a>
		</li>
		<li>
			<a href="./form4">폼데이터 읽기-post방식-map으로 읽기</a>
		</li>
		<li>
			<a href="./uploadform1">파일1개 업로드하기</a>
		</li>
		<li>
			<a href="./uploadform2">파일여러개 업로드하기</a>
		</li>
	</ol>

</body>
</html>


