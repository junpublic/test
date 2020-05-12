<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!-- contentType = 파일종류
contentType의 charset : Http Client(웹브라우저)가 받아볼 페이지의 인코딩 방식
                           (Http 헤더에 기록되어 있음)
pageEncoding : JSP파일(페이지)에 기록된 소스코드 자체의 인코딩 방식 -->

<%!
	Connection conn= null;
	Statement ps =null;
	ResultSet rs =null;

public void DBLoading(){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로딩
	} catch (ClassNotFoundException e ) {}
  

	try{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.49:1521:orcl","scott","tiger");//connection 객체를 생성
	
		ps = conn.createStatement();
		rs = ps.executeQuery("select * from emp");//쿼리문 전달,값에 저장
	} catch (java.sql.SQLException e) {
	    System.out.println(e);
	}
}
%>


<%-- MIME 타입 변경하기 --%>
<%
	//1. request의 객체를 통해 type 이름의 값을 넘겨받는다
	String type = request.getParameter("type");
	//2. null 이라면 html파일 형식으로 기술
	if(type == null){
		
	}else if(type.equals("excel")){//문자열비교는 equals
	//3. excel이라면 excel파일 형식으로 기술
		response.setContentType("application/vnd.ms-excel");
	}else if(type.equals("word")){
	//4. word   라면 word파일 형식으로 기술
		response.setContentType("application/msword");
	}//
%>

<!DOCTYPE html>
<html><head><title>MIME TYPE </title>
<link href='css/emp.css' type='text/css' rel='stylesheet'>

</head>
<body>

<div align=center>
<table border='0' cellSpacing='3'>
  <tbody>
  <tr class="title">
    <td>사번</td>
    <td>사원명</td>
    <td>업무</td>
    <td>관리자사번</td>
    <td>입사일</td></tr>

<% DBLoading(); %>
<% while(rs.next()) { %>
	  <tr>
		<td class="oddRow"><%= rs.getString(1) %></td>
		<td class="oddRow"><%= rs.getString(2) %></td>
		<td class="oddRow"><%= rs.getString(3) %></td>
		<td class="oddRow"><%= rs.getString(4) %></td>
		<td class="oddRow"><%= rs.getString(5) %></td></tr>
		  

		<% if (rs.next()){ %>

		  <tr>
			<td class="evenRow"><%= rs.getString(1) %></td>
			<td class="evenRow"><%= rs.getString(2) %></td>
			<td class="evenRow"><%= rs.getString(3) %></td>
			<td class="evenRow"><%= rs.getString(4) %></td>
			<td class="evenRow"><%= rs.getString(5) %></td></tr>
<% 
			}	// if-end
  } // while-end
%>

</tbody>
</table>
</div>
</body>
</html>
