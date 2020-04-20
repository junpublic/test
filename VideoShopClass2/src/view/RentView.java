package  view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.RentModel;



public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;
	
	JTextField tfReturnVideoNum;
	JButton bReturn;
	
	JTable tableRecentList;
	
	RentTableModel rentTM;
	
	// 모델단 변수 선언
	RentModel model;//null 값들으으음~

	
	//==============================================
	//	 생성자 함수
	public RentView(){
		addLayout();	//화면구성
		eventProc();	
		connectDB();	//DB연결
		selectList();	//미납목록보기
	}
	
	// DB 연결
	void connectDB(){
		try {
			model = new RentModel();
		} catch (Exception e) {
			System.out.println("대여관리-오라클 드라이버 로딩 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	// 이벤트 등록
	public void eventProc(){
		BtnHandler handler = new BtnHandler();
		tfRentTel.addActionListener(handler);
		bRent.addActionListener(handler);
		bReturn.addActionListener(handler);
		                         
	}

	class BtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			if(evt == tfRentTel) {
				selectByTel();
			}
			else if(evt == bRent) {
				rentVideo();
				selectList();
			}
			else if(evt == bReturn) {
				returnVideo();
				selectList();
			}
			
		}
		
	}
	
	void selectByTel() {
		String tel = tfRentTel.getText();
		try {
			String c_name = model.selectByTel(tel);
			tfRentCustName.setText(c_name);
		} catch (Exception e) {
			System.out.println("전화번호검색-모델접속 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	void rentVideo() {
		String tel = tfRentTel.getText();
		int vnum = Integer.parseInt(tfRentVideoNum.getText());
		
		try {
			model.rentVideo(tel, vnum);
		} catch (Exception e) {
			System.out.println("대여실패" + e.getMessage());
			e.printStackTrace();
		}
		//화면초기화
		tfRentTel.setText("");
		tfRentCustName.setText("");
		tfRentVideoNum.setText("");
	}
	
	void returnVideo() {
		int vnum = Integer.parseInt(tfReturnVideoNum.getText());
		try {
			int result = model.returnVideo(vnum);
			if(result == 0) {
				JOptionPane.showMessageDialog(null, + vnum + "번 비디오 반납에 실패하였습니다.");
			}else if(result == 1) {
				JOptionPane.showMessageDialog(null, + vnum + "번 비디오 반납완료.");
			}
		} catch (Exception e) {
			System.out.println("리턴비디오 연결 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	void selectList() {
		try {
			ArrayList data = model.selectList();
			rentTM.data = data;
			tableRecentList.setModel(rentTM);
			rentTM.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("미납목록 검색 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	/*	객체 생성 및 화면 구성   */
	void addLayout(){
		tfRentTel = new JTextField(10);
		tfRentCustName = new JTextField(10);
		tfRentVideoNum = new JTextField(10);
		bRent = new JButton("대여");
		
		tfReturnVideoNum = new JTextField(10);
		bReturn = new JButton("반납");
		
		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);
		
		//North
		JPanel p_north = new JPanel();
		p_north.setLayout(new GridLayout(1,2));
		
			//North left
			JPanel p_north_l = new JPanel();
			p_north_l.setBorder(new TitledBorder("대여"));
			p_north_l.setLayout(new GridLayout(4,2));
			p_north_l.add(new JLabel("전화번호"));
			p_north_l.add(tfRentTel);
			p_north_l.add(new JLabel("고객명"));
			p_north_l.add(tfRentCustName);
			p_north_l.add(new JLabel("비디오번호"));
			p_north_l.add(tfRentVideoNum);
			p_north_l.add(bRent);
			
			//North right
			JPanel p_north_r = new JPanel();
			p_north_r.setLayout(new FlowLayout());
			p_north_r.setBorder(new TitledBorder("반납"));
			p_north_r.add(new JLabel("비디오 번호"));
			p_north_r.add(tfReturnVideoNum);
			p_north_r.add(bReturn);
			
		p_north.add(p_north_l);
		p_north.add(p_north_r);
		
		
		


		//2개로 나눔
		setLayout(new BorderLayout());
			add(p_north, BorderLayout.NORTH);
			add(new JScrollPane(tableRecentList), BorderLayout.CENTER);
		
		
		
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
