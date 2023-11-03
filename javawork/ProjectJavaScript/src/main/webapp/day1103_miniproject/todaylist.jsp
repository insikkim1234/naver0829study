<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="today.data.TodayDto"%>
<%@page import="today.data.TodayDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	TodayDao dao=new TodayDao();
		
	List<TodayDto> list=dao.getAllToday();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	JSONArray arr=new JSONArray();
	
	for(TodayDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("login", dto.getLogin());
		ob.put("github", dto.getGithub());
		ob.put("naver", dto.getNaver());
		ob.put("slack", dto.getSlack());
		ob.put("googlenote", dto.getGooglenote());
		ob.put("commit", dto.getCommit());
		ob.put("logout", dto.getLogout());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}


%>
<%=arr.toString()%>