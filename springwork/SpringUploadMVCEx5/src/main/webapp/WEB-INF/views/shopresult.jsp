<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--(10)shopresult.jsp���� shopform.jsp���� post������� ���� ������ ���  -->
	<pre style="font-size:20px;">
		��ǰ��:${dto.sangpum}
		����:${dto.price }��
		����:<b style="background-color:${dto.color }">${dto.color }</b>
		�԰���:${dto.ipgoday }
		���ϸ�:${dto.filename }
		����
		<img src="./res/photo/${dto.filename }" style="max-width:300px;">
	</pre>
</body>
</html>