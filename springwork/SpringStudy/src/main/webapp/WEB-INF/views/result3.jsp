<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (23)form3.jsp���� result3.jsp���� post������� ���� ������ ��� -->
	<h1>��¥:${today }</h1>
	<h1>��ǰ��:${shopDto.sang }</h1>
	<h1>����:${shopDto.color }</h1>
	<h1>����:${shopDto.su }</h1>
	<h1>�ܰ�:${shopDto.dan }</h1>
	<h1>�ѱݾ�:${shopDto.su*shopDto.dan}</h1>
	<h3>����</h3>
	<img src="./res/image/${shopDto.photo}">
</body>
</html>