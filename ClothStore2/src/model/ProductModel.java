package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.vo.Product;

public class ProductModel {
   String url;
   String user;
   String pass;

   public ProductModel() throws Exception {
      // 1. 드라이버로딩
      Class.forName("oracle.jdbc.driver.OracleDriver");
      url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
      user = "ryu";
      pass = "1234";

   }
   //제품검색
   public void searchProduct(String pCode) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      try {
         // 2. Connection 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         // 3. sql 문장 만들기(INSERT 문장 만들기)
         String sql = " SELECT FROM WHERE ";
         // 4. sql 전송객체 (PreparedStatement)
         PreparedStatement st = con.prepareStatement(sql);

         st.setString(1, pCode);

         // 5. sql 전송
         ResultSet rs = st.executeQuery();

         while (rs.next()) {// 인덱스오류
            ArrayList a = new ArrayList();
            a.add(rs.getString("id"));
            a.add(rs.getString("title"));
            a.add(rs.getString("name"));
            a.add(rs.getString("PHONE"));
            a.add(rs.getString("return_date"));
            a.add(rs.getString("return_state"));
            data.add(a);
         }

         // 6. 닫기
         st.close();
         rs.close();
      } finally {
         con.close();
      }

   }
   //제품 삽입
   public void insertProduct(Product vo) throws Exception {
      Connection con = null;
      try {
         // 2. Connection 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         // 3. sql 문장 만들기(INSERT 문장 만들기)
         String sql = " INSERT INTO PRODUCT VALUES(?,?,?,?,?,?) ";
         // 4. sql 전송객체 (PreparedStatement)
         PreparedStatement st = con.prepareStatement(sql);

         st.setString(1, vo.getPcode());
         st.setString(2, vo.getPkind());
         st.setString(3, vo.getPname());
         st.setInt(4, vo.getPprice());
         st.setString(5, vo.getPsize());
         st.setInt(6, vo.getPstock());

         // 5. sql 전송
         st.executeUpdate();

         // 6. 닫기
         st.close();
      } finally {
         con.close();
      }

   }
   	//수정
   public void modifyProduct(Product vo) throws Exception {
      Connection con = null;
      try {
         // 2. Connection 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         // 3. sql 문장 만들기(INSERT 문장 만들기)
         String sql = " UPDATE PRODUCT " + 
               " SET " + 
               " PKIND = ? , " + 
               " PNAME = ?, " + 
               " PPRICE = ?, " + 
               " PSIZE = ?, " + 
               " PSTOCK = ? " + 
               " WHERE " + 
               " PCODE = ? ";
         // 4. sql 전송객체 (PreparedStatement)
         PreparedStatement st = con.prepareStatement(sql);

         st.setString(1, vo.getPkind());
         st.setString(2, vo.getPname());
         st.setInt(3, vo.getPprice());
         st.setString(4, vo.getPsize());
         st.setInt(5, vo.getPstock());
         st.setString(6, vo.getPcode());

         // 5. sql 전송
         st.executeUpdate();

         // 6. 닫기
         st.close();
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
   //리스트에서 클릭하면 그 상품정보를 리턴함
   public Product selectByPK(int vnum) throws SQLException {
      Product vo = new Product();
      Connection con = null;
      try {
      con = DriverManager.getConnection(url, user, pass);
      String sql = " SELECT * FROM PRODUCT WHERE PCODE = ? ";
      // 해당 비디오 번호의 비디오 정보를 검색하여 Video 클래스에 각각 멤버변수로 지정
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, vnum);

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
         vo.setPcode(rs.getString("PCODE"));
         vo.setPkind(rs.getString("PKIND"));
         vo.setPname(rs.getString("PNAME"));
         vo.setPprice(rs.getInt("PPRICE"));
         vo.setPsize(rs.getString("PSIZE"));
         vo.setPstock(rs.getInt("PSTOCK"));

      }
      rs.close();
      
      }finally {
      con.close();
      }
      return vo;

   }
   //코드에 맞는 상품정보를 삭제함
   public void deleteProduct(String pCode) throws Exception {
      Connection con = null;
      ArrayList data = new ArrayList();
      try {
         // 2. Connection 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         // 3. sql 문장 만들기(INSERT 문장 만들기)
         String sql = " DELETE FROM PRODUCT WHERE PCODE = ? ";
               
         // 4. sql 전송객체 (PreparedStatement)
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, pCode);

         // 5. sql 전송
         st.executeUpdate();

         

         // 6. 닫기
         st.close();
      
      } finally {
         con.close();
      }

   }
}
