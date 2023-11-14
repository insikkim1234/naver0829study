<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h3>post방식으로 각각 읽기</h3>
	<form action="./process2" method="post">
		메시지:<input type="text" name="message"><br>
		아이콘선택:
			<select name="animal">
				<option>C1.png</option>
				<option>C2.png</option>
				<option>C3.png</option>
				<option>C4.png</option>
				<option>C5.png</option>
			</select>
		<br>
		<button type="submit">전송#2</button>	
	</form>
</body>
</html>