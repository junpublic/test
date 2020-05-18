<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>    
 <%@ page import="mybatis.guest.service.CommentService" %>   
  
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
 int cNo = Integer.parseInt( request.getParameter("commentNo"));//수정버튼을 눌러서 변수를 받아서 cNo에 넣음
 Comment c =  CommentService.getInstance().selectCommentByPrimaryKey(cNo);//받은값으로 db에서 값을 가져옴
 %>
     



<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title>입력</title>

</head>
<body>

메세지를 남겨주세요.
<form name="frm" action="modifyCommentSave.jsp" >
<input type = 'hidden' name = 'commentNo' value = '<%=c.getCommentNo()%>' />
<table>
	<tr><td>글번호</td><td><input type="text" name="" size="3"/></td></tr><!--name이 꼭 빈즈와 같아야 한다! -->
	<tr><td>사용자</td><td><input type="text" name="userId" size="15" value="<%=c.getUserId()%>"/></td></tr>
	<tr><td>메세지</td><td><textarea name="commentContent" rows="10" columns="40" ><%=c.getCommentContent()%></textarea></td></tr>
	<tr><td><input type="submit" value="수정"/></td></tr>
</table>
</form>
</body>
</html>