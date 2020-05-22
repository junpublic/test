package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;
import board.service.ViewArticleService;


public class CommandModify implements Command {
	private String next;

	public CommandModify( String _next ){
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {

		try{
				
			int id = Integer.parseInt(request.getParameter("articleId"));
			
			BoardRec resultCnt = ViewArticleService.getInstance().getArticleById(Integer.toString(id) );
			
			request.setAttribute("articleId", id);
			request.setAttribute("result", resultCnt);
		}catch( BoardException ex ){
			throw new CommandException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
