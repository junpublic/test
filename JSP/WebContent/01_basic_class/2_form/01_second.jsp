<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "temp.*" %>
<!-- 
	클라이언트 ->서버 :request(요청)
	서버 -> 클라이언트:response(응답)
	서버에서 뭔가를 찾을때는 name으로만 찾을 수 있다.
 -->
<%
	String user = request.getParameter("User");//대소문자 가림//파라메터값을 가져옴
	String pass = request.getParameter("Pass");
	
	//1.TempVO 객체에 멤버로 위의 값들을 지정
	TempVO vo = new TempVO();
	vo.setId(user);//first에서 받은 값들을 객체에 저장
	vo.setPass(pass);
	
	//2.TempDAO 의 login()를 호출하기
	TempDAO dao = TempDAO.getInstance();//이렇게 접근하려면 클래스명 접근을 해야함//getInstance():싱글턴패턴,하나의 인스턴스만 가지고 공유해서 쓴다.
    boolean success = dao.login(vo);//객체를 로그인 함수로 넘김
// 	String isok = "";
	
	if(!success){//success == false 로그인 실패시
		response.sendRedirect("01_first.jsp"); //화면을 첫번쨰 페이지로 바꿈
	}

%> 
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 폼의 입력값 처리 </title>
</head>
<body>
	<h2>폼의 입력값 넘겨받아 처리</h2>
	
	<!-- 결과에 의해서 로그인 성공 여부 출력 -->
<%-- 	<%=isok %> --%>
</body>
</html>