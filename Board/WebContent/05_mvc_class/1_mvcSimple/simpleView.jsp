<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%
//************************************************************
//request.getParameter():클라이언트에서 보낸 값 받을 떄
//request.getAttribute():서버에서 저장한 값 받을 때
//************************************************************
	Object obj = request.getAttribute("param");//서버에서 저장한 값을 가져올때는 getAttribute
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 메인이라네 </title>
</head>
<body>
	
		<%= obj %> <br/>
		복잡하다고 지나친 좌절과 놀람은 금물입니다. <br/><br/>
		<img src="05_mvc_class/1_mvcSimple/imgs/sponge_1.JPG"/><br/><br/>

</body>
</html>