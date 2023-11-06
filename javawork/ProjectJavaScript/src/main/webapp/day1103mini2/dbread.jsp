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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
        body * {
            font-family: 'Jua';
        }
      
  		#todaytable{
  			float:right;
  			border:1px  black;
  			font-size: 25px;
  		
  		}
  		thead{
  			background: skyblue;
  			color:white;
  		}
  		
  		#todaytable tbody td{
  			border-bottom: 1px solid black;
  		}
  		
  		#todaytable tbody tr:hover{
  			background: skyblue;
  		}
  		
  		
  		
  		h5{
			transition:font-size 5s;
		}
		h5:hover{
			font-size: 800%;
		}
		
  		
</style>
</head>
<body>
	<%
		TodayDao dao=new TodayDao();
		List<TodayDto> list=dao.getAllToday();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd시");
	
	%>
	
		<div class="input-group"  >
			<h5 class="alert alert-danger" style="background-color: skyblue; color:white;" >
				총 <%=list.size() %>일 출석하였습니다
			</h5>	
		</div>
	
		<table id="todaytable">
			
			<thead>
				<tr>
					<th>출석일</th>
					
					<th style="text-align:center;">퇴근시간</th>
					<th>삭제버튼</th>
				</tr>
			</thead>
			
			<tbody >
				<%
				int n=0;
				for(TodayDto dto:list)
				{%>
				<tr>
					<td> <%=++n %></td>
					<td> <%=dto.getWriteday() %></td>
					<td><i  class="bi bi-trash todaydel"
							style="cursor:pointer;float:right;font-size:14px;"
							num="<%=dto.getNum()%>"></i> 
					</td>
				</tr>	
				<%}%>
			</tbody>
		</table>
		
		
		<script type="text/javascript">
			$(document).on("click",".todaydel",function(){
				let num=$(this).attr("num");
				
				let a=confirm("삭제하려면 확인 클릭");
				if(a){
					location.href="todaydelete.jsp?num="+num;
				}
			});
		</script>	
	</body>			
</html>










<<<<<<< HEAD
=======




>>>>>>> 769b21479ed8cd051e599ba3206331314be43818
