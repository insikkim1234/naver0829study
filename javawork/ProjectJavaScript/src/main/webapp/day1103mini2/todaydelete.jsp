<%@page import="today.data.TodayDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");

	TodayDao dao=new TodayDao();
	
	dao.deleteToday(num);
	
	response.sendRedirect("loginmain.jsp");
%>