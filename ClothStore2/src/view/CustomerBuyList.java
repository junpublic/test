package view;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import view.StaffManageView.StaffManageTableModel;

public class CustomerBuyList extends JFrame {
   
   JTable tableBL;
   tableBuyList tbModelBuyList;
   
   
   public CustomerBuyList(){
      //화면 안보이게 세팅
      setTitle("구매내역");
      setSize(700,500);
      setVisible(false);
      setLocation(700,250);
      addLayout();
      
      
   }
   public void addLayout(){
      
      tbModelBuyList = new tableBuyList();
      tableBL = new JTable(tbModelBuyList);
      
      setLayout(new BorderLayout());
         add(new JScrollPane(tableBL), BorderLayout.CENTER);
   }
   
//   public void showList(String cusTelNum) {
//      setVisible(true);
//      ArrayList dataAr = new ArrayList();
//      Connection con = null;
//      try {
//         con = DriverManager.getConnection(url, user, pass);
//         String sql = " SELECT S.SCODE SCODE, P.PCODE PCODE, P.PNAME PNAME, P.PPRICE PPRICE, P.PSIZE PSIZE, TO_CHAR(S.SDATE, 'YYYY-MM-DD') SDATE, S.SSQ SSQ, S.STODAY STODAY "
//               + "FROM SALES S INNER JOIN PRODUCT P "
//               + " ON S.PCODE = P.PCODE "
//               + " WHERE CTEL = ?";
//         PreparedStatement st = con.prepareStatement(sql);
//         st.setString(1, cusTelNum);
//         ResultSet rs = st.executeQuery();
//         while(rs.next()) {
//            ArrayList temp = new ArrayList();
//            temp.add(rs.getString("SCODE"));
//            temp.add(rs.getString("PCODE"));
//            temp.add(rs.getString("PNAME"));
//            temp.add(rs.getInt("PPRICE"));
//            temp.add(rs.getString("PSIZE"));
//            temp.add(rs.getString("SDATE"));
//            temp.add(rs.getInt("SSQ"));
//            temp.add(rs.getInt("STODAY"));
//            dataAr.add(temp);
//         }
//         st.close();
//         rs.close();
//         con.close();
//      } catch (Exception e) {
//         System.out.println("쇼리스트 오류" + e.getMessage());
//         e.printStackTrace();
//      }
//}
      
      public void putBlTable(ArrayList dataAr) {
      tbModelBuyList.dataBl=dataAr;
      tableBL.setModel(tbModelBuyList);
      tbModelBuyList.fireTableDataChanged();
      }
   

   class tableBuyList extends AbstractTableModel{
      ArrayList dataBl = new ArrayList();
      String [] columnNames = {"거래번호", "상품코드",  "상품명", "상품가격", "사이즈", "거래날짜", "구매개수", "결제금액"};
      @Override
      public int getColumnCount() {
         return columnNames.length; 
      }

      @Override
      public int getRowCount() {
         return dataBl.size();
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         ArrayList temp = (ArrayList)dataBl.get( rowIndex );
           return temp.get( columnIndex ); 
      }
      
       public String getColumnName(int col){
             return columnNames[col];
          }
      
   }
   
}