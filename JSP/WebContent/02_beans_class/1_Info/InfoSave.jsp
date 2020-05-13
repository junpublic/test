<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="info.beans.infoBean" %>
<%

	request.setCharacterEncoding("UTF-8");//한글 안깨지게 해줌
%>
<!--property 이름을 다 같게 해줘야 한다!!!!!!!!!  -->
<jsp:useBean id="bean" class="info.beans.infoBean"><!-- InfoBean bean = new InfoBean();과 같은것 -->
<%-- 	<jsp:setProperty name="bean" property="name" />	<!-- 이전 화면값 가져옴 --> --%>
<%-- 	<jsp:setProperty name="bean" property="id" />	 --%>
	<jsp:setProperty name="bean" property="*" /><!-- *하면 한번에 다 가져옴 , 이 기능이 좋아서 이건 setProperty를 쓴다.-->
</jsp:useBean>

<!DOCTYPE html>
<html>
<body>
	<h2>  당신의 신상명세서 확인 </h2> <!-- getProperty는 너무 길어서 그냥 오른쪽것을 쓴다.  -->
	이   름  :<%-- <jsp:getProperty property="name" name="bean"/> --%> <%= bean.getName() %> <br/>
	주민번호 : <%-- <jsp:getProperty property="id" name="bean"/> --%><%= bean.getId() %> <br/>
	성  별   :<%-- <jsp:getProperty property="gender" name="bean"/> --%> <%= bean.getGender() %> <br/>  
	맞습니까????
</body>
</html>