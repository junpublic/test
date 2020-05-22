package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;
import board.service.ModifyArticleService;
import board.service.ViewArticleService;


public class CommandModify2 implements Command {
	private String next;

	public CommandModify2( String _next ){ 
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {

		try{
				
			BoardRec msg = new BoardRec();
			

			msg.setArticleId(Integer.parseInt(request.getParameter("articleId")) );
			msg.setPassword(request.getParameter("password"));
			msg.setTitle( request.getParameter("title"));
			msg.setContent( request.getParameter("content"));
			
			int resultCnt=ModifyArticleService.getInstance().update(msg);
			
			request.setAttribute("articleId", request.getParameter("articleId"));
			request.setAttribute("result", resultCnt);
		}catch( BoardException ex ){
			throw new CommandException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
