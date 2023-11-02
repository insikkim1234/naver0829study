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
		[스포츠조선 김가을 기자]표정으로 모든 것을 알 수 있었다.

에릭 텐 하흐 감독이 이끄는 맨유는 2일(이하 한국시각) 영국 맨체스터의 올드 트래퍼드에서 뉴캐슬과 2023~2024시즌 카라바오컵 16강전을 치렀다. 두 팀은 지난 시즌 결승전에서 격돌했다. 당시 맨유가 2대0으로 승리하며 우승컵을 거머쥐었다.

영국 언론 더선은 '브루노 페르난데스와 크리스티안 에릭센의 벤치 표정은 맨유의 상황이 얼마나 나쁜지를 요약한다. 맨유 팬들은 둘의 표정을 발견한 뒤 우울하다고 생각한다'고 보도했다.

맨유는 올 시즌 세 대회를 병행하고 있다. 잉글랜드 프리미어리그(EPL), 유럽챔피언스리그(UCL), 카라바오컵에서 우승을 정조준한다. 빡빡한 일정은 피할 수 없다. 3일 간격으로 경기를 치른다. 맨유는 뉴캐슬을 맞아 일부 로테이션을 가동했다. 페르난데스와 에릭센은 벤치에서 경기를 시작했다. 맨유는 전반에만 상대에 두 골을 내주며 끌려갔다.

더선은 '페르난데스와 에릭센이 참담한 표정을 짓고 있는 모습이 카메라에 잡혔다'고 했다. 이 매체의 보도에 따르면 팬들은 '벤치에 앉아있는 페르난데스와 에릭센을 보라. 그들은 우울해하고 있다', '페르난데스가 벤치에서 얼마나 비참해 보이는가', '페르난데스의 반응이 모든 것을 말해준다' 등의 반응을 보였다.

이날 맨유는 결국 0대3으로 완패, 카라바오컵 도전을 마감했다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
		<% }
%>

</body>
</html>