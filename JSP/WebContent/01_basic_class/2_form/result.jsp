<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  1.폼의 입력값을 얻어오기 
    (아이디,비밀번호,이름,전화번호,주소)-->
    <%@ page import = 'temp.*' %>
    <% 
    request.setCharacterEncoding("utf-8");//넘어온 파일을 한글로 먼저 변환해줘야 한다.
    	
    	//입력받은 파라메타값들을 가져와서 변수에 저장
   		String id = request.getParameter("id");
    	String pass = request.getParameter("password");
    	String name = request.getParameter("name");
    	String tel = request.getParameter("tel");
    	String addr = request.getParameter("adr");
    	
    	//객체에 저장
    	TempVO vo = new TempVO();
    	vo.setId(id);
    	vo.setAddr(addr);
    	vo.setName(name);
    	vo.setPass(pass);
    	vo.setTel(tel);
    	
    	//클래스생성, 저장한 값을 넘김
    	TempDAO dao = TempDAO.getInstance();//이렇게 접근하려면 클래스명 접근을 해야함
    	dao.insert(vo);
    	
    	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  2.얻어온 입력값을 출력 -->
<h2>폼의 입력값 넘겨받아 처리</h2>
	이름 : <%= name %> <br/>
	성별 : <%= pass %><br/>
	아이디 : <%= id %><br/>
	전화번호 : <%= tel %><br/>
	주소 : <%= addr %><br/>
</body>
</html>