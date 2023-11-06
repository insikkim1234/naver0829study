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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<style>
	.loginform{
		position:absolute;
		left:400px;
		top:400px;
	}
        
</style>
</head>
<%
	//세션으로부터 아이디와 체크저장값을 얻는다
	String loginid=(String)session.getAttribute("loginid");
	String savestatus=(String)session.getAttribute("savestatus");
	boolean bCheck=false;
	if(savestatus==null || savestatus.equals("no")){
		bCheck=false;//체크를 안했을 경우
	}else{
		bCheck=true;//체크를 했을 경우
	}
	
	//체크를 안했을 경우 아이디를 없앤다
	if(!bCheck) loginid="";
%>
<body>
	<div style="margin:30px 100px;">
		<form action="loginaction.jsp" method="post" class="loginform">
			<h5 align="center" style="font-size: 40px;">하루 일정 체크리스트</h5>
			<br>
			<hr width="500" style="height:5px;background-color:gray">
			<br><br>
			<table class="table table-bordered logintable" >
				
				
				<tr>
					<td width=150>
						<input type="text" class="form-control" autofocus required
						placeholder="아이디" name="loginid" value="<%=loginid%>">
						
					</td>
					
				</tr>
				<tr>
					<td width=150>
						<input type="password" class="form-control"  required
						placeholder="비밀번호" name="loginpass">
						
					</td>
				</tr>
				<tr>
					<td>
						<label id="save"><input type="checkbox" name="saveid"
					<%=bCheck?"checked":"" %>><i class="bi bi-person-check "></i>아이디저장</label>
					</td>
				</tr>
				<tr>
					<td  width=150 align="center">
						<button type="submit" style="background:black;"
						class="btn btn-success">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>