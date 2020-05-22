<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.service.*, board.model.*" %>
<%
	String projectName = "/Board";
	// 1. 수정할 레코드의 게시글번호를 넘거받기
	String id = String.valueOf(request.getAttribute("articleId")) ;
	// 2. Service에 getArticleById()함수를 호출하여 그 게시글번호의 레코드를 검색
	BoardRec rec =  (BoardRec)request.getAttribute("result");
// 	service.update(rec);

	
%>   
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정하기</title>
<script type="text/javascript">
function checkFields()
{
	var frmObj = document.frm;
	
	frmObj.action = "<%= projectName %>/BoardControl?cmd=modify-page";
	frmObj.submit();
}
</script>
</head>
 <body>
	<h4> 게시판 글 수정하기 </h4><br/>
	<form name='frm' method='post' >
	<input type='hidden' name='articleId' value="<%=id%>">
	제  목 : <input name='title'  type='text' value='<%=rec.getTitle()%>'><br/><br/>
	패스워드(수정/삭제시 필요) :
			<input name='password'  type='password'><br/><br/>
	내  용 : <textarea name='content' rows='10' cols='40'><%=rec.getContent()%></textarea><br/><br/>

	<input type='button' value='수정하기' onclick="Javascript:checkFields()">
	<input type='button' value='목록보기' >
	</form>

</body>
</html>