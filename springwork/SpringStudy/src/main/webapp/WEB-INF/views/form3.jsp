<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (19)form3.jsp에서 post방식으로  상품명,사진,수량,단가,색상,날짜 받기 -->
	<form action="./process3" method="post">
		상품명:<input type="text" name="sang"><br>
		사진:
		<select name="photo">
			<option>C1.png</option>
			<option>C2.png</option>
			<option>C3.png</option>
		</select>
		<br>
		수량: <input type="text" name="su"><br>
		단가: <input type="text" name="dan"><br>
		색상: <input type="color" name="color" value="#ccffcc"><br>
		날짜: <input type="date" name="today" value="2023-12-25"><br>
		<button type="submit">전송#3</button>
	</form>
</body>
</html>