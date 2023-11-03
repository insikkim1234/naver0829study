<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pass=request.getParameter("pass");
	
	if(pass.equals("1234")){
		Cookie cookie=new Cookie("loginok","yes");
		cookie.setMaxAge(60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
		response.sendRedirect("loginmain.jsp");
		
	} else { %>
	
		<script>
			alert("비밀번호가 틀림");
			history.back();
		</script>
		
	<%} %>		
