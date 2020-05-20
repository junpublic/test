package mvc.simple;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String jspDir = "/05_mvc_class/1_mvcSimple/";//경로를 변수로 받음
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//겟방식하면 오는 함수
		process(request,response);//get방식과 post방식을 해도 둘 다 불려지게함

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//포스트방식하면 불려지는 함수
		process(request,response);//get방식과 post방식을 해도 둘 다 불려지게함
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[1] 사용자 요청을 분석
		String type = request.getParameter("type");
		//[2]사용자 요청에 따라 알맞은 기능 수행
		String value = "";
		if(type == null) value="처음 뵙겠습니다";
		else value = "안녕하세요";
		//[3] request나 session에 결과를 저장
		request.setAttribute("param", value);
		//[4] forwarding 사용자 모르게 페이지 바꾸는거
		//		<jsp:forward>--->자바변환
		RequestDispatcher disp = request.getRequestDispatcher(jspDir+"simpleView.jsp");//화면을 바꿈
		disp.forward(request, response);//화면을 바꿈
	}

}
