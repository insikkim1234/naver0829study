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
   
   ul.menu{
   	list-style: none;
   }
   
   ul.menu li{
   	float: left;
   	width: 120px;
   	height: 60px;
   	line-height: 60px;
   	border:1px solid gray;
   	margin-right: 10px;
   	cursor: pointer;
   	text-align: center;
   	font-size: 26px;
   }
   
   ul.menu li a{
   	text-decoration: none;
   	color: green;
   }
  
</style>
</head>
<body>
<!--(16)여성 의류 매장이라는 제목으로 생성   -->
<h1 class="alert alert-danger">여성 의류 매장</h1>
<div style="margin: 30px;">
	<ul class="menu">
	<!-- (17)shop 이 링크면 (3)(4)(5)(6)방식으로 정보 저장 후 포워딩 -->
		<li>
			<a href="./shop/list1">원피스</a>
		</li>
		<li>
			<a href="./shop/list2">슈즈</a>
		</li>
		<li>
			<a href="./shop/list3">악세서리</a>
		</li>
	<!-- (18) (7)(8)(9)방식으로 정보 저장 후 포워딩 -->	
		<li>
			<a href="./food/morning/brunch">브런치</a>
		</li>
	<!-- (19) (10)(11)(12)방식으로 정보 저장 후 포워딩  (20)은 list1.jsp로 이동-->	
		<li>
			<a href="./food/photo/detail">식사사진</a>
		</li>
	</ul>
</div>

</body>
</html>