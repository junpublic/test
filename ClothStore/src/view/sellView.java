package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;


public class sellView extends JPanel {
	JFrame frm;
//	String pcode; //상품코드
//	String pkind; //상품종류
//	String pname; //상품명
//	int pprice;   //상품가격
//	String psize; //사이즈
//	int pstock;	  //재고
	//변수들
	JTextField tfPCode,tfPKind,tfPName,tfPPrice,tfPSize,tfPTrade;
	JButton bPBuy,bPDelete,bPRefund,bPModify;
	TradeTableModel tbModelVideo;
	JTable  tableTrade;
	TradeTableModel tbModelTrade;
	
	public sellView() {
		addLayout();
	}

	public void addLayout() {
		tfPCode			= new JTextField(20);
		tfPKind			= new JTextField(20);
		tfPName			= new JTextField(20);
		tfPPrice		= new JTextField(20);
		tfPSize			= new JTextField(20);
		tfPTrade		= new JTextField(20);
		
		bPBuy			= new JButton("구매");
		bPDelete			= new JButton("삭제");
		bPModify			= new JButton("수정");
		bPRefund			= new JButton("환불");
		
		
		tbModelTrade = new TradeTableModel();
		tableTrade = new JTable(tbModelTrade);
		
		//오른쪽 영역
		JPanel Right = new JPanel();
		Right.setLayout(new BorderLayout());
			JPanel Right_up = new JPanel();
				Right_up.setLayout(new GridLayout(7,2));
				Right_up.add(new JLabel("거래코드"));
				Right_up.add(tfPTrade);
				Right_up.add(new JLabel("상품코드"));
				Right_up.add(tfPCode);
				Right_up.add(new JLabel("상품명"));
				Right_up.add(tfPName);
				Right_up.add(new JLabel("상품가격"));
				Right_up.add(tfPPrice);
				Right_up.add(new JLabel("상품종류"));
				Right_up.add(tfPKind);
				Right_up.add(new JLabel("사이즈"));
				Right_up.add(tfPSize);
				Right_up.add(new JLabel("수량"));
				//Right.add();
				
			
		
			JPanel Right_down = new JPanel();
				Right_down.setLayout(new GridLayout(2,2));
				Right_down.add(bPModify);
				Right_down.add(bPDelete);
				Right_down.add(bPBuy);
				Right_down.add(bPRefund);
		Right.add(Right_up,BorderLayout.CENTER);
		Right.add(Right_down,BorderLayout.SOUTH);
		
		//왼쪽영역
		 JPanel Left= new JPanel();	     
	      
	         // 오른쪽 영역 위
	        
	         
	      Left.setLayout(new BorderLayout());//센터 노스 값을 주기 위해 BORDERLAYOUT사용	      
	      
	      Left.add(new JScrollPane(tableTrade), BorderLayout.CENTER);
	      
	      // 영역을 2개로 나눔
	      setLayout(new GridLayout(1,2));
	     
	      add(Left);
		
		
		
		
		add(Right,BorderLayout.EAST);
		
	}
	   class TradeTableModel extends AbstractTableModel { 
	        
		      ArrayList data = new ArrayList();
		      String [] columnNames = {"거래코드","상품코드","상품명","상품가격","상품종류","사이즈","재고"};

		      //=============================================================
		      // 1. 기본적인 TabelModel  만들기
		      // 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		      // AbstractTabelModel에서 구현되지 않았기에...
		      // 반드시 사용자 구현 필수!!!!

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
