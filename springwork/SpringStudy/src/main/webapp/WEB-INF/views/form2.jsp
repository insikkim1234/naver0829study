<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h3>post������� ���� �б�</h3>
	<form action="./process2" method="post">
		�޽���:<input type="text" name="message"><br>
		�����ܼ���:
			<select name="animal">
				<option>C1.png</option>
				<option>C2.png</option>
				<option>C3.png</option>
				<option>C4.png</option>
				<option>C5.png</option>
			</select>
		<br>
		<button type="submit">����#2</button>	
	</form>
</body>
</html>