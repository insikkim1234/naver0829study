<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (32)uploadform1.jsp에서 post방식으로 제목,사진 1장 읽고 보내기 위한 틀,전송버튼 생성 -->
	<h2>파일 1개 업로드하기</h2>
	<form action="./upload1" method="post" enctype="multipart/form-data">
		제목:<input type="text" name="title"><br>
		사진 1장:<input type="file" name="upload"><br>
		<button type="submit">파일전송#1</button>
	
	</form>
</body>
</html>