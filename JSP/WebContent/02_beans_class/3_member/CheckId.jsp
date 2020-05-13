<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="member.beans.*" %>
  <%
  String id = request.getParameter("userId");//사용자 아이디를 가져와서 넣음
  MemberDao dao = MemberDao.getInstance();//아이디값을 얻어와서 넣음
  
 

  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 아이디 중복 확인 </title>
<script type="text/javascript">
window.onload = function() { 
	var header = document.getElementById('jb'); // header 객체에 onclick 이벤트 속성을 연결 
	header.onclick = function() {  
		 var id = document.getElementsByName("userId")[0].value;
		
		opener.document.getElementsByName("id")[0].value=id; 
	
		window.close();	
	} 
};


</script>
</head>
<body>
<%
	if(dao.isDuplicatedId(id) ) {
%>
		사용중인 아이디가 있습니다. 다시 입력하여 주십시오.
<%  }else { %>
		사용할 수 있는 아이디입니다.
<%  } %>

<form action="">

	<input type='text' name='userId' value='<%=id%>'><!-- name='userId'로 해서 자기를 계속 부름? -->
	<input  type='submit' value = '중복확인'>
	<input id = 'jb' type='button' value = '아이디채택'>
</form>

</body>
</html>