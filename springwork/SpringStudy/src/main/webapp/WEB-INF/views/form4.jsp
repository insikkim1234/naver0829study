<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (24)form4.jsp ���� post-map������� ��ǰ��,����,����,�ܰ�,����,��¥ �а� ������ ���� Ʋ,���۹�ư ����  -->
<form action="./process4" method="post">
	��ǰ��: <input type="text" name="sang"><br>
	����: 
		<select name="photo">
			<option>C1.png</option>
			<option>C2.png</option>
			<option>C3.png</option>
		</select>
		<br>
	����: <input type="text" name="su"><br>
	�ܰ�: <input type="text" name="dan"><br>
	����: <input type="color" name="color" value="#ccffcc"><br>
	��¥: <input type="date" name="today" value="2023-12-25"><br>	
	
	<button type="submit">����#4</button>
	</form>
</body>
</html>