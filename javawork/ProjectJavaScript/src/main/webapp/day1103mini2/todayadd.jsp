<%@page import="today.data.TodayDto"%>


<%@page import="today.data.TodayDao"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	
	TodayDao dao=new TodayDao();
	TodayDto dto=new TodayDto();
	
	
	String login=request.getParameter("login");
	String github=request.getParameter("github");
	String naver=request.getParameter("naver");
	String slack=request.getParameter("slack");
	String googlenote=request.getParameter("googlenote");
	String commit=request.getParameter("commit");
	String logout=request.getParameter("logout");
	
	
	
	
	dto.setLogin("login");
	dto.setGithub("github");
	dto.setNaver("naver");
	dto.setSlack("slack");
	dto.setGooglenote("googlenote");
	dto.setCommit("commit");
	dto.setLogout("logout");
	
	
	
	
	dao.insertToday(dto);


%>