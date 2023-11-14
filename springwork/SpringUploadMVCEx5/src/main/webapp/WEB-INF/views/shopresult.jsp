<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--(10)shopresult.jsp에서 shopform.jsp에서 post방식으로 읽은 데이터 출력  -->
	<pre style="font-size:20px;">
		상품명:${dto.sangpum}
		가격:${dto.price }원
		색상:<b style="background-color:${dto.color }">${dto.color }</b>
		입고일:${dto.ipgoday }
		파일명:${dto.filename }
		사진
		<img src="./res/photo/${dto.filename }" style="max-width:300px;">
	</pre>
</body>
</html>