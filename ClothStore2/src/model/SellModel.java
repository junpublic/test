package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import model.vo.Product;

public class SellModel {
   String url;
   String user;
   String pass;

   public SellModel() throws Exception {
      // 1. 드라이버로딩
      Class.forName("oracle.jdbc.driver.OracleDriver");
      url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
      user = "ryu";
      pass = "1234";
   }

   // 이름과 가격 가져옴
   public Product searchProduct(String pCode) throws Exception {
      Connection con = null;
      Product data = new Product();
      try {
         // 2. Connection 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         // 3. sql 문장 만들기(INSERT 문장 만들기)
         String sql = " SELECT PNAME name,PPRICE price " + " FROM PRODUCT " + " WHERE PCODE = ? ";
         // 4. sql 전송객체 (PreparedStatement)
         PreparedStatement st = con.prepareStatement(sql);

         st.setString(1, pCode);

         // 5. sql 전송
         ResultSet rs = st.executeQuery();

         while (rs.next()) {// 인덱스오류

            data.setPname(rs.getString("name"));
            data.setPprice(Integer.parseInt(rs.getString("price")));

         }

         // 6. 닫기
         st.close();
         rs.close();
      } finally {
         con.close();
      }
      return data;

   }
   //장바구니에 담겨있는 상품들을 구매
   public void insertSell(Vector sellPCode, Vector sellPPrice, Vector sellStock,String tell) throws Exception {
      Connection con = null;
      try {
         con = DriverManager.getConnection(url, user, pass);

         //거래번호 시퀀스 번호 가져옴
         String SCODE_sql = " SELECT SEQ_SCODE.nextval SCODE FROM dual "; 
         PreparedStatement ps = con.prepareStatement(SCODE_sql);
         
         ResultSet rs2 = ps.executeQuery();
         
         rs2.next();
         int SCODE=rs2.getInt("SCODE");
         System.out.println(SCODE);
         System.out.println(">>" + sellPCode.size());
         
         rs2.close();
         ps.close();
         
         //장바구니에 담겨있는 내역 데이터베이스에 입력
         String sql = " INSERT INTO sales(SCODE,SSQ,STODAY,SDATE,PCODE,STID,CTEL,SALESPK) "
               + " VALUES (? ,?, ?, SYSTIMESTAMP , ?, ?, ? ,SEQ_SCODE.nextval)";

         for(int i=0;i<sellPCode.size();i++) {
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,SCODE);
            st.setInt(2,Integer.parseInt(String.valueOf(sellStock.get(i))));
            st.setInt(3,Integer.parseInt(String.valueOf(sellPPrice.get(i))));
            st.setString(4,(String) sellPCode.get(i));
            st.setInt(5,10100);
            st.setString(6,tell);
            System.out.println("성공");
            int result =st.executeUpdate();
            System.out.println(result);
            st.close();
         }
         System.out.println("------------------------");
         
         //상품재고에서 구매한만큼 갯수를 뺌
         String sql_Stock_minus = " UPDATE PRODUCT " + 
               " SET pstock =  (SELECT pstock FROM PRODUCT WHERE PCODE = ?)-? " + 
               " WHERE PCODE = ? ";
         PreparedStatement st1 = con.prepareStatement(sql_Stock_minus);
         for(int i=0;i<sellPCode.size();i++) {
            st1.setString(1,(String) sellPCode.get(i));
            st1.setInt(2,Integer.parseInt(String.valueOf(sellStock.get(i))));
            st1.setString(3,(String) sellPCode.get(i));
            st1.executeUpdate();            
         }
         
         st1.close();
      } finally {
         con.close();
      }
   }
   
   //코드를 검색하면 그상품 정보를 리턴함
   public ArrayList selectList(String Code) throws Exception {
      ArrayList data = new ArrayList();
      Connection con = null;

      try {
         con = DriverManager.getConnection(url, user, pass);

         String sql = " SELECT PCODE PCODE,PNAME PNAME,PPRICE PPRICE," + " PKIND PKIND,PSIZE PSIZE, PSTOCK PSTOCK "
               + " FROM PRODUCT " + " WHERE PCODE = ? ";

         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, Code);

         ResultSet rs = st.executeQuery();

         while (rs.next()) {
            ArrayList a = new ArrayList();

            a.add(null);
            a.add(rs.getString("PCODE"));
            a.add(rs.getString("PNAME"));
            a.add(rs.getInt("PPRICE"));
            a.add(rs.getString("PKIND"));
            a.add(rs.getString("PSIZE"));
            a.add(rs.getInt("PSTOCK"));
            data.add(a);
         }

         st.close();
         rs.close();
      } finally {
         con.close();
      }
      return data;
   }

}