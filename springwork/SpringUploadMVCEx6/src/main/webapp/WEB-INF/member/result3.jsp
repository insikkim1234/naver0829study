<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (29)result3.jsp���� uploadform3.jsp���� post������� ���� ������ ��� -->
	<h3>form3���� ���� ���� ��� ���</h3>
	<h3>
		�̸�:${mdto.name }<br>
		�ڵ���:${mdto.hp }<br>
		�ּ�:${mdto.addr }<br>
		���ϸ�1:${mdto.photo }<br>
		���ϸ�2:${mdto.photo2 }<br>
	
	</h3>
	<hr>
	<img src="../photo/${mdto.photo}" width="200" border="2">
	<img src="../photo/${mdto.photo2}" width="200" border="2">
</body>
</html>