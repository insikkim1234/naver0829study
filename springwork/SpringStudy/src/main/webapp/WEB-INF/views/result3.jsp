<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (23)form3.jsp에서 result3.jsp에서 post방식으로 읽은 데이터 출력 -->
	<h1>날짜:${today }</h1>
	<h1>상품명:${shopDto.sang }</h1>
	<h1>색상:${shopDto.color }</h1>
	<h1>수량:${shopDto.su }</h1>
	<h1>단가:${shopDto.dan }</h1>
	<h1>총금액:${shopDto.su*shopDto.dan}</h1>
	<h3>사진</h3>
	<img src="./res/image/${shopDto.photo}">
</body>
</html>