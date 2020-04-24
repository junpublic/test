package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.StaffDao;
import model.vo.Staff;


public class StaffModel implements StaffDao {
   String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
   String user = "ryu";
   String pass = "1234";
   
   public StaffModel() throws Exception{
      Class.forName("oracle.jdbc.driver.OracleDriver");
   }



   @Override
   public void Regist(Staff vo) throws Exception {
      Connection con = null;
      int result = 0; 
      con = DriverManager.getConnection(url, user, pass);
      
      String sql = " INSERT INTO STAFF(STID, STPASS, STNAME, STHIRE, STTEL, STSAL, STGRADE) "
            + " VALUES(SEQ_STAFF_ID.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?) ";
      
      PreparedStatement st1 = con.prepareStatement(sql);
      st1.setString(1, vo.getStpass());
      st1.setString(2, vo.getStname());
      st1.setString(3, vo.getSthire());
      st1.setString(4, vo.getSttel());
      st1.setInt(5, vo.getStsal());
      st1.setString(6, vo.getStgrade());
      
      result = st1.executeUpdate();
      if( result == 0) {
         JOptionPane.showMessageDialog(null, "등록불가");
      }else if( result != 0) {
         JOptionPane.showMessageDialog(null, result + " 명 등록완료");
      }      
      
      st1.close();
      con.close();
      }
      
   
   
   @Override
   public ArrayList searchStaffId(String id) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      con = DriverManager.getConnection(url, user, pass);
      
      String sql = " SELECT STID, STPASS, STNAME, STTEL, STGRADE, STSAL, TO_CHAR(STHIRE, 'YYYY/MM/DD') STHIRE FROM STAFF WHERE STID = ? ";
      
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, id);
      
      ResultSet rs = st.executeQuery();
            
      while(rs.next()) {   
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("STID"));
         temp.add(rs.getString("STPASS"));
         temp.add(rs.getString("STNAME"));
         temp.add(rs.getString("STTEL"));
         temp.add(rs.getString("STGRADE"));
         temp.add(rs.getInt("STSAL"));
         temp.add(rs.getString("STHIRE"));
         data.add(temp);
      }
      st.close();
      rs.close();
      con.close();
      return data;
   }

   @Override
   public int Modify(Staff vo) throws Exception {
      Connection con = null;
      int result = 0;
      try {
      con = DriverManager.getConnection(url, user, pass);
      
      String sql = " UPDATE staff "
            + " SET STNAME = ?, STPASS = ?,  STHIRE = ?, STTEL = ?, STSAL = ?, STGRADE = ? "
            + " WHERE STID = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, vo.getStname());
      st.setString(2, vo.getStpass());
      st.setString(3, vo.getSthire());
      st.setString(4, vo.getSttel());
      st.setInt(5, vo.getStsal());
      st.setString(6, vo.getStgrade());
      st.setString(7, vo.getStid());
      result = st.executeUpdate();
      
      st.close();
      }finally{
      con.close();}
      return result;
      
   }

   @Override
   public Staff selectByPK(String sid) throws Exception {
      Staff vo = new Staff();
      Connection con = null;
      con = DriverManager.getConnection(url, user, pass);
      String sql = " SELECT STID, STPASS, STNAME, STTEL, STGRADE, STSAL, TO_CHAR(STHIRE, 'YYYY/MM/DD') STHIRE  FROM STAFF WHERE STID = ? ";
      // 해당 비디오 번호의 비디오 정보를 검색하여 Video 클래스에 각각 멤버변수로 지정
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, sid);

      ResultSet rs = st.executeQuery();

      while(rs.next()) {
         vo.setStid(rs.getString("STID"));
         vo.setStpass(rs.getString("STPASS"));
         vo.setStname(rs.getString("STNAME"));
         vo.setSttel(rs.getString("STTEL"));
         vo.setStgrade(rs.getString("STGRADE"));
         vo.setStsal(rs.getInt("STSAL"));
         vo.setSthire(rs.getString("STHIRE"));
         
      }
      st.close();
      rs.close();
      con.close();
      return vo;
   
   }

   public void DeleteId(String id) throws Exception {
      Connection con = null;
      int result = 0;
      con = DriverManager.getConnection(url, user, pass);
      String sql = " DELETE FROM STAFF WHERE STID = ? ";
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, id);
      
      result = st.executeUpdate();
      if(result ==0 ) {
         JOptionPane.showMessageDialog(null, "사원정보를 삭제하지 못했습니다.");
      }else if(result != 0) {
         JOptionPane.showMessageDialog(null, "사원정보" + result + "명 삭제완료");
      }
      st.close();
      con.close();
      
   }

   @Override
   public ArrayList selectList() throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      con = DriverManager.getConnection(url, user, pass);
      String sql = "SELECT STID, STPASS, STNAME, STTEL, STGRADE, STSAL, TO_CHAR(STHIRE, 'YYYY/MM/DD') STHIRE FROM STAFF WHERE STID IS NOT NULL ";
      PreparedStatement st = con.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      while(rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("STID"));
         temp.add(rs.getString("STPASS"));
         temp.add(rs.getString("STNAME"));
         temp.add(rs.getString("STTEL"));
         temp.add(rs.getString("STGRADE"));
         temp.add(rs.getInt("STSAL"));
         temp.add(rs.getString("STHIRE"));
         data.add(temp);
         
      }
      st.close();
      rs.close();
      con.close();
      
      return data;
   }

   @Override
   public ArrayList onWork(String id, String onTime) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      con = DriverManager.getConnection(url, user, pass);      
      
      String putTime = " UPDATE ST_WORKTIME "
            + " SET ONTIME = TO_DATE(?, 'YYYY-MM-DD-HH24:MI') "
            + " WHERE STID = ? ";
      PreparedStatement st1 = con.prepareStatement(putTime);
      st1.setString(1, onTime);
      st1.setString(2, id);
      st1.executeUpdate();
      
      String putTodayTime = " UPDATE STAFF "
            + " SET STONW = TO_DATE(?, 'YYYY-MM-DD-HH24:MI') "
            + " WHERE STID = ? ";
      PreparedStatement st2 = con.prepareStatement(putTodayTime);
      st2.setString(1, onTime);
      st2.setString(2, id);
      st2.executeUpdate();
      
      String nameSql = " SELECT s.stname STNAME, TO_CHAR(w.ONTIME, 'YYYY-MM-DD-HH24:MI') ONTIME, TO_CHAR(w.OFFTIME, 'YYYY-MM-DD-HH24:MI')  OFFTIME"
            + " FROM STAFF s, st_worktime w "
            + " WHERE s.STID = w.STID AND w.STID = ? ";
      PreparedStatement st = con.prepareStatement(nameSql);
      st.setString(1, id);
      ResultSet rs = st.executeQuery();
      
      while(rs.next()) {   
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("STNAME"));
         temp.add(rs.getString("ONTIME"));
         temp.add(rs.getString("OFFTIME"));
         
         data.add(temp);
      }
      st1.close();
      st2.close();
      st.close();
      con.close();
      return data;
   }
   
   @Override
   public ArrayList selectStaff(String id, String onTime) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      con = DriverManager.getConnection(url, user, pass);
      
      
//      String putTime = " INSERT INTO ST_WORKTIME(STID, ONTIME) "
//            + "VALUES (?, TO_DATE(?, 'YYYY-MM-DD-HH24:MI')) ";
      String putTime = " INSERT INTO ST_WORKTIME(STID) "
            + "VALUES (?) ";
      PreparedStatement st1 = con.prepareStatement(putTime);
      st1.setString(1, id);
//      st1.setString(2, onTime);
      st1.executeUpdate();
      
      
      String nameSql = " SELECT s.stname STNAME, TO_CHAR(w.ONTIME, 'YYYY-MM-DD-HH24:MI') ONTIME, TO_CHAR(w.OFFTIME, 'YYYY-MM-DD-HH24:MI')  OFFTIME"
            + " FROM STAFF s, st_worktime w "
            + " WHERE s.STID = w.STID AND w.STID = ? ";
      PreparedStatement st3 = con.prepareStatement(nameSql);
      st3.setString(1, id);
      ResultSet rs = st3.executeQuery();
      while(rs.next()) {   
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("STNAME"));
         temp.add(rs.getString("ONTIME"));
         temp.add(rs.getString("OFFTIME"));
         
         data.add(temp);
      }
      st1.close();
      st3.close();
      con.close();
      return data;
   }



   @Override
   public ArrayList offWork(String id, String onTime) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      
      con = DriverManager.getConnection(url, user, pass);      
      
      String deleteNull = " DELETE ST_WORKTIME "
            + " WHERE ONTIME IS NULL ";
      Statement st3 = con.createStatement();
      st3.executeUpdate(deleteNull);
      
      
      String putTodayTime = " UPDATE STAFF "
            + " SET STOFFW = TO_DATE(?, 'YYYY-MM-DD-HH24:MI') "
            + " WHERE STID = ? ";
      PreparedStatement st2 = con.prepareStatement(putTodayTime);
      st2.setString(1, onTime);
      st2.setString(2, id);
      st2.executeUpdate();
      
      String putTime = " UPDATE ST_WORKTIME w "
            + " SET w.OFFTIME = TO_DATE(?, 'YYYY-MM-DD-HH24:MI') "
            + " WHERE STID = ? AND w.ONTIME = (SELECT STONW FROM STAFF WHERE STID = ?) ";
      PreparedStatement st1 = con.prepareStatement(putTime);
      st1.setString(1, onTime);
      st1.setString(2, id);
      st1.setString(3, id);
      st1.executeUpdate();
      
      
      String nameSql = " SELECT s.stname STNAME, TO_CHAR(w.ONTIME, 'YYYY-MM-DD-HH24:MI') ONTIME, TO_CHAR(w.OFFTIME, 'YYYY-MM-DD-HH24:MI')  OFFTIME"
            + " FROM STAFF s, st_worktime w "
            + " WHERE s.STID = w.STID AND w.STID = ? ";
      PreparedStatement st = con.prepareStatement(nameSql);
      st.setString(1, id);
      ResultSet rs = st.executeQuery();
      
      while(rs.next()) {   
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("STNAME"));
         temp.add(rs.getString("ONTIME"));
         temp.add(rs.getString("OFFTIME"));
         
         data.add(temp);
      }
      st1.close();
      st2.close();
      st3.close();
      st.close();
      con.close();
      return data;
   }
   
}