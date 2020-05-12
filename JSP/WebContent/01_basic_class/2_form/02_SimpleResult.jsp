<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
    <!-- 1. 이전 화면에 폼의 입력값들 얻어오기 -->
    <%
    	
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	String occupation = request.getParameter("occupation");
    	String[] hobby = request.getParameterValues("hobby");
    	String hob ="";
    	/* if(hobby != null){
    		for(int i=0;i<hobby.length;i++){
    			hob +=hobby[i] + " ";
    		}
    	}else{
    		hob = "없음";
    	}
    	 */
    	for(int i=0;hobby!=null && i<hobby.length;i++){
			hob +=hobby[i] + " ";
		}
//       	String hobby = request.getParameter("hobby");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2.얻어온 입력값들을 출력 -->

<h2>폼의 입력값 넘겨받아 처리</h2>
	입력한 이름 : <%= name %> <br/>
	입력한 성별 : <%= gender %><br/>
	입력한 직업 : <%= occupation %><br/>
	입력한 취미 : <%= hob %><br/>
</body>
</html>