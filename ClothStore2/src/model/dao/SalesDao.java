package model.dao;

import java.util.ArrayList;

public interface SalesDao {
	public ArrayList selectBydate(String date) throws Exception;
	public ArrayList selectstaffid(String date,String id) throws Exception;
	public ArrayList selectByMonth(String date) throws Exception;
	public ArrayList selectMstaffid(String date,String id) throws Exception;
	public ArrayList selectByYear() throws Exception;
	public ArrayList selectYstaffid(String id) throws Exception;
	public ArrayList selectByProduct() throws Exception;
	public ArrayList selectProductId(String pid) throws Exception;
	
	
}
