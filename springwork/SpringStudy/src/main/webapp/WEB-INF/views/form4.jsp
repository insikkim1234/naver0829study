<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (24)form4.jsp 에서 post-map방식으로 상품명,사진,수량,단가,색상,날짜 읽고 보내기 위한 틀,전송버튼 생성  -->
<form action="./process4" method="post">
	상품명: <input type="text" name="sang"><br>
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
	
	<button type="submit">전송#4</button>
	</form>
</body>
</html>