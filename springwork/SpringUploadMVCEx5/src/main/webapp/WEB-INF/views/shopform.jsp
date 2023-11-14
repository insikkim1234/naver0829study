<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- (3)shopform.jsp에서 post방식으로 상품명,색상,가격,입고일,사진 을 읽기 위한 틀,전송버튼 생성  -->
	<form action="./addshop" method="post" 
	enctype="multipart/form-data">
		상품명: <input type="text" name="sangpum"><br>
		색상: <input type="color" name="color" value="#ffccff"><br>
		가격: <input type="number" name="price"><br>
		입고일: <input type="date" name="ipgoday" value="2023-12-12"><br>	
		사진: <input type="file" name="photo"><br>
		<button type="submit">서버에 전송</button>
	</form>
</body>
</html>