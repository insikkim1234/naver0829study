<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (41)uploadform2.jsp���� post������� ����, ���� �������� �а� ������ ���� Ʋ,���۹�ư ���� -->
<form action="./upload1" method="post" enctype="multipart/form-data">
		����:<input type="text" name="title"><br>
		���� 1��:<input type="file" name="upload" multiple="multiple"><br>
		<button type="submit">��������#1</button>
	
	</form>
</body>
</html>