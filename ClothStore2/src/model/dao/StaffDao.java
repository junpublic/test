package model.dao;

import java.util.ArrayList;

import model.vo.Staff;

public interface StaffDao {

   public ArrayList selectStaff(String id, String onTime) throws Exception;
   public ArrayList searchStaffId(String id) throws Exception;
   public int Modify(Staff vo) throws Exception;
   public Staff selectByPK(String sid) throws Exception;
   public void Regist(Staff vo) throws Exception;
   public void DeleteId(String id) throws Exception;
   public ArrayList selectList() throws Exception;
   public ArrayList onWork(String id, String onTime) throws Exception;
   public ArrayList offWork(String id, String onTime) throws Exception;
   

}