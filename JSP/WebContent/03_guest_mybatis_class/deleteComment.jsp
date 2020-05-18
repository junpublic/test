<%@page import="mybatis.guest.service.CommentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@page import = "mybatis.guest.model.*" %>
    <%@page import = "mybatis.guest.service.* "%>
    
  <%
  int cNo = Integer.parseInt( request.getParameter("commentNo"));//숫자를 받아옴 
  int result = CommentService.getInstance().deleteComment(cNo);
  %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(result != 0){ %>
	삭제되었습니다.
	<a href="listComment.jsp">목록보기</a>
	<%}else{ %>
	삭제실패!!
	<a href="listComment.jsp">목록보기</a>
	<%}//end of if %>
</body>
</html>