<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="mybatis.guest.model.*" %>    
 <%@ page import="mybatis.guest.service.*" %>   
    
    <!--  이전 폼에서 넘겨오는 데이타의 한글 처리  -->
 <% 
 	request.setCharacterEncoding("utf-8");
 %>
 
  <!--  이전 폼의 각각의 데이터를 빈즈의 멤버로 지정  -->
<jsp:useBean id="comment" class="mybatis.guest.model.Comment">
 	<jsp:setProperty name="comment" property="*"/>
</jsp:useBean>

 <!-- 서비스의 메소드 호출  -->
 <%
 int result = CommentService.getInstance().modifyComment(comment);
 %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyCommentSave</title>
</head>
<body>
	<%if(result != 0){ %>
	수정되었습니다
	<a href="listComment.jsp">목록보기</a>
	<%}else{ %>
	수정실패!!
	<a href="listComment.jsp">목록보기</a>
	<%}//end of if %>
</body>
</html>