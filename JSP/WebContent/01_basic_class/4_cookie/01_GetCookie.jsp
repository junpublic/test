<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head><title>쿠키</title></head>
<body>	

<h1>Cookie 정보 알아내기</h1>

<h4>다음은 클라이언트 브라우저의 쿠키에서 얻어온 값 : </h4><br><br>

<%	
	// 1. 클라이언트로부터 Cookie를 얻어옴 
	Cookie[] c = request.getCookies();//쿠키는 여러개가 넘어올수도 있다.s붙이기
	
	// 2. 쿠키 이름 중에 "JJ"가 있다면 그 쿠키의 값을 출력
	for(int i=0;c!=null&&i<c.length;i++){// c.length//c가 null이면 NullExecption이 발생ㅇ함 c!=null로 예외처리해줌
		if(c[i].getName().equals("JJ")){
			out.print(c[i].getValue());
		}
	}
%>

<br><a href="01_ChangeCookie.jsp"> 쿠키값 변경 </a><br/>
<br><a href="01_RemoveCookie.jsp"> 쿠키제거 </a>

</body></html>
