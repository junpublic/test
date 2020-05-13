<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "temp.*" %>
    <!-- temp package import 해줘야 읽을 수있음 -->
<!DOCTYPE html>
<html>
<head>
<title> 로그인확인 </title>
</head>
<body>
<%

	
	// 이전화면 폼에서 넘겨받는 값
	String user = request.getParameter("User");
	String pass = request.getParameter("Pass");

	// 실제로는 DB에서 가져와야하는 값
	 String saveUser = "junpublic";
	String savePass = "qweqwe"; 
	
	//1.TempVO 객체에 멤버로 위의 값들을 지정
	TempVO vo = new TempVO();
	vo.setId(user);//first에서 받은 값들을 객체에 저장
	vo.setPass(pass);
	
 	TempDAO dao = TempDAO.getInstance();//이렇게 접근하려면 클래스명 접근을 해야함//getInstance():싱글턴패턴,하나의 인스턴스만 가지고 공유해서 쓴다.
// 	TempVO success = dao.login(vo);//객체를 로그인 함수로 넘김 
    boolean success = dao.login(vo);//객체를 로그인 함수로 넘김
	/* String saveUser = success.getId();
	String savePass = success.getPass();  */
	 if(success){//success==true 로그인 성공시
		// 1. 쿠키생성
		Cookie c = new Cookie("login",user);
		// 2. 쿠키속성 지정 ( 선택 )
		response.addCookie(c); 
		

	  // user, password가 같을 때 로그인 성공, 그렇지 않으면 로그인 실패
	/* if( ( user.equals(saveUser) ) && ( pass.equals(savePass) ) ){
		
		//#############
		// 1. 쿠키생성
		Cookie c = new Cookie("login",user);//
		// 2. 쿠키속성 지정 ( 선택 )
		response.addCookie(c);
		// 3. 응답으로 쿠키전송   */
%>
					
	<h2> <%= user %>님, 성공적으로 로그인하셨슴다...</h2>
	<p> <a href="02_MainPage.jsp"> 들어가기 </a>

<%
	} else {

%>

	<h2> 로그인에 실패했슴다...</h2>
	<p> <a href="02_LoginForm.jsp"> 되돌아가기 </a>

<%
	}			
%>
	
</body>
</html>