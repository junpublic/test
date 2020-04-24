package view;

import javax.swing.table.AbstractTableModel;

import model.dao.StaffDao;
import model.StaffModel;
import model.vo.Staff;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StaffManageView extends JPanel{

   // member field
   JTextField       tfStaffId, tfStaffPass, tfStaffName, tfStaffTel, tfStaffGrade, tfStaffSal, tfStaffHd;
   JButton         bStaffModify, bStaffDelete, bStaffRegist, bStaffpic;
   
   JTable         tableStaffM;
   
   StaffManageTableModel tbModelStaffM;
   
   //BufferedImage m_numberImage;
   
   //모델 변수 선언
   StaffDao model;
   
   
   
   
   
   // constructor method
   
   public StaffManageView() {
      addLayout();    // 화면설계
      eventProc();
      connectDB();   // DB연결
      selectList();
   }
   
   public void addLayout() {
      
      //멤버변수의 객체 생성
      tfStaffId = new JTextField(10);
      tfStaffPass = new JTextField(10);
      tfStaffName = new JTextField(10);
      tfStaffTel = new JTextField(10);
      tfStaffGrade = new JTextField(10);
      tfStaffSal = new JTextField(10);
      tfStaffHd = new JTextField(10);
      
      
      bStaffModify = new JButton("수정");
      bStaffDelete = new JButton("삭제");
      bStaffRegist = new JButton("등록");
      bStaffpic = new JButton(new ImageIcon("src/view/imgs/images.png"));
   
      tbModelStaffM = new StaffManageTableModel();
      tableStaffM = new JTable(tbModelStaffM);
//*********************************************************
      // 화면 구성
      // 위에 직원관리를 넣기위해 
      // 센터영역
      JPanel p_left = new JPanel();
      p_left.setLayout(new BorderLayout());
      p_left.add(new JScrollPane(tableStaffM), BorderLayout.CENTER);
      
      // 오른쪽영역
      JPanel p_right = new JPanel();
      
      //오른쪽 위 위
      JPanel p_right_up_up = new JPanel();
      p_right_up_up.setLayout(new GridLayout(7,2));
      p_right_up_up.add(new JLabel("사원번호"));
      p_right_up_up.add(tfStaffId);
      p_right_up_up.add(new JLabel("비밀번호"));
      p_right_up_up.add(tfStaffPass);
      p_right_up_up.add(new JLabel("이름"));
      p_right_up_up.add(tfStaffName);
      p_right_up_up.add(new JLabel("전화번호"));
      p_right_up_up.add(tfStaffTel);
      p_right_up_up.add(new JLabel("등급"));
      p_right_up_up.add(tfStaffGrade);
      p_right_up_up.add(new JLabel("월급"));
      p_right_up_up.add(tfStaffSal);
      p_right_up_up.add(new JLabel("입사일"));
      p_right_up_up.add(tfStaffHd);
      
      // 오른쪽 위 아래
      JPanel p_right_up_down = new JPanel();
      p_right_up_down.setLayout(new GridLayout());
      p_right_up_down.add(bStaffpic);
      
      // 오른쪽 위
      JPanel p_right_up = new JPanel();
      p_right_up.setLayout( new GridLayout(2,1));
      p_right_up.add(p_right_up_up);
      p_right_up.add(p_right_up_down);
      
      //오른쪽 아래
      JPanel p_right_down = new JPanel();
      p_right_down.setLayout(new GridLayout(1,3));
      p_right_down.add(bStaffRegist);
      p_right_down.add(bStaffModify);
      p_right_down.add(bStaffDelete);
      
      p_right.setLayout(new BorderLayout());
      p_right.add(p_right_up, BorderLayout.CENTER);
      p_right.add(p_right_down, BorderLayout.SOUTH);
      
      
      
      //영역을 2개로 나눔      
      setLayout(new BorderLayout());
            add(new JLabel("직원관리"), BorderLayout.NORTH);
            add(p_left, BorderLayout.CENTER);
            add(p_right, BorderLayout.EAST);
   }
   
   
   class StaffManageTableModel extends AbstractTableModel{
      ArrayList dataM = new ArrayList();
      String [] columnNamesM = {"사원번호", "비밀번호",  "이름", "전화번호", "등급", "월급", "입사일"};

      @Override
      public int getColumnCount() {
         return columnNamesM.length; 
      }

      @Override
      public int getRowCount() {
         
         return dataM.size();
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         ArrayList temp = (ArrayList)dataM.get( rowIndex );
           return temp.get( columnIndex ); 
      }
      
       public String getColumnName(int col){
             return columnNamesM[col];
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
      bStaffRegist.addActionListener(handler);
      bStaffModify.addActionListener(handler);
      bStaffDelete.addActionListener(handler);
      //마우스 클릭시
      tableStaffM.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int row = tableStaffM.getSelectedRow();
            String sid = (String)tableStaffM.getValueAt(row, 0);//0은 pk(시퀀스)인 NUM
         
               Staff vo;
               try {
                  vo = model.selectByPK(sid);
                  tfStaffId.setText(vo.getStid());
                  tfStaffPass.setText(vo.getStpass());
                  tfStaffName.setText(vo.getStname());
                  tfStaffTel.setText(String.valueOf(vo.getSttel()));
                  tfStaffGrade.setText(vo.getStgrade());
                  tfStaffSal.setText(String.valueOf(vo.getStsal()));
                  tfStaffHd.setText(vo.getSthire());
                  bStaffpic.setIcon(new ImageIcon("src/view/imgs/" + vo.getStid() + ".jpg"));
                  
                     
            
                  
                  
               } catch (Exception e1) {
                  System.out.println("스테프모델 접속 불가능" + e1.getMessage());
                  e1.printStackTrace();
               }
            
         }

      });
   }
      
   
   class ButtonEventHandler implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent ev) {
         Object o = ev.getSource();
         if(o==tfStaffId) {
            searchStaffId();
         }
         else if(o==bStaffRegist) {
            Regist();
            selectList();
         }
         
         else if(o==bStaffModify) {
            Modify();
            selectList();
         }
         else if(o==bStaffDelete) {
            Delete();
            selectList();
         }
      }
   }
         
      //스테프 
   public void searchStaffId() {
         String id = tfStaffId.getText();

         try {
            ArrayList data = model.searchStaffId(id);
            //table 업데이트
            tbModelStaffM.dataM = data;
            tableStaffM.setModel(tbModelStaffM);
            tbModelStaffM.fireTableDataChanged();
            
         } catch (Exception e) {
            System.out.println("스테프 매니저 연결 실패" + e.getMessage());
            e.printStackTrace();
         }
         // tf초기화
         tfStaffId.setText("");
         
         
      }
      
      public void Regist() {
         //String id = tfStaffId.getText();
         String name = tfStaffName.getText();
         String pass = tfStaffPass.getText();
         String tel = tfStaffTel.getText();
         String grade = (tfStaffGrade.getText());
         String sal = tfStaffSal.getText();
         String hire = tfStaffHd.getText();
         
         Staff vo = new Staff();
         //vo.setStid(id);
         vo.setStpass(pass);
         vo.setStname(name);
         vo.setSttel(tel);
         vo.setStgrade(grade);
         vo.setStsal(Integer.parseInt(tfStaffSal.getText()));
         vo.setSthire(tfStaffHd.getText());
         
         try {
            model.Regist(vo);
            
         } catch (Exception e) {
            System.out.println("regist 연결 안됨 " + e.getMessage());
            e.printStackTrace();
         }
         tfStaffId.setText("");
         tfStaffPass.setText("");
         tfStaffName.setText("");
         tfStaffTel.setText("");
         tfStaffGrade.setText("");
         tfStaffSal.setText("");
         tfStaffHd.setText("");
         
      }
      public void Modify() {
         String id = tfStaffId.getText();
         String pass = tfStaffPass.getText();
         String name = tfStaffName.getText();
         String tel = tfStaffTel.getText();
         String grade = tfStaffGrade.getText();
         int sal = Integer.parseInt(tfStaffSal.getText());
         String hire = tfStaffHd.getText();
         
         Staff vo = new Staff();
         vo.setStid(id);
         vo.setStpass(pass);   
         vo.setStname(name);
         vo.setSttel(tel);
         vo.setStgrade(grade);
         vo.setStsal(sal);
         vo.setSthire(hire);
         //vo.setSthire(tfStaffHd.getText());
         
         try {
            int result = model.Modify(vo);
            if( result == 0) {
               JOptionPane.showMessageDialog(null, "수정불가");
            }else if( result != 0) {
               JOptionPane.showMessageDialog(null, result + " 명 수정완료");
            }
         } catch (Exception e) {
            System.out.println("수정버튼 연결 실패" + e.getMessage());
            e.printStackTrace();
         }
         //초기화
         tfStaffId.setText(""); 
         tfStaffPass.setText("");
         tfStaffName.setText("");
         tfStaffTel.setText("");
         tfStaffGrade.setText("");
         tfStaffSal.setText("");
         tfStaffHd.setText("");
      }
      
      public void Delete() {
         String id = tfStaffId.getText();
         
            try {
               model.DeleteId(id);
            } catch (Exception e) {
               System.out.println("딜리트 접속 실패 " + e.getMessage());
               e.printStackTrace();
            }
            tfStaffId.setText(""); 
            tfStaffPass.setText("");
            tfStaffName.setText("");
            tfStaffTel.setText("");
            tfStaffGrade.setText("");
            tfStaffSal.setText("");
            tfStaffHd.setText("");
      }
      
      public void selectList() {
         
            try {
               ArrayList data = model.selectList();
               tbModelStaffM.dataM = data;
               tableStaffM.setModel(tbModelStaffM);
               tbModelStaffM.fireTableDataChanged();
            } catch (Exception e) {
               System.out.println("셀렉리스트 열결 실패" + e.getMessage());
               e.printStackTrace();
            }
         
      }
      
      
}