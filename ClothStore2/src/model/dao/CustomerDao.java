package model.dao;

import java.util.ArrayList;

import model.vo.Customer;

public interface CustomerDao {

   ArrayList searchCustomer(String cusTel) throws Exception;

   Customer selectByPK(String tbCusTel) throws   Exception;

   void RegistCus(Customer vo) throws Exception;

   void ModifyCus(Customer vo) throws Exception;

   void delete(String cusName) throws Exception;
   
   public ArrayList showList(String cusTelNum) throws Exception;
   
   
   
}