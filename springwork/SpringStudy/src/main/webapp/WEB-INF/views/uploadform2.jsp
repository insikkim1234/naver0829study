<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (41)uploadform2.jsp에서 post방식으로 제목, 사진 여러장을 읽고 보내기 위한 틀,전송버튼 생성 -->
<form action="./upload1" method="post" enctype="multipart/form-data">
		제목:<input type="text" name="title"><br>
		사진 1장:<input type="file" name="upload" multiple="multiple"><br>
		<button type="submit">파일전송#1</button>
	
	</form>
</body>
</html>