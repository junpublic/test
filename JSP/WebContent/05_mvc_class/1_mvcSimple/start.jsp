<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String projectName = "/JSP"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>

<a href="/JSP/05_mvc_class/1_mvcSimple/simpleView.jsp">기본방식</a><hr/><!-- 절대경로에 WebContent는 안써도 된다. -->
<a href="<%=projectName %>/05_mvc_class/1_mvcSimple/simpleView.jsp">기본방식</a><hr/><!-- 프로젝트명을 변수로 해서 수정이 좋게 하자-->
<!--  -->

<a href="<%=projectName %>/SimpleControl">MVC방식</a><hr/>
<a href="<%=projectName %>/sc">MVC방식</a><hr/>
<a href="<%=projectName %>/앙김모리.jj">MVC방식</a><hr/>
<a href="<%=projectName %>/앙김모리.do">MVC방식</a><hr/>


</body>
</html>