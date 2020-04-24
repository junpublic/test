package view.tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.SalesModel;
import view.graph.DayGraph;

public class ProductSales extends JPanel {
	JButton graph;
	DayGraph dgraph;
	
	JTextField tfpNum;

	JTable tablesales;

	SalesTableModel TbModelSales;
	SalesModel model;





	public ProductSales() {
		dgraph = new DayGraph();
		addLayout();
		eventproc();
		connectDB();
		selectBydate();

	}
	void selectBydate() {
		try {

			ArrayList data = model.selectByProduct();
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();

		} catch (Exception e) {
			System.out.println("월매출 검색 실패"+e.getMessage());
		}

	}
	void selectByProductId() {
		try {

			ArrayList data = model.selectProductId(tfpNum.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();


		}catch (Exception e) {
			System.out.println("상품별매출 직원별 검색 실패"+e.getMessage());
		}

	}
	void connectDB() {
		try {
			model = new SalesModel();
		} catch (Exception e) {
			
			System.out.println("드라이버 로딩 실패"+e.getMessage());
		}

	}
	public void eventproc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();


	
		tfpNum.addActionListener(btnHandler);
		graph.addActionListener(btnHandler);
	}

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			if(o==graph){  
				dgraph.chart= dgraph.getChartProduct();
				dgraph.setup();
				dgraph.setVisible(true);
				
			}
			else if(o==tfpNum){
				selectByProductId();

			}



		}
	}
	public void addLayout() {
		//멤버변수 객체 생성
		
		JLabel pnumlb= new JLabel("상품번호");


		graph = new JButton("그래프");
		
		tfpNum = new JTextField(15);


		TbModelSales = new SalesTableModel();

		tablesales = new JTable(TbModelSales);
		JScrollPane jsp = new JScrollPane(tablesales);
		JLabel titlelb= new JLabel("매출관리");






		setLayout(null);


		titlelb.setFont(titlelb.getFont().deriveFont(30.0f)); 
		
		pnumlb.setFont(pnumlb.getFont().deriveFont(15.0f)); 
		

		setBorder(new TitledBorder("매출내역"));


		
		pnumlb.setBounds(720, 50, 60, 30);

		
		tfpNum.setBounds(820, 50, 150, 30);

		graph.setBounds(720,670,250,50);


	
		
		add(pnumlb);
		add(tfpNum);



		add(graph);

		jsp.setBounds(10, 20, 680, 700);
		add(jsp);




		
		}
		//화면에 테이블 붙이는 메소드 
		class SalesTableModel extends AbstractTableModel { 

			ArrayList data = new ArrayList();
			String [] columnNames = {"고객수","매출","상품명","상품번호"};

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
