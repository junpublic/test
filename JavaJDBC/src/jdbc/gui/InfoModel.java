package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InfoModel {//확장성을 위해서 인터페이스를 사용함
	void insert(InfoVO vo) throws SQLException;//public abstract 안써도 자동으로 붙음
	ArrayList<InfoVO> selectAll() throws SQLException;
	void delete(String tel) throws SQLException;
	InfoVO selectBytel(String tel) throws SQLException;
	
	void modify(InfoVO vo )throws SQLException;
}
