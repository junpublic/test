<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.gwa.model.*,board.gwa.service.*" %>

	 <!-- 앞에서 받아온 값을 한글로 변환 -->
	 <% 
	 	request.setCharacterEncoding("utf-8");
	 %>
	  
	 <!--  이전 폼의 각각의 데이터를 빈즈의 멤버로 지정  -->
	 <jsp:useBean id="board" class="board.gwa.model.Board">
	 	<jsp:setProperty name="board" property="*"/>
	 </jsp:useBean>   
	 
	 <!-- 서비스의 메소드 호출  -->
	 <%	
	
	 int result = BoardService.getInstance().deleteBoard(board);
	 %>

<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 삭제 </title>
</head>
<body>
	
	<% if( result != 0) { %>
			글을 삭제하였습니다.
	<% } else { %>
			삭제가 실패되었습니다.
	<% } %>
	<br/><br/>
	<a href="BoardList.jsp"> 목록보기 </a>
</body>
</html>