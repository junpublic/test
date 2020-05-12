<!-- 파일형식
	mime-type(일반웹 용어) = content type(jsp)
 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>  <!-- contentType = 파일종류
contentType의 charset : Http Client(웹브라우저)가 받아볼 페이지의 인코딩 방식
                           (Http 헤더에 기록되어 있음)
pageEncoding : JSP파일(페이지)에 기록된 소스코드 자체의 인코딩 방식 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> MIME 타입 </title>
</head>
<body>
	기본적으로 다른 응용 프로그램 실행하기<br><br>
	<a href="03_MimeSecond.jsp"> HTML 파일  </a><br><br><br>
	<a href="03_MimeSecond.jsp?type=word"> WORD  파일 </a><br><br><br>
	<a href="03_MimeSecond.jsp?type=excel"> EXCEL  파일 </a> <br><br><br>
</body>
</html>
