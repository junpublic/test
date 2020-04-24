package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

import model.dao.CustomerDao;
import model.CustomerModel;
import model.vo.Customer;
import view.StaffManageView.ButtonEventHandler;

public class CustomerView extends JFrame{
   JTextField    tfCusTel, tfCusName, tfCusPoint;

   JButton      bBuyList, bCusSearch, bCusNew, bCusModify, bCusDelete;

   JTable      tableCustomer;

   CustomerTableModel tbModelCustomer;

   CustomerDao   model;
   CustomerBuyList cb;
   

   public CustomerView() {
      //BuyList 객체 생성
      cb= new CustomerBuyList();
      
      addLayout();    // 화면설계
      eventProc();
      connectDB();   // DB연결
   }

   public void addLayout() {
      //객체 생성
      tfCusTel = new JTextField(15);
      tfCusName = new JTextField(15);
      tfCusPoint = new JTextField(15);

      bBuyList = new JButton("구매내역 조회");
      bCusSearch = new JButton("회원 조회");
      bCusNew = new JButton("신규");
      bCusModify = new JButton("수정");
      bCusDelete = new JButton("삭제");
      
      tbModelCustomer = new CustomerTableModel();
      tableCustomer = new JTable(tbModelCustomer);
      //화면 설계
      //CENTER
      JPanel p_center = new JPanel();
      p_center.setLayout(new BorderLayout());
      p_center.add(new JScrollPane(tableCustomer));

      //east center
      JPanel p_east_center = new JPanel();
      p_east_center.setLayout(new GridLayout(3, 2));
      p_east_center.add(new JLabel("전화번호"));
      p_east_center.add(tfCusTel);
      p_east_center.add(new JLabel("이름"));
      p_east_center.add(tfCusName);
      p_east_center.add(new JLabel("적립금"));
      p_east_center.add(tfCusPoint);

      //east bottom center
      JPanel p_east_bot_up = new JPanel();
      p_east_bot_up.setLayout(new GridLayout(4, 1));
      p_east_bot_up.add(bBuyList);
      p_east_bot_up.add(new JLabel(""));
      p_east_bot_up.add(bCusSearch);
      p_east_bot_up.add(new JLabel(""));

      //east bottom south
      JPanel p_east_bot_south = new JPanel();
      p_east_bot_south.setLayout(new GridLayout(1, 3));
      p_east_bot_south.add(bCusNew);
      p_east_bot_south.add(bCusModify);
      p_east_bot_south.add(bCusDelete);

      //east bottom
      JPanel p_east_bot = new JPanel();
      p_east_bot.setLayout(new BorderLayout());
      p_east_bot.add(p_east_bot_up, BorderLayout.NORTH);
      p_east_bot.add(p_east_bot_south, BorderLayout.SOUTH);


      //EAST
      JPanel p_east = new JPanel();
      p_east.setLayout(new BorderLayout());
      p_east.add(p_east_center, BorderLayout.NORTH);
      p_east.add(p_east_bot, BorderLayout.SOUTH);


      setLayout(new BorderLayout());
      add(new JLabel("회원관리"), BorderLayout.NORTH);
      add(new JScrollPane(tableCustomer), BorderLayout.CENTER);
      add(p_east, BorderLayout.EAST);
      
      setSize(1000,800);


   }

   public void connectDB() {
      try {
         model = new CustomerModel();
      } catch (Exception e) {
         System.out.println("DB연동 완료");
         e.printStackTrace();
      }

   }



   public void eventProc() {
      ButtonEventHandler handler = new ButtonEventHandler();
      tfCusTel.addActionListener(handler);
      bBuyList.addActionListener(handler);
      bCusSearch.addActionListener(handler);
      bCusNew.addActionListener(handler);
      bCusModify.addActionListener(handler);
      bCusDelete.addActionListener(handler);
      tableCustomer.addMouseListener( new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int row = tableCustomer.getSelectedRow();
            String tbCusTel = (String) tableCustomer.getValueAt(row, 0);
            try {
               Customer vo = model.selectByPK(tbCusTel);
               tfCusName.setText(vo.getCname());
               tfCusTel.setText(vo.getCtel());
               tfCusPoint.setText(String.valueOf(vo.getCpoint()));
            } catch (Exception e1) {
               System.out.println("셀렉 pk키 검색 연결 실패" + e1.getMessage());
               e1.printStackTrace();
            }

         }
      });
   }


   class ButtonEventHandler implements ActionListener{

      
      @Override
      public void actionPerformed(ActionEvent e) {
         Object evt = e.getSource();
         if(evt==tfCusTel) {
            searchCusTel();
         }
         else if(evt==bCusSearch) {
            searchCusTel();
         }
         else if(evt==bBuyList) {
            showUpList();

         }
         else if(evt==bCusNew) {
            newCustomer();
         }
         else if(evt==bCusModify) {
            modifyCustomer();
         }
         else if(evt==bCusDelete) {
            deleteCustomer();
         }

      }

   }
   
   public void deleteCustomer() {
      String cusTel = tfCusTel.getText();
      try {
         model.delete(cusTel);
      } catch (Exception e) {
         System.out.println("회원딜리트 연결 실패" + e.getMessage());
         e.printStackTrace();
      }
      tfCusName.setText("");
      tfCusTel.setText("");
      tfCusPoint.setText("");
   }
   
   public void modifyCustomer() {
      String cusName = tfCusName.getText();
      String cusTel = tfCusTel.getText();
      String cusPoint = tfCusPoint.getText();
      
      Customer vo = new Customer();
      vo.setCname(cusName);
      vo.setCtel(cusTel);
      vo.setCpoint(Integer.parseInt(cusPoint));
      
      try {
         model.ModifyCus(vo);
      } catch (Exception e) {
         System.out.println("모디파이커스터머" + e.getMessage());
         e.printStackTrace();
      }
      tfCusName.setText("");
      tfCusTel.setText("");
      tfCusPoint.setText("");
      
      
   }

   public void newCustomer() {
      String cusName = tfCusName.getText();
      String cusTel = tfCusTel.getText();
      //String cusPoint = tfCusPoint.getText();
      
      Customer vo = new Customer();
      vo.setCname(cusName);
      vo.setCtel(cusTel);
      //vo.setCpoint(Integer.parseInt(cusPoint));
      
      try {
         model.RegistCus(vo);
      } catch (Exception e) {
         System.out.println("신규회원 리지스트 연결 실패" + e.getMessage());
         e.printStackTrace();
      }
      tfCusName.setText("");
      tfCusTel.setText("");
      tfCusPoint.setText("");
   
      
   }

   public void showUpList() {
      String cusTelNum = tfCusTel.getText();
      try {
         ArrayList dataAr = model.showList(cusTelNum);
         cb.putBlTable(dataAr);
         cb.setVisible(true);
      } catch (Exception e) {
         System.out.println("쇼업리스트 연결 실패" + e.getMessage());
         e.printStackTrace();
      }
   
      
   }
   public void searchCusTel(){
      String cusTel = tfCusTel.getText();
      try {
         ArrayList data = model.searchCustomer(cusTel);
         tbModelCustomer.dataCus = data;
         tableCustomer.setModel(tbModelCustomer);
         tbModelCustomer.fireTableDataChanged();

      } catch (Exception e) {
         System.out.println("회원서치 연결실패" + e.getMessage());
         e.printStackTrace();
      }
   }

   //테이블 데이터
   class CustomerTableModel extends AbstractTableModel{
      ArrayList dataCus = new ArrayList();
      String [] columnNamesCus = {"전화번호", "이름", "적립금"};

      @Override
      public int getColumnCount() {
         return columnNamesCus.length;
      }

      @Override
      public int getRowCount() {
         return dataCus.size();
      }

      @Override
      public Object getValueAt(int rowCus, int colCus) {
         ArrayList temp = (ArrayList)dataCus.get(rowCus);
         return temp.get(colCus);
      }

      public String getColumnName(int col){
         return columnNamesCus[col];
      }

   }

}