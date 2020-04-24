package view.tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;




public class DaySales extends JPanel {
	JButton graph;
	DayGraph dgraph;
	JTextField tfDate;

	JTextField tfstaffid;
	JTable tablesales;

	SalesTableModel TbModelSales;
	SalesModel model;
	
	
	

	//int date = cal.get(cal.DATE);

	public DaySales() {
		dgraph = new DayGraph();
		addLayout();
		eventproc();
		connectDB();
		
        
		
	}
	
	void selectBydate() {
		try {

			ArrayList data = model.selectBydate(tfDate.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();
			
		} catch (Exception e) {
			System.out.println("일별매출 검색 실패"+e.getMessage());
		}

	}
	void selectBystaffid() {
		try {
			ArrayList data = model.selectstaffid(tfDate.getText(),tfstaffid.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();


		}catch (Exception e) {
			System.out.println("일별 직원별 검색 실패"+e.getMessage());
		}

	}
	
	
	void connectDB() {
		try {
			model = new SalesModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패"+e.getMessage());
		}

	}
	public void eventproc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();


		tfstaffid.addActionListener(btnHandler);
		tfDate.addActionListener(btnHandler);
		graph.addActionListener(btnHandler);
	}

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			if(o==tfDate) {
				selectBydate();
			}
			else if(o==graph){  

		        dgraph.date =tfDate.getText();
		        dgraph.chart= dgraph.getChart(); 
				dgraph.setup();
		        dgraph.setVisible(true);

			}
			else if(o==tfstaffid){
				if(tfDate.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "찾고 싶은 날짜를 입력해주세요");
				}else {
					selectBystaffid();
				}

			}


		}
	}
	public void addLayout() {
		//멤버변수 객체 생성
		JLabel datelb= new JLabel("거래날짜");

		JLabel snumlb= new JLabel("직원id");

		graph = new JButton("그래프");
		tfDate = new JTextField(15);

		tfstaffid = new JTextField(15);

		TbModelSales = new SalesTableModel();

		tablesales = new JTable(TbModelSales);
		JScrollPane jsp = new JScrollPane(tablesales);
		JLabel titlelb= new JLabel("매출관리");






		setLayout(null);


		titlelb.setFont(titlelb.getFont().deriveFont(30.0f)); 
		datelb.setFont(datelb.getFont().deriveFont(15.0f)); 

		snumlb.setFont(snumlb.getFont().deriveFont(15.0f)); 

		setBorder(new TitledBorder("매출내역"));


		datelb.setBounds(720, 50, 60, 30);
		snumlb.setBounds(720, 100, 60, 30);


		tfDate.setBounds(820, 50, 150, 30);

		tfstaffid.setBounds(820, 100, 150, 30);
		graph.setBounds(720,670,250,50);


		add(datelb);
		add(tfDate);


		add(snumlb);
		add(tfstaffid);


		add(graph);

		jsp.setBounds(10, 20, 680, 700);
		add(jsp);





	}
	//화면에 테이블 붙이는 메소드 
	class SalesTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"거래번호","수량","가격","거래날짜","상품번호","직원id"};

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

