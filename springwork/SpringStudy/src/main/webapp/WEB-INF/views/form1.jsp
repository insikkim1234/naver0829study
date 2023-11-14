<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Get방식으로 데이터 읽기</h3>
	<form action="./process1" method="get">
		이름: <input type="text" name="name"><br>
		주소: <input type="text" name="addr"><br>
		나이: <input type="text" name="age"><br>
		<button type="submit">전송#1</button>
	</form>
</body>
</html>