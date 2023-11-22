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
   

  
</style>

<script type="text/javascript">
/* (45)memberlist.jsp에서 $funciton 안에탈퇴 이벤트 작성 */
  
 		//1)최초 상태로는 빈 값들을 넘겨주면서 전체가 나올 수 있도록 함
	let field="",word="";
	$(function(){
		//2)처음 로딩시 전체 멤버 출력 
		list();
		
		//3)검색버튼 누를시 반응성
		$("#btnsearch").click(function(){
			//1.field에 검색할 필드 저장,word에는 검색단어 입력
			field=$("#field").val();
			word=$("#word").val();
			//2.리스트 함수를 통해 1. 에서 전달해준 튜플만 출력해준다
			list();
		});
		
		//4)탈퇴 글씨 클릭할때 반응성
		$(document).on("click",".memberdel",function(){
			//1.클릭하면 경고창으로 한번더 확인
			let a=confirm("해당 회원을 탈퇴시키려면 확인");
			//2.확인버튼을 눌러 a==true이면
			if(a){
			//3.num에 해당 튜플의 num값 저장	
				let num=$(this).attr("num");
			//4.ajax방식으로 get방식으로 텍스트를 받아 /member/delete에
			//{"num":num}데이터를 저장
				$.ajax({
					type:"get",
					dataType:"text",
					url:"./delete",
					data:{"num":num},
			//5.성공시 word다시 편하게 입력하도록 초기화 후 리스트 재출력		
					success:function(res){
						word="";//전역변수라 마지막 검색 단어를 갖고 있으므로 초기화 해준다
						list();//삭제 후 전체 목록 다시 출력
					}
				});
			}
		});
	});
	//(41)memberlist.jsp js파트에 검색버튼 누르면 이벤트 작성,리스트 나오는 list() 함수 작성
	function list()
	{
			//1)아약스 방식으로 get타입으로 json형태로 받을 것이며
			// /member/search 경로로 이동 시킬것임	
			//데이터로는 {"field":field,"word":word} 두개 전송
			$.ajax({
				type:"get",
				dataType:"json",
				url:"./search",
				data:{"field":field,"word":word},
			//2)성공하면 변수 s에 튜플을 모두 저장할것임	
				success:function(res){
					let s="";
					//3)s 안에 어트리뷰트 저장
					//4)s 안에 반복문으로 모든 튜플 출력	
						/* 1. imgsrc에 받은 사진이 없으면 noimage.png,있으면 해당 이미지를 출력	 */
						/* 2. 해당 imgsrc를 img태그 안에 출력(원형으로 만듦),이름 출력		 */
						/* 3.myid,hp,email,gaipday출력	 */	
						/* 4.db에서 지우기 위한 탈퇴 버튼도 생성 */	
					s+=
						`
						<table class="table table-bordered" 
							style="width:800px;">
							
							<thead>
								<tr>
									<th width=200>이름</th>
									<th width=100>아이디</th>
									<th width=150>핸드폰</th>
									<th width=200>이메일</th>
									<th width=300>가입일</th>
									<th width=100>탈퇴</th>
								</tr>
							</thead>
						
							<tbody>
						`;
					$.each(res,function(idx,item){
					
						let imgsrc=item.photo=='no'?"../res/photo/noimage.png":"../res/upload/"+item.photo;
						s+=
							`
							<tr>
								<td>
						
								<img src="\${imgsrc}" width=30 height=30 class="rounded-circle"
								hspace=5 border=1>
								\${item.name}
								</td>
						
								<td>\${item.myid}</td>
								<td>\${item.hp}</td>
								<td>\${item.email}</td>
								<td>\${item.gaipday}</td>
							
								<td>
									<span class="memberdel" num="\${item.num}" 
									style="cursor:pointer;color:red;">탈퇴</span>
								</td>
							</tr>
							`;
					});
			//5)밑에 결과 출력하려고 만들어 놓은 빈 html에 s 저장 후 출력			
					$("div.searchlist").html(s);
				}
			});
	}
</script>
</head>
<body>

<!-- (20)memberlist.jsp에 몇명의 회원이 있는지 출력해주는 태그 작성 
(${totalCount})명의 회원이 있습니다) -->
<!-- (21)resources/photo 에 noimage.png복붙(나중에 이미지등록을 안한 회원을 위한 디폴트 사진) -->
<!-- (65) 로그인을 안한 상태에서 회원명단을 클릭시 먼저 로그인을 해주세요 라고 출력
	로그인 시에는 기존 그대로 출력-->	
	<c:if test="${sessionScope.loginok==null}">
		<h3>로그인 명단을 보려면 먼저 로그인 필요</h3>
	</c:if>
	<c:if test="${sessionScope.loginok!=null}">
<div>	
	<h4>현재 총 ${totalCount}명의 회원이 있습니다</h4>
	<br>
	<div class="input-group" style="width:900px;">
		<div class="input-group" style="width:400px;">
			<select id="field" class="form-control">
				<option hidden disabled selected>
					검색할필드
				</option>
				<option value="name">이름</option>
				<option value="myid">아이디</option>
				<option value="hp">핸드폰</option>
				<option value="email">이메일</option>
			</select>
			<!-- (40)memberlist.jsp 에 검색할 필드와 검색단어 입력할수있도록 하는 틀, 전송버튼 생성 -->
			<input type="text" class="form-control" style="margin-left:10px;"
			id="word" placeholder="검색단어입력">
			
			<button type="button" class="btn btn-success btn-sm" id="btnsearch"
			style="margin-left:10px;">
				검색
			</button>
		</div>
<!--(46)memberlist.jsp에서 footer영역 침범 문제 때문에 마지막 결과 출력하는
div에 height 300 overflow auto로 스크롤 만들어주기  -->
		<div class="searchlist" style="margin-top:20px;height:300px;overflow:auto;">
		</div>
	</div>
</div>
</c:if>	

</body>
</html>
















