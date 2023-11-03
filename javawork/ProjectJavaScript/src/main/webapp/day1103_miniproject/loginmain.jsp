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
<script>
	
</script>
</head>
<%
	Cookie []cookies=request.getCookies();
	boolean find=false;
	
	if(cookies !=null)
	{
		for(Cookie ck:cookies)
		{
			String name=ck.getName();
			if(name.equals("loginok")){
				find=true;
			}
		}
	}

%>
<body>
	<div style="margin:30px;">
		<% if(find){ %>
			<jsp:include page="logoutform.jsp"/>
		<%} else {%>
			<jsp:include page="loginform.jsp"/>
		<%} %>
		
		<hr width="500" style="height:5px; background-color:gray">
	</div>	
	 
	<jsp:include page="todaymain.html"/>
	
</body>
</html>