<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%!String msg = "안녕하세요"	; %><!-- !는 멤버변수 별로 안쓰니까 필요없음      자바코딩을 마음대로 쓸수 있는놈 --> --%>
<%String name = "홍길자"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 첫 JSP</title>
</head>
<body>
	여기는 JSP입니다. <%=name %>    
	
	<!-- HTML 주석 먹힘  브라우저가 시작하면서 실행하지 않음=이주석은 화면에 띄우기 전까지 오래가니까 너무 많이쓰면 과부화걸림-->
	<% //JAVA 주석 먹힘:java에서 calss변환떄 실행하지 않음 %>
	<%/*
		
	*/%>
	<%-- jsp주석: jsp애서 java로 변환 때 실행하지 않음  --%>
</body>
</html>