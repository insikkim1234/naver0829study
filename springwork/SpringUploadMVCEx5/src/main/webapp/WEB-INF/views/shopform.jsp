<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (3)shopform.jsp���� post������� ��ǰ��,����,����,�԰���,���� �� �б� ���� Ʋ,���۹�ư ����  -->
	<form action="./addshop" method="post" 
	enctype="multipart/form-data">
		��ǰ��: <input type="text" name="sangpum"><br>
		����: <input type="color" name="color" value="#ffccff"><br>
		����: <input type="number" name="price"><br>
		�԰���: <input type="date" name="ipgoday" value="2023-12-12"><br>	
		����: <input type="file" name="photo"><br>
		<button type="submit">������ ����</button>
	</form>
</body>
</html>