<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 로그인창 </title>
</head>
<body>

<h3>로그인 확인하기 </h3> 
<form action="01_second.jsp" method="post"> <!--  action 속성은 폼 데이터(form data)를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시합니다. method를 안써주면 get으로 가져옴 -->
사용자: <input name='User' type='text'><br/> <!-- ?뒤에 웹페이지에 들어가는 값들을 파라메타라고 부른다. 이 쉑들이 파라메타임-->
비밀번호: <input name='Pass' type='password'><br/> 
<input type='submit' value='login'> 
</form>

</body>
</html>