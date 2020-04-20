package model;

import java.util.ArrayList;

public interface RentDao {
	
	public String selectByTel(String tel) throws Exception;//전화번호로 찾음
	public void rentVdieo(String tel,int vnum) throws Exception;//
	public int retrunVdieo(int vnum) throws Exception;//반납
	public ArrayList selectList() throws Exception;//미납목록
}
