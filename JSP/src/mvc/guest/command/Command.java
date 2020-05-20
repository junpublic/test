package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String execute( HttpServletRequest request, HttpServletResponse response  ) throws CommandException;//이커멘드를 상속받은 모든놈들은 이름이 같다
}
