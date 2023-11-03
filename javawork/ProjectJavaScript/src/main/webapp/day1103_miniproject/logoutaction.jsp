<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie []cookies=request.getCookies();

	if(cookies !=null)
	{
		for(Cookie ck: cookies)
		{
			if(ck.getName().equals("loginok")){
				ck.setMaxAge(0);
				ck.setPath("/");
				
				response.addCookie(ck);
				break;
			}
		}
	}
	
	response.sendRedirect("loginmain.jsp");


%>