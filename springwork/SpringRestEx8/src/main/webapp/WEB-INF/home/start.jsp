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
<!-- (4)start.jsp에 내용 추가 -->
<body>
<h3 class="alert alert-danger">Spring REST 예제들</h3>
<!-- (49)start.jsp에 사진 찍어놨던거 주석으로 묶고 
/memo/list,/storage/form ,/storage/common링크 만들기 -->
<ul>
	<li>
		<a href="./memo/list">간단한 메모 사진한장 업로드 포함</a>
	</li>
	<li>
		<a href="./storage/form">네이버 스토리지에 사진 올려보기연습</a>
	</li>
	<li>
		<a href="./storage/common">네이버 스토리지에 사진 db저장</a>
	</li>
</ul>
<hr>
<!-- (40)start.jsp에 강사님이 업로드한 사진 복붙해서 잘 되는지 확인해보기 -->
<!-- <h5>원본</h5>
<img src="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/13.jpg">
<h5>80*80</h5>
<img src="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/13.jpg?type=f&w=80&h=80&faceopt=true&ttype=jpg">
<h5>150*150</h5>
<img src="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/13.jpg?type=f&w=150&h=150&faceopt=true&ttype=jpg"> -->


<!-- (41)새로운 데베 생성하기 -->
<!--     create table photodb (
		num smallint auto_increment primary key,
        title varchar(30),
        photo varchar(200),
        photo80 varchar(200),
        photo150 varchar(200),
        writeday datetime); -->






</body>
</html>