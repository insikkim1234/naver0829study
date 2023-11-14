<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (28) result4.jsp에서 form4.jsp에서 post방식으로 읽은 데이터 출력 -->
<h1>날짜:${today }</h1>
<h1>색상:${color }</h1>
<h1>수량:${su }</h1>
<h1>단가:${dan }</h1>
<h1>총금액:${su*dan }</h1>
<h1>사진</h1>
<img src="./res/image/${photo}">
</body>
</html>