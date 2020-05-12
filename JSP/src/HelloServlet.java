

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();//부모의 생성자 함수를 부름
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//응답을 주는 놈 response
		response.setContentType("text/html;charset=UTF-8");
	
		PrintWriter out = response.getWriter();//문자형으로 출력하는 놈들은 Writer
		
		out.write("<html><body>");
		out.write("<h2>나의 첫 웹서버</h2>");
		out.write("</body></html>");
	
		out.close();
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());//진짜 불려지는 놈은 이놈
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
