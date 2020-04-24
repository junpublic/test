package view.tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import view.SalesView;
import view.graph.DayGraph;

public class YearSales extends JPanel {
	
	JButton reset;
	JButton graph;
	DayGraph dgraph;
	JTextField tfstaffid;
	JTable tablesales;
	
	SalesTableModel TbModelSales;
	SalesModel model;


	MonthSales ms;
	SalesView sv;


	public YearSales(MonthSales ms, SalesView sv) {
		this.ms = ms;
		this.sv = sv;
		dgraph = new DayGraph();
		addLayout();
		eventproc();
		connectDB();
		selectBydate();
	}
	public void selectBydate() {
		try {
			ArrayList data = model.selectByYear();
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();

		} catch (Exception e) {
			System.out.println("년매출 검색 실패"+e.getMessage());
			e.printStackTrace();
		}

	}
	void selectBystaffid() {
		try {
			
			ArrayList data = model.selectYstaffid(tfstaffid.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();
			
			
		}catch (Exception e) {
			System.out.println("년매출 직원별 검색 실패"+e.getMessage());
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
		reset.addActionListener(btnHandler);
		graph.addActionListener(btnHandler);
		
		tablesales.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = tablesales.getSelectedRow();
				String d= (String)tablesales.getValueAt(row,1);
				
				//SimpleDateFormat format = new SimpleDateFormat("dd");
				
				try {
					ms.tfMonth.setText(d);
					ms.selectBydate();
					sv.setPane(1);
					
					
				} catch (Exception e) {
					System.out.println("정보 출력 실패");
				}
				
				
			}
		});
	}

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			if(o==graph){  
			
				dgraph.chart= dgraph.getChartYear();
				dgraph.setup();
		        dgraph.setVisible(true);

			}
			else if(o==reset) {
				selectBydate();
			}
			else if(o==tfstaffid){
					selectBystaffid();

			}


		}
	}
	public void addLayout() {
		//멤버변수 객체 생성

		JLabel snumlb= new JLabel("직원id");

		graph = new JButton("그래프");
		reset = new JButton("연매출");
		tfstaffid = new JTextField(15);

		TbModelSales = new SalesTableModel();

		tablesales = new JTable(TbModelSales);
		JScrollPane jsp = new JScrollPane(tablesales);
		JLabel titlelb= new JLabel("매출관리");






		setLayout(null);


		titlelb.setFont(titlelb.getFont().deriveFont(30.0f)); 
		snumlb.setFont(snumlb.getFont().deriveFont(15.0f)); 

		setBorder(new TitledBorder("매출내역"));



		snumlb.setBounds(720, 50, 60, 30);

		tfstaffid.setBounds(820, 50, 150, 30);
		graph.setBounds(720,670,250,50);
		reset.setBounds(720,600,250,50);
	
		add(snumlb);
		add(tfstaffid);

		add(reset);
		add(graph);

		jsp.setBounds(10, 20, 680, 700);
		add(jsp);





	}
	//화면에 테이블 붙이는 메소드 
	class SalesTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"고객수","날짜","년매출","직원id"};

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
