<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.model.*,guest.service.*" %>   
<%@ page import="java.util.List" %>
 
<% //누른 번호의 id를 가져와서 그 숫자를 pNum에 저장
	String pNum = request.getParameter("page");
	// 전체 메세지 레코드 검색 
	ListMessageService service = ListMessageService.getInstance();
	List <Message> mList =  service.getMessageList(pNum); /* 많은 메세지를 받음 //받은 페이지에 맞는 list를 만들어냄*/
 	//전체 페이지 수
 	int totalPageCount = service.getTotalCount();//총 몇개의 메세지가 있는지 찾아옴
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 목록 </title>
</head>
<body>

	<% if( mList.isEmpty() ) { %>
		남겨진 메세지가 하나도~~없습니다. <br>
	<% } else { %>
	<table border="1">
	
		<% for(Message m :mList){ //mlist에서 하나씩 뽑아서 m에 저장함%>
		<tr>	
			<td><%= m.getMessageId() %> </td> 
			<td><%= m.getGuestName() %></td> 
			<td><a href="deleteMessage.jsp?messageId=<%=m.getMessageId()%>">[삭제하기] </a> </td>	<!--삭제하고자 하는 메세지의 아이디를 넘겨준다// 넘겨줄 내용을 그냥 넣어버린다 아이디는 값을 그냥 넣음 //공백이 있으면 안된다.-->		
		</tr>
		<tr>
			<td colspan='3'> 
			<textarea cols=35 rows=3 style="font-family: '돋움', '돋움체'; font-size: 10pt; font-style: normal; line-height: normal; color: #003399;background-color:#D4EBFF;border:1 solid #00009C;"><%= m.getMessage() %></textarea>
			</td> <!--윗줄 끝에 보면 m.getMassage가 있는데 그 이유는 앞뒤로 공백이 없어야 하니까 바로 딱 붙여줬다.  -->
		</tr>
		<%}// end of for %>

	</table>
	
	<% } // end if-else %>

	<a href="insertMessage.jsp">글쓰기</a><hr/>
	
	<%for(int i=1;i<=totalPageCount;i++){ %>
		<a href="listMessage.jsp?page=<%=i %>">[<%=i %>]</a><!-- 페이지 번호를 누르면 자기를 불러오면서 아이디 값을 넘겨서 페이지 전환되게 함 -->
	<%} //end of for%>
</body>
</html>