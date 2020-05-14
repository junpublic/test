package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {
	//서비스를 만드는 것은 애매한 놈들을 여기에 쓰기 위해서
	//수정을 덜 하려고 만듬
	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ListMessageService instance;
	
	public static ListMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new ListMessageService();
		}
		return instance;
	}
	
	private ListMessageService()
	{
		
	}
	
	public int getTotalCount() throws MessageException
	{
		MessageDao dao = MessageDao.getInstance();
		
		totalRecCount=dao.getTotalCount();//totalRecCount전체 레코드 수 //메세지 수에 따른 페이지 수를 구함
		//pageTotalCount 구할까?
		//레코드수3- 페이지수 -1
		//레코드수4- 페이지수 -2
		//레코드수5- 페이지수 -2
		//레코드수6- 페이지수 -2
		//레코드수7- 페이지수 -3
		pageTotalCount = totalRecCount / countPerPage;
		if(totalRecCount % countPerPage>0) pageTotalCount++;
	
		return pageTotalCount;
		
	}
	
	public List <Message> getMessageList(String pNum) throws MessageException
	{
		
		int pageNum = 1;//아무것도 안넘어오면 1로해주고
		if(pNum != null) pageNum = Integer.parseInt(pNum);//null이 아니면 
		
		/*
		 * 		pageNum 	firstRow	endRow
		 * 			1			1			3
		 * 			2			4			6
		 * 			3			7			9
		 * 
		 */
		
		
		int endRow = pageNum*countPerPage;
		int firstRow= endRow-2;
		// 전체 레코드를 검색해 온다면
		List <Message> mList = MessageDao.getInstance().selectList(firstRow,endRow);//시작하는 행번호와 끝나는 행 번호를 넣음			
		return mList;
	}
	
	
}
