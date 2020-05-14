<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.service.WriteMessageService"%>    

<!-- 
	0. 넘겨받는 데이타의 한글처리
	1. 화면의 입력값을 Message 클래스로 전달
	
	2. Service 클래스의 함수 호출
 -->   
 <%request.setCharacterEncoding("UTF-8");%> 
 <jsp:useBean id="m" class="guest.model.Message"><!-- id는 마음대로 class는  Bean의 위치를 넣어준다. -->
  <jsp:setProperty name='m' property='*' /> <!-- *을 넣어줘서 set에 다 세팅해준다. -->
 </jsp:useBean>

<%
	WriteMessageService service = WriteMessageService.getInstance();
	service.write(m);//서비스로 객체를 넘긴다.
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 남김 </title>
</head>
<body>
	<font size="3" color="#bb44cc">
		<%=m.getMessage() %>방명록에 메세지를 남겼습니다.  
	</font><br/><br/><br/>
	 <a href='listMessage.jsp'>[ 목록보기 ] </a><!-- 어떤 메세지를 넣었는지 보여주는 js파일로 이동 -->
</body>
</html>