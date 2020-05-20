package mvc.guest.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.guest.model.Message;
import mvc.guest.model.MessageDao;
import mvc.guest.model.MessageException;

public class CommandList implements Command 
{
	private String next;

	public CommandList( String _next ){
		next = _next;//jsp파일경로? 를 저장해놓음
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		try{
			
		    List <Message> mList = MessageDao.getInstance().selectList();	
		    request.setAttribute("param", mList );//위으 목록을 한번에 저장,서버에저장

		}catch( MessageException ex ){
			throw new CommandException("CommandList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
}
