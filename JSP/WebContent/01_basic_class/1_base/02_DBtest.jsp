<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>

<!-- 각 페이지마다 지정하지 않고 톰캣의 설정파일에ㅔ서 한 번 지정하자 -->
<%@ page errorPage="02_NormalErrorPage.jsp"%>  <!-- 뭔가가 잘못되면 이 페이지로 보냄//잘 안쓰이고 탐캣에서 다 처리하게함 -->
<%
	
//1. 드라이버 로딩
Class.forName("oracle.jdbc.driver.OracleDriver");
// 2. 연결객체 얻어오기
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.49:1521:orcl", "scott", "tiger");
// 3. sql 문장 만들기
String sql = "SELECT * FROM emp";
// 4. 전송 객체 얻어오기
PreparedStatement ps = con.prepareStatement(sql);
// 5. 전송
ResultSet rs = ps.executeQuery();
%>


<!DOCTYPE html>
<html><head><title> 디비 테스트 </title>
</head>
<body>
 
<div align=center>
<table border=2 cellSpacing=3>

  <tr class="title">
    <td>사번</td>
    <td>사원명</td>
    <td>업무</td>
    <td>관리자사번</td>
    <td>입사일</td></tr>


<% while(rs.next()){//괄호 꼭 해주기%>

	  <tr>
		<td><%=rs.getInt("EMPNO") %></td>
		<td><%=rs.getString("ENAME") %></td>
		<td><%=rs.getString("JOB") %></td>
		<td><%=rs.getInt("MGR") %></td>
		<td><%=rs.getString("HIREDATE") %></td>
		<td><%=rs.getInt("SAL") %></td>
		<td><%=rs.getInt("COMM") %></td>
		<td><%=rs.getInt("DEPTNO") %></td>
	  </tr>
<% } //end of while%>

</table>
</div>
</body>
</html>
