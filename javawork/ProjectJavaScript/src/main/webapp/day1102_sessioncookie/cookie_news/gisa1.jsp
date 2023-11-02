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
	Cookie []cookies=request.getCookies();
	boolean find=false;
	if(cookies !=null)
	{
		for(Cookie ck:cookies)
		{
			//저장된 쿠키 이름 얻기
			String name=ck.getName();
			if(name.equals("loginok")){
				find=true;//해당 쿠키가 존재하면 트루
			}
		}
	}
%>
<body>
<%
	if(!find){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
		<% } else {%>
		<pre style="width:500px;">
		[OSEN=노진주 기자] 오현규(22, 셀틱)가 시즌 마수걸이 득점을 작렬하며 '입지 불안' 해소 신호탄을 쐈다.

셀틱은 2일(한국시간) 스코틀랜드 글래스고 셀틱 파크에서 열린 2023-2024 스코티시 프리미어리그 11라운드에서 세인트 미렌을 2-1로 꺾었다.

이날 경기로 셀틱은 무패행진을 ‘11경기(9승 2무)’로 늘렸다. 승점 29로 선두 자리를 유지했다. 

셀틱은 최근 유럽축구연맹 챔피언스리그 포함 2경기 연속 무승부로 승리는 거두지 못했다. 그러나 이날 교체 출전한 오현규가 경기 막판 결승골을 기록, 드디어 승전고를 울렸다. 

세인트 미렌을 상대로 셀틱의 출발은 썩 좋지 못했다. 전반 7분 코너 맥메나민에게 선제골을 내주며 불안하게 출발했다. 전반 18분 턴불의 동점골로 1-1을 만들긴 했지만, 후반 막판까지 추가골을 만들어내지 못했다. 후반 11분 양현준과 마에다 다이젠을 투입하는 등 적극적으로 교체 카드를 사용했으나 득점으로 이어지진 않았다.
		
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
		<% }%>

</body>
</html>