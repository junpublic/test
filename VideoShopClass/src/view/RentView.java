package  view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.RentModel;
import model.dao.VideoModel;
import model.vo.Customer;



public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;
	
	JTextField tfReturnVideoNum;
	JButton bReturn;
	
	JTable tableRecentList;
	
	RentTableModel rentTM;
	
	//모델단 변수 선언
	RentModel model;
	

	
	//==============================================
	//	 생성자 함수
	public RentView(){
		addLayout();	//화면구성
		eventProc();	
		connectDB();	//DB연결
		selectList();
	}
	void selectList() {
		try {
			ArrayList data = model.selectList();
			rentTM.data = data;
			tableRecentList.setModel(rentTM);
			rentTM.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("미납목록검색실패:"+e.getMessage());
		}
	}
	
	// DB 연결
	void connectDB(){
		try {
			 model = new RentModel();
		} catch (Exception e) {
			System.out.println("대여관리-오라클드라이버 로딩 실패 : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	// 이벤트 등록
	public void eventProc(){
		BtnHandler handler = new BtnHandler();
		tfRentTel.addActionListener(handler);//엔터쳤을떄
		bRent.addActionListener(handler);
		bReturn.addActionListener(handler);
	}
	
	//이벤트 핸들러
	class BtnHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if( o == tfRentTel) {//엔터 버튼클릭등등의 핵션들은 다 기본세팅임
				selectByTel();
			}else if( o == bRent){
				rentVdieo();
				selectList();
			}else if( o == bReturn) {
				retrunVdieo();
				selectList();
			}
		}

		
	}
	void selectByTel() {
		String tel = tfRentTel.getText();
		String dao = null;
		try {
			dao = model.selectByTel(tel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfRentCustName.setText(dao);
		
	}
	void rentVdieo() {
		String tel = tfRentTel.getText();
		String vnum = tfRentVideoNum.getText();
		
		try {
			model.rentVdieo(tel,Integer.parseInt(vnum));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//화면초기화
		tfRentCustName.setText("");
		tfRentTel.setText("");
		tfRentVideoNum.setText("");
	}
	void retrunVdieo() {
		String tel = tfRentTel.getText();
		int vnum =  Integer.parseInt(tfRentVideoNum.getText());
		
		try {
			model.rentVdieo(tel, vnum);
		} catch (Exception e) {
			System.out.println("대여실패:"+e.getMessage());
			e.printStackTrace();
		}
		//화면초기화
		tfRentCustName.setText("");
		tfRentTel.setText("");
		tfRentVideoNum.setText("");
	}
	
	
	
	/*	객체 생성 및 화면 구성   */
	void addLayout(){
		//객체생성
		tfRentTel = new JTextField(20);
		tfRentCustName = new JTextField(20);
		tfRentVideoNum = new JTextField(20);
		bRent = new JButton("대여");
		
		tfReturnVideoNum= new JTextField(20);		
		bReturn = new JButton("반납");
		
		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);
		
		
		//화면구성
		 JPanel b_main = new JPanel();
		 b_main.setLayout(new BorderLayout());
		 	JPanel b_main_up = new JPanel();
		 	
		 	b_main_up.setLayout(new GridLayout(1,2));
		 		JPanel b_main_up_left = new JPanel();
		 		b_main_up_left.setBorder(new TitledBorder("대여"));
		 		b_main_up_left.setLayout(new GridLayout(4,2));
		 		b_main_up_left.add(new Label("전화번호"));
		 		b_main_up_left.add(tfRentTel);
		 		b_main_up_left.add(new Label("고객명"));
		 		b_main_up_left.add(tfRentCustName);
		 		b_main_up_left.add(new Label("비디오번호"));
		 		b_main_up_left.add(tfRentVideoNum);
		 		b_main_up_left.add(bRent);
		 		JPanel b_main_up_right = new JPanel();
		 		b_main_up_right.setBorder(new TitledBorder("반납"));
		 		b_main_up_right.setLayout(new FlowLayout());
		 		b_main_up_right.add(new Label("비디오번호"));
		 		b_main_up_right.add(tfReturnVideoNum);
		 		b_main_up_right.add(bReturn);
		 	b_main_up.add(b_main_up_left);
		 	b_main_up.add(b_main_up_right);
		 	
		 	JPanel b_main_down = new JPanel();
		 	b_main_down.setLayout(new BorderLayout());
		 	b_main_down.add(new JScrollPane(tableRecentList),BorderLayout.CENTER);
		 b_main.add(b_main_up,BorderLayout.NORTH);
		 b_main.add(b_main_down,BorderLayout.CENTER);
		
		 setLayout(new BorderLayout());
		 add(b_main);
	}

	class RentTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","고객명","전화번호","반납예정일","반납여부"};

			public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }
		    
		    public String getColumnName(int col){
		    	return columnNames[col];
		    }
	}

	

	
}
