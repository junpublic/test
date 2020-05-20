package mvc.guest.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.guest.command.Command;
import mvc.guest.command.CommandDelete;
import mvc.guest.command.CommandException;
import mvc.guest.command.CommandInput;
import mvc.guest.command.CommandList;
import mvc.guest.command.CommandNull;

/**
 * Servlet implementation class GuestControl
 */
public class BoardControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "/04_board_class_mvc/";
	private String  error = "error.jsp";
	

    public BoardControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		commandMap = new HashMap();

		commandMap.put("main-page",	new CommandNull("main.jsp") );
		commandMap.put("list-page",	new CommandList("BoardList.jsp"));//list-page의 value =new CommandList("listMessage.jsp")
		// 나머지도 추가하기		
		commandMap.put("input-form", new CommandNull("BoardInputForm.jsp"));
		commandMap.put("input-page", new CommandInput("saveMessage.jsp"));
		
		commandMap.put("delete-form",new CommandNull("deleteMessage.jsp"));//화면만 보여주면 되서 db를 안타도됨
		commandMap.put("delete-page",new CommandDelete("deleteConfirm.jsp"));
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글처리

		String nextPage = "";//xxxx?cmd=list-page
		String cmdKey	= request.getParameter("cmd");//사용자에게 커멘드값을 받음
		if( cmdKey == null ){//안들어오면 메인페이지
			cmdKey = "main-page";
		}

		
		Command cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){
				cmd = (Command)commandMap.get(cmdKey);//value가 저장됨 ,다 Command형이여서 형변환 해줘야함
			}else{
				throw new CommandException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response);//오버라이딩해서 상관없음,가지고있는 모든 url정보를 가지고  jsp파일로넘겨서 값을 가져와서 저장

		}catch( CommandException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );//우리가 가지고있는 모든 url을 가지고 화면만 바꿈
		
	}

}
