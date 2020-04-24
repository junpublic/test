package model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.CustomerDao;
import model.vo.Customer;
import view.CustomerBuyList;

public class CustomerModel implements CustomerDao{
   String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
   String user = "ryu";
   String pass = "1234";
   
   CustomerBuyList cBl;
   
   
   public CustomerModel() throws Exception{
      Class.forName("oracle.jdbc.driver.OracleDriver");
   }
   //회원서치하는 메서드
   @Override
   public ArrayList searchCustomer(String cusTel) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      con = DriverManager.getConnection(url, user, pass);
      String sql = "SELECT CTEL, CNAME, CPOINT FROM CUSTOMER WHERE CTEL = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, cusTel);
      ResultSet rs = st.executeQuery();
      while(rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("CTEL"));
         temp.add(rs.getString("CNAME"));
         temp.add(rs.getString(String.valueOf("CPOINT")));
         data.add(temp);
      }
      st.close();
      rs.close();
      con.close();
      return data;
   }
   @Override
   public Customer selectByPK(String tbCusTel) throws Exception {
      Customer vo = new Customer();
      Connection con = null;
      con = DriverManager.getConnection(url, user, pass);
      String sql = "SELECT * FROM CUSTOMER WHERE CTEL = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, tbCusTel);
      ResultSet rs = st.executeQuery();
      while(rs.next()){
         vo.setCtel(rs.getString("CTEL"));
         vo.setCname(rs.getString("CNAME"));
         vo.setCpoint(rs.getInt("CPOINT"));
      }
      st.close();
      rs.close();
      con.close();
      return vo;
   }
   @Override
   public void RegistCus(Customer vo) throws Exception {
      Connection con = null;
      int result = 0;
      con = DriverManager.getConnection(url, user, pass);
      String sql = " INSERT INTO CUSTOMER(CTEL, CNAME, CPOINT) "
            + " VALUES(?, ?, 0) ";
      
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, vo.getCtel());
      st.setString(2, vo.getCname());
      
      
      result = st.executeUpdate();
      if( result == 0) {
         JOptionPane.showMessageDialog(null, "등록불가");
      }else if( result != 0) {
         JOptionPane.showMessageDialog(null, "등록완료");
      }      
      st.close();
      con.close();
      
   }
   @Override
   public void ModifyCus(Customer vo) throws Exception {
      Connection con = null;
      int result = 0;
      con = DriverManager.getConnection(url, user, pass);
      String sql = "UPDATE CUSTOMER SET CNAME = ?, CPOINT = ? WHERE CTEL = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, vo.getCname());
      st.setInt(2, vo.getCpoint());
      st.setString(3, vo.getCtel());
      
      result = st.executeUpdate();
      if(result ==0 ) {
         JOptionPane.showMessageDialog(null, "회원정보 수정불가.");
      }else if(result != 0) {
         JOptionPane.showMessageDialog(null, "회원정보 수정완료.");
      }
      st.close();
      con.close();      
   }
   @Override
   public void delete(String cusTel) throws Exception {
      Connection con = null;
      int result = 0;
      con = DriverManager.getConnection(url, user, pass);
      String sql = " DELETE FROM CUSTOMER WHERE CTEL = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, cusTel);
      
      result = st.executeUpdate();
      if(result ==0 ) {
         JOptionPane.showMessageDialog(null, "회원정보를 삭제하지 못했습니다.");
      }else if(result != 0) {
         JOptionPane.showMessageDialog(null, "회원정보 삭제완료");
      }
      st.close();
      con.close();
      
   }
   public ArrayList showList(String cusTelNum) {
      
      ArrayList dataAr = new ArrayList();
      Connection con = null;
      try {
         con = DriverManager.getConnection(url, user, pass);
         String sql = " SELECT S.SCODE SCODE, P.PCODE PCODE, P.PNAME PNAME, P.PPRICE PPRICE, P.PSIZE PSIZE, TO_CHAR(S.SDATE, 'YYYY-MM-DD') SDATE, S.SSQ SSQ, S.STODAY STODAY "
               + "FROM SALES S INNER JOIN PRODUCT P "
               + " ON S.PCODE = P.PCODE "
               + " WHERE CTEL = ?";
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, cusTelNum);
         ResultSet rs = st.executeQuery();
         while(rs.next()) {
            ArrayList temp = new ArrayList();
            temp.add(rs.getString("SCODE"));
            temp.add(rs.getString("PCODE"));
            temp.add(rs.getString("PNAME"));
            temp.add(rs.getInt("PPRICE"));
            temp.add(rs.getString("PSIZE"));
            temp.add(rs.getString("SDATE"));
            temp.add(rs.getInt("SSQ"));
            temp.add(rs.getInt("STODAY"));
            dataAr.add(temp);
         }
         st.close();
         rs.close();
         con.close();
      } catch (Exception e) {
         System.out.println("쇼리스트 오류" + e.getMessage());
         e.printStackTrace();
      }
      return dataAr;
   }
   
}