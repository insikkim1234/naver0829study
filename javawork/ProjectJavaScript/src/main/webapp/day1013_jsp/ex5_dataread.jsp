<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Permanent+Marker&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
        body * {
            font-family: 'Jua';
        }
</style>
</head>
<%
	//get방식 폼데이터 읽기
	String irum=request.getParameter("irum");//태그의 name에 입력한 값을 문자열 형식으로 반환
	String currentPage=request.getParameter("currentPage");
	String message=request.getParameter("message");
%>
<body>
	<h5>폼에 입력한값 출력-get방식 (톰캣8부터 한글안깨짐)</h5>
	<pre style="font-size:2em">
		이름:<%=irum %>
		페이지 번호:<%=currentPage %>
		메시지:<%=message %>
	</pre>
</body>
</html>