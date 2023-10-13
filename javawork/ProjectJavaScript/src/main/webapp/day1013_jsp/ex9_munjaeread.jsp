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
			
			
			String line=request.getParameter("Line");
			String photo=request.getParameter("photo");
			String today=request.getParameter("today");
			
		%>
<body>
	<h5>날짜 : <%=today %></h5>
	<br><br>
	<img src="<%=photo %>" style="border:<%=line %>;">
	
	
</body>
</html>