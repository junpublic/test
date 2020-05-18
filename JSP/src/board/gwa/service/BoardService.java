package board.gwa.service;

import board.gwa.model.Board;
import board.gwa.session.BoardRepository;
import board.model.BoardRec;

public class BoardService {
	
	private static BoardService service;

	public static BoardService getInstance(){
		if( service == null) service = new BoardService();
		return service;
	}
	private BoardService() {};//생성되면 자동으로 public으로 생성자가 만들어 지는데 그것을 막고자 private로 만든다.
	
	BoardRepository repo = new BoardRepository();
	
	 
	public int deleteBoard(Board c) {
		return repo.deleteBoard(c); //몇개의 행을 입력했는지 받아옴
	}
}
