package view;

import javax.swing.table.AbstractTableModel;

import model.dao.StaffDao;
import model.StaffModel;
import java.awt.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;

public class Worktimeview extends JPanel{

   // member field
   JTextField       tfStaffId, tfStaffOnTime, tfStaffOffTime;
   JButton         bStaffOn, bStaffOff;
   JTable         tableStaff;
   
   StaffTableModel tbModelStaff;
   
   //출퇴근 시간
   SimpleDateFormat format2;
   Calendar time;
   //모델 변수 선언
   StaffDao model;

   

   // constructor method
   
   public Worktimeview() {
      format2 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
      time = Calendar.getInstance();

      addLayout();    // 화면설계

      eventProc();
      connectDB();   // DB연결
  
      
   }
   
   public void addLayout() {
      
      
      //멤버변수의 객체 생성
      tfStaffId = new JTextField(15);
      tfStaffOnTime = new JTextField(15);
      tfStaffOffTime = new JTextField(15);
   
      
      bStaffOn = new JButton("출근");
      bStaffOff = new JButton("퇴근");
      
      tbModelStaff = new StaffTableModel();
      tableStaff = new JTable(tbModelStaff);
//*********************************************************
      // 화면 구성
      // 위에 직원관리를 넣기위해 
      // 센터영역
      JPanel p_left = new JPanel();
      p_left.setLayout(new BorderLayout());
      p_left.add(new JScrollPane(tableStaff), BorderLayout.CENTER);
      
      // 오른쪽영역
      JPanel p_right = new JPanel();
      
      // 오른쪽 위 
      JPanel p_right_up = new JPanel();
      p_right_up.setLayout(new GridLayout(2,2));
      p_right_up.add(new JLabel("아이디"));
      p_right_up.add(tfStaffId);
      p_right_up.add(new JLabel("현재시간"));
      p_right_up.add(tfStaffOnTime);
//      p_right_up.add(new JLabel("퇴근시간"));
//      p_right_up.add(tfStaffOffTime);
      
      //오른쪽 아래
      JPanel p_right_down = new JPanel();
      p_right_down.setLayout(new GridLayout(1,2));
      p_right_down.add(bStaffOn);
      p_right_down.add(bStaffOff);
      
      p_right.setLayout(new BorderLayout());
      p_right.add(p_right_up, BorderLayout.NORTH);
      p_right.add(p_right_down, BorderLayout.SOUTH);
      
      
      
      //영역을 2개로 나눔      
      setLayout(new BorderLayout());
            add(new JLabel("출근관리"), BorderLayout.NORTH);
            add(p_left, BorderLayout.CENTER);
            add(p_right, BorderLayout.EAST);
            
      setSize(1000,800);
      
   }
   
   class StaffTableModel extends AbstractTableModel{
      
      ArrayList data = new ArrayList();
      String [] columnNames = {"이름", "출근", "퇴근"};
      
      @Override
      public int getColumnCount() {
         
         return columnNames.length;
      }

      @Override
      public int getRowCount() {
         
         return data.size();
      }

      @Override
      public Object getValueAt(int row, int col) {
         ArrayList temp = (ArrayList)data.get( row );
           return temp.get( col ); 
      }
      
       public String getColumnName(int col){
             return columnNames[col];
          }
      
   }
   
   
   
   public void connectDB() {   // DB연결
      try {
         model = new StaffModel();
         System.out.println("DB연결 성공");
      } catch (Exception e) {
         System.out.println("DB연결 실패" + e.getMessage());
         e.printStackTrace();
      }
      
      
   }
   
   public void eventProc() {
      ButtonEventHandler handler = new ButtonEventHandler();
      tfStaffId.addActionListener(handler);
      bStaffOn.addActionListener(handler);
      bStaffOff.addActionListener(handler);
   }
   
   class ButtonEventHandler implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent ev) {
         Object o = ev.getSource();
         if(o==tfStaffId) {
            searchStaff();
         }
         else if(o==bStaffOn) {
            putOnTime();
         }
         else if(o==bStaffOff) {
            putOffTime();
         }
      }
   }
         
      //스테프 
   public void searchStaff() {
         String id = tfStaffId.getText();
         String onTime = tfStaffOnTime.getText();
         String time1 = null;
         //출근시간 찍힘
         time1 = format2.format(time.getTime());
         tfStaffOnTime.setText(time1);
         onTime = tfStaffOnTime.getText();
         //System.out.println(time1);      
         try {
            ArrayList data = model.selectStaff(id, onTime);
            tbModelStaff.data = data;
            tableStaff.setModel(tbModelStaff);
            tbModelStaff.fireTableDataChanged();
            //table 업데이트
         } catch (Exception e) {
            System.out.println("스테프 연결 실패" + e.getMessage());
            e.printStackTrace();
         }
         // tf초기화
         
         
      }
   public void putOnTime() {
      String id = tfStaffId.getText();
      String onTime = tfStaffOnTime.getText()
            ;
         try {
            ArrayList data = model.onWork(id, onTime);
            tbModelStaff.data = data;
            tableStaff.setModel(tbModelStaff);
            tbModelStaff.fireTableDataChanged();
         } catch (Exception e) {
            System.out.println("출근 버튼 연결 실패" + e.getMessage());
            e.printStackTrace();
         }
      }
      
   public void putOffTime() {
      String id = tfStaffId.getText();
      String onTime = tfStaffOnTime.getText();
      try {
         ArrayList data = model.offWork(id, onTime);
         tbModelStaff.data = data;
         tableStaff.setModel(tbModelStaff);
         tbModelStaff.fireTableDataChanged();
      } catch (Exception e) {
         System.out.println("퇴근버튼연결 실패" + e.getMessage());
         e.printStackTrace();
      }
         
      }
      
}