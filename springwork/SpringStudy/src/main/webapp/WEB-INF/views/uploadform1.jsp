<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (32)uploadform1.jsp���� post������� ����,���� 1�� �а� ������ ���� Ʋ,���۹�ư ���� -->
	<h2>���� 1�� ���ε��ϱ�</h2>
	<form action="./upload1" method="post" enctype="multipart/form-data">
		����:<input type="text" name="title"><br>
		���� 1��:<input type="file" name="upload"><br>
		<button type="submit">��������#1</button>
	
	</form>
</body>
</html>