<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
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
        body * {
            font-family: 'Jua';
        }
        /*방문한적 없는 글  */
        a:link{
        	text-decoration:none;
        	color:black;
        }
        /* 한번이라도 방문한글 */
        a:visited{
        	text-decoration:none;
        	color:gray;
        }
        /*마우스를 갖다댄 글  */
        a:hover {
        	text-decoration:underline;
        	color:blue;
        }
        
        .photoicon{
        	font-size:0.8em;
        	color:gray;
        }
</style>
</head>

<%

	//dao선언 sbd conspe
	SimpleBoardDao dao=new SimpleBoardDao();
	//전체 데이타 가져오기list conspe
	List<SimpleBoardDto> list=dao.getAllList();
	//날짜 형식 sdf conspe
	SimpleDateFormat sdf=new SimpleDateFormat("yyy.MM.dd.");
	//댓글 dao선언
	AnswerBoardDao adao=new AnswerBoardDao();
%>
<body>
<div style="margin:30px 50px;">
	<button type="button" class="btn btn-success btn-sm"
	onclick="location.href='boardform.jsp'">글쓰기</button>
	<br>
	<h5><b>총 <%=list.size() %>개의 게시글이 있습니다</b></h5>
	<br>
	<table class="table table-striped" style="width:600px;">
		<thead>
			<tr>
				<th width="50">번호</th>
				<th width="200">제목</th>
				<th width="80">작성자</th>
				<th width="100">작성일</th>
				<th width="70">조회</th>
			</tr>
		</thead>
		<tbody>
		<%
		if(list.size()==0){%>
			<tr height="50">
				<td colspan="5" align="center">
					<h5>등록된 글이 없습니다</h5>
				</td>
			</tr>
		<%}else{
			int n=0;
			for(SimpleBoardDto dto:list)
			{
				//댓글 갯수 가져오기
				int acount=adao.getBoardAnswers(dto.getNum()).size();
				//dto에 저장
				dto.setAnswercount(acount);
			%>
				<tr align="center">
					<td><%=list.size()-n++ %></td>
					<!-- 0을 먼져 빼고 붙어야 하니까 ++은 후치로 붙음
						5-0+1
						5-1+1 -->
					<td align="left">
						<a href="content.jsp?num=<%=dto.getNum() %>">
							<%=dto.getSubject() %>
							
							<%
							if(!dto.getPhoto().equals("no"))
							{%>
								<i class="bi bi-image photoicon"></i>
							<%}
							
							if(acount>0){%>
								&nbsp;
								<span style="color:red">
									(<%=dto.getAnswercount() %>)
								</span>
							<%}
							%>
						</a>
					</td>
					<td><%=dto.getWriter() %></td>	
					<td><%=sdf.format(dto.getWriteday()) %></td>	
					<td><%=dto.getReadcount() %></td>	
				</tr>
			<%}
		}
		%>	
		
		</tbody>
	</table>
</div>
</body>
</html>