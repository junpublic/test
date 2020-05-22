package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;


public class CommandDelete implements Command {
	private String next;

	public CommandDelete( String _next ){
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {

		try{
				
			int messageId = Integer.parseInt(request.getParameter("articleId"));
			String password = request.getParameter("password");
			
			int resultCnt = BoardDao.getInstance().delete(messageId, password);
			
			request.setAttribute("result", resultCnt);
		}catch( BoardException ex ){
			throw new CommandException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
