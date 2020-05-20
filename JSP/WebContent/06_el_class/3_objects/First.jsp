<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 표현언어의 기본객체</title>
</head>
<body>

<%

	session.setAttribute("login", "당신의아이디");
	Cookie c = new Cookie("isFlag","true");//클라이언트가 저장,리스펀스로 꼭 보내줘야 함 그래야 받을 수 있음
	response.addCookie(c);
	
%>

	데이타 보냈습니다. <br/>
	
	<a href ="Second.jsp?data=important"> 다음 페이지 </a>
	
</body>
</html>