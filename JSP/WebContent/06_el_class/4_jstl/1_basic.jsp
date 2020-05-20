<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix='c'	uri="http://java.sun.com/jsp/jstl/core" %>   <%-- 이름을 c로 준다 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic.jsp</title>
</head>
<body>
<!-- 변수선언 -->
<c:set var='gender' value='male'/>
<c:if test="${gender eq 'male'}">당신은 남정네 </c:if> <%-- eq = '==' --%>
<c:if test="${gender eq 'female'}">당신은 여인네 </c:if><br/><hr/>

<c:set var='age'>17</c:set>
<c:if test="${age ge 20}">성인</c:if><br/><hr/>

<c:choose>
	<c:when test="${age ge 0 and age le 10}">어린이</c:when>
	<c:when test="${age ge 13}">청소년</c:when>
</c:choose>
<br/><hr/>

<c:forEach var='i' begin='1' end='100'>
	<c:set var='sum' value='${sum+i}'></c:set>
</c:forEach>
1~100까지의 합: ${sum }<br/>

<c:forEach var='i' begin='1' end='100'>
	<%-- <c:if test="${(i mod 2) eq 0}" ><c:set var='j' value='${i}'/> </c:if>
	<c:set var='odd' value='${odd+j}'></c:set> --%>
	<c:if test="${(i mod 2) eq 0}" ><c:set var='odd' value='${odd+i}'/> </c:if>
</c:forEach>
1~100까지의 홀수의 합: ${odd }
<br/><hr/>

<c:forEach var='i' begin='1' end='100'>
	<c:if test="${(i mod 2) eq 1}" ><c:set var='even' value='${even+i}'/> </c:if>
</c:forEach>
1~100까지의 짝수의 합: ${even }
<br/><hr/>

</body>
</html>