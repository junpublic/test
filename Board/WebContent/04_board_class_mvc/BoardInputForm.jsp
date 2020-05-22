<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%String projectName = "/Board"; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>

<script type="text/javascript">
function checkFields()
{
	var frmObj = document.frm;
	
	frmObj.action = "<%= projectName %>/BoardControl?cmd=input-page";
	frmObj.submit();
}
</script>
</head>
 <body>
	<h4> 게시판 글 쓰기 </h4><br/>
	나중에 이쁘게 만드시오 <br/><br/>
	<form name='frm' method='post' ><!-- name을 꼭 같게 해줘야한다 아니면 안넘어감 -->
	작성자 : <input name ='writerName' type='text'><br/><br/>
	제  목 : <input name ='title' type='text' ><br/><br/>
	내  용 : <textarea name ='content' rows='10' cols='40'></textarea><br/><br/>
	패스워드(수정/삭제시 필요) :
			 <input name='password'  type='password'><br/><br/>
	<input type='button' value='작성' onclick="Javascript:checkFields()">
	<input type='reset' value='취소'>
	</form>

</body>
</html>