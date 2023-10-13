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
<body>
	<h5>폼데이터 출력</h5>
	<h6>테두리선 종류를 선택</h6>
	<form action="./ex9_munjaeread.jsp" method="post">
		<label>
			<input type="radio" name="Line" value="10px solid gray" checked="checked">실선
		</label>
		&nbsp;
		<label>
			<input type="radio" name="Line" value="10px dotted gray">점선
		</label>
		&nbsp;
		<label>
			<input type="radio" name="Line" value="10px double orange">double
		</label>
		&nbsp;
		<label>
			<input type="radio" name="Line" value="10px groove gold">groove
		</label>
		<br><br>
		<h5>사진 선택</h5>
		<select class="form-select image" style="width:120px" name="photo">
			<option value="../jquery/m02.jpg" >오솔길</option>
			<option value="../jquery/m04.jpg" >바다</option>
			<option value="../jquery/m07.jpg" >계곡</option>
			<option value="../jquery/m08.jpg" >호수</option>
			<option value="../jquery/m09.jpg" >바다2</option>
		</select>
		<br>
		<h5>날짜 선택</h5>
		<input type="date" name="today" value="2023-10-13"><br><br>
		<button type="submit">서버에 전송</button>
	</form>
</body>
</html>