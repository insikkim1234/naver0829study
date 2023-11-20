<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
   
   div.list .box{
   	width: 400px;
   	height: 100px;
   	margin-bottom: 10px;
   	border: 2px solid gray;
   	border-radius: 30px;
   	box-shadow: 3px 3px 3px gray;
   	padding:10px;
   }
   

  
</style>
<!-- (67)commondb.jsp의
javascript</style><script> 부분에 업로드하는 함수,
전송버튼누를 시 함수, 리스트 출력 함수 작성</script></head> -->
<script type="text/javascript">
	$(function(){
		
		
		/* 1)리스트를 다시 출력해주는 함수 */
		list();
	
	
		/* 2)업로드하는 함수 */
		$("#upload").change(function(){
		/* 3) form에 FormData 집어넣기 */	
			let form=new FormData();
		/* 4) 선택한1개의 파일만 추가 */
			form.append("upload",$("#upload")[0].files[0]);
		/*5) ajax를 이용해 파일 선택 성공시 이미지를 붙여줌 */
			//processData:false,
			//서버에 전달하는 데이터는  query string 이라는 형태로 전달된다
			//파일 전송의 경우 이를 하지 않아야 하는데 그 설정이 false
			//contentType:false,: enetype이 원래 기본값이 application/x-www..이건데
			//multipart/form-data 로 변경해준다
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./addphoto",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					//alert(res);//랜덤 파일명 확인 후 이미지 출력
					$(".photo80").attr("src",res);
				}
			});
		});
		/* 6)전송버튼 누를시 함수 */
		//(71)commondb.jsp에 전송버튼 누를시 함수 작성 $("#btnsend").click(function()
		$("#btnsend").click(function(){
			//1)title변수에 입력받은 제목을 저장한다
			let title=$("#title").val();
			//2)제목의 길이가 0이면 제목을 입력하라는 경고창을 출력하고 리턴
			if(title.length==0){
				alert("제목 입력");
				return;
			}
			//3)ajax형태로 post방식,text형식,/adddb경로로 전송,data는 title넘겨줌
			//성공시 업데이트된 목록을 다시 출력하고 제목만 다시 입력할수 있도록 지워 준다
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./adddb",
				data:{"title":title},
				success:function(res){
					list();//목록 다시 출력
					//제목 지우기
					$("#title").val("");
			    }
			});		
		});
		
		//(74) 150사진확인에 마우스 올렸을때,다시 땠을때 이벤트 
		$(document).on("mouseover",".photo150",function(){
			$(this).next().css("display", "block");
		});
		$(document).on("mouseout",".photo150",function(){
			$(this).next().css("display", "none");
		});
		
		//(75)"원본 사진확인"에 마우스 올렸을때,다시 땠을때 이벤트
		$(document).on("mouseover",".photo_or",function(){
			$(this).next().css("display", "block");
		});
		$(document).on("mouseout",".photo_or",function(){
			$(this).next().css("display", "none");
		});
		
		//(77)commondb.jsp에  삭제 버튼 클릭시 튜플이 삭제 되는 함수 작성
		$(document).on("click",".photodel",function(){
			//1)num에 삭제버튼을 클릭한 튜플의 num값을 저장한다
			let num=$(this).attr("num");
			//2)ajax방식을 통해 get방식으로 text를 받을 것이고
			//url은 delete 방식, num을 전달 하면 성공시 삭제 후
			//다시 목록 출력
			$.ajax({
				type:"get",
				dataType:"text",
				url:"./delete",
				data:{"num":num},
				success:function(res){
					list();//삭제후 다시 목록 출력
				}
			});
		});
		
		
		
	});
	/* 7)모든 튜플들을 추가해주는 함수 */
	//(73)commondb.jsp에 div.list .box 스타일 작성하여 튜플들을 이쁘게 꾸며줌
	//,function list() 작성
function list()
	{
		//1)ajax방식으로 데이터를 전송하고 결과를 받을것임
		//get방식으로 보내며 자료형은 json이고 url은 .list이다.
		//결과값으로는 튜플들을 div태그 안에 넣어서 출력할것임
		$.ajax({
			type:"get",
			dataType:"json",
			url:"./list",
			success:function(res){
				let s="";
				$.each(res,function(idx,item){
					s+=
						`
						<div class="box">
		//2)기본으로 출력되는 사진은 80*80(만약 없다면 노이미지 삽입)
							<img src="\${item.photo80}" 
							onerror="this.src='../res/upload/noimage.png'"
							width=80 height=80 align=left hspace=10>
		//3)옆에 입력받은 제목 넣기					
							<span>\${item.title}</span>
		//4)옆에 클릭하면 삭제해주는 삭제버튼도 생성					
							<span style="margin-left:20px;cursor:pointer;color:red;" 
							class="photodel" num="\${item.num}">삭제</span>
							<br>
		//5)커서 올리면 150*150사진 출력해주는 태그도 생성(원래라면 안보이겠지만 마우스를 올리면 보이도록 함)					
							<div class="photo150" style="cursor:pointer;">150사진확인</div>
							<div class="photo1" style="display:none">
								<img src="\${item.photo150}">
							</div>	
		//6)원본 사진 확인해주는 태그도 생성(원래라면 안보이겠지만 마우스를 올리면 보임)					
							<div class="photo_or" style="cursor:pointer;">원본 사진확인</div>
							<div class="photo2" style="display:none">
								<img src="\${item.photo}">
							</div>	
					    </div>
						
						`;
				});
		//7)모든 튜플들을 위의 형식으로 출력		
				$("div.list").html(s);
		    }
		});	
	}

</script>
</head>
<body>
<!-- (66)commondb.jsp 에 
			1)스토리지에 사진 올리는 부분 (제목, 파일 선택 버튼, 선택된 파일이 출력되는 부분,서버 전송 버튼)
			2)선택한 파일에 대한 사진을 올려주는 부분
			3)목록을 나타내는 부분	 -->
	<h4>스토리지에 사진 올리기</h4>
	<div class="input-group" style="width:600px;">
		<input type="text" id="title" style="width:200px;" class="form-control" placeholder="제목넣기">
		<input type="file" id="upload" style="width:200px;" class="form-control">
		<button type="button" id="btnsend">서버전송</button>
	</div>
	80*80 사진만 확인: <img src="" class="photo80">
	<div class="list" style="margin:20px;">목록</div>
</body>
</html>