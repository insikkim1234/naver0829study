<%@page import="java.text.SimpleDateFormat"%>
<%@page import="today.data.TodayDto"%>
<%@page import="java.util.List"%>
<%@page import="today.data.TodayDao"%>
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
  
  		tr{
  		background:darkgray;
  		color:yellow;
  		}
  		
  		h5{
			transition:font-size 5s;
		}
		h5:hover{
			font-size: 500%;
		}
		h5{
			background-color:blanchedalmond;
		}
  		
</style>
</head>
<body>
	<%
		TodayDao dao=new TodayDao();
		List<TodayDto> list=dao.getAllToday();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd시");
	
	%>

	<div class="input-group" >
		<h5 class="alert alert-danger" >
			총 <%=list.size() %>일 출석하였습니다
		</h5>	
	</div>
	
	<table class="table table-bordered ">
			
			<thead>
				<tr>
					<th>출석일</th>
					
					<th>등록시간</th>
				</tr>
			</thead>
			
			<tbody>
				<%
				int n=0;
				for(TodayDto dto:list)
				{%>
				<tr>
					<td> <%=++n %></td>
					<td> <%=dto.getWriteday() %></td>
				</tr>	
				<%}%>
			</tbody>
		</table>	
	</body>			
</html>














