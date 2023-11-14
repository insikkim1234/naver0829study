<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (29)result3.jsp에서 uploadform3.jsp에서 post방식으로 읽은 데이터 출력 -->
	<h3>form3으로 부터 얻은 결과 출력</h3>
	<h3>
		이름:${mdto.name }<br>
		핸드폰:${mdto.hp }<br>
		주소:${mdto.addr }<br>
		파일명1:${mdto.photo }<br>
		파일명2:${mdto.photo2 }<br>
	
	</h3>
	<hr>
	<img src="../photo/${mdto.photo}" width="200" border="2">
	<img src="../photo/${mdto.photo2}" width="200" border="2">
</body>
</html>