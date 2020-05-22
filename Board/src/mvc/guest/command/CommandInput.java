package mvc.guest.command;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;
import board.service.ViewArticleService;
import board.service.WriteArticleService;

public class CommandInput implements Command {
	private String next;

	public CommandInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {
		try{

			BoardRec msg = new BoardRec();
			

			msg.setWriterName( request.getParameter("writerName"));
			msg.setPassword(request.getParameter("password"));
			msg.setTitle( request.getParameter("title"));
			msg.setContent( request.getParameter("content"));
			
			String id = Integer.toString(WriteArticleService.getInstance().write(msg)) ;
			BoardRec resultCnt = ViewArticleService.getInstance().getArticleById(id);
			
			request.setAttribute("articleId", id);
			request.setAttribute("result", resultCnt);
		}catch( BoardException ex ){
			throw new CommandException("CommandInput.java < 입력시 > " + ex.toString() ); 
		}
		return next;
	}

}
