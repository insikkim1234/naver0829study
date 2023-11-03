<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//아이디와 비번을 읽는다
	String loginid=request.getParameter("loginid");
	String loginpass=request.getParameter("loginpass");
	String saveid=request.getParameter("saveid");//체크를 안할경우 null
	//비번이1234이면 각종 정보를 세션에 저장
	
	if(loginpass.equals("1234")){
		//세션에 저장
		session.setAttribute("loginok","yes");
		session.setAttribute("loginid",loginid);
		session.setAttribute("savestatus",saveid==null?"no":"yes");
		
		//유지시간지정
		session.setMaxInactiveInterval(60*60);//1시간 유지
		//메인 페이지로 이동
		response.sendRedirect("loginmain.jsp");
	}else{%>
		<script>
			alert("비밀번호가 맞지 않습니다");
			history.back();
		</script>
		
	
	<%}%>