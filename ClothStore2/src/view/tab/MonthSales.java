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


public class MonthSales  extends JPanel{
	JButton graph;
	DayGraph dgraph;
	JTextField tfMonth;
	JTextField tfpNum;
	JTextField tfstaffid;
	JTable tablesales;

	SalesTableModel TbModelSales;
	SalesModel model;
	DaySales ds;
	SalesView sv;


	//int date = cal.get(cal.DATE);

	public MonthSales(DaySales ds,SalesView sv) {
		this.ds=ds;
		this.sv=sv;
		dgraph = new DayGraph();
		
		addLayout();
		eventproc();
		connectDB();
		
	}
	void selectBydate() {
		try {
			
			ArrayList data = model.selectByMonth(tfMonth.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();

		} catch (Exception e) {
			System.out.println("월매출 검색 실패"+e.getMessage());
		}

	}
	void selectBystaffid() {
		try {
			
			ArrayList data = model.selectMstaffid(tfMonth.getText(),tfstaffid.getText());
			TbModelSales.data = data;
			tablesales.setModel(TbModelSales);
			TbModelSales.fireTableDataChanged();
			
			
		}catch (Exception e) {
			System.out.println("월매출 직원별 검색 실패"+e.getMessage());
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
		tfMonth.addActionListener(btnHandler);
		graph.addActionListener(btnHandler);
		
		//JTable에서 마우스클릭시 (영화 선택했을때)
		
		
		tablesales.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int row = tablesales.getSelectedRow();
						Date d= (Date)tablesales.getValueAt(row,1);
						
						SimpleDateFormat format = new SimpleDateFormat("MM-dd");
						
						try {
							ds.tfDate.setText(format.format(d));
							ds.selectBydate();
							sv.setPane(0);
							
							
						} catch (Exception e) {
							System.out.println("정보 출력 실패");
						}
						
						
					}
				});
	}
	

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			if(o==tfMonth) {
				
				selectBydate();
			}
			else if(o==graph){  

				
				dgraph.date =tfMonth.getText();
				dgraph.chart= dgraph.getChartMonth();
				dgraph.setup();
		        dgraph.setVisible(true);
				
			}
			else if(o==tfstaffid){
				if(tfMonth.getText().equals("")) {
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
		tfMonth = new JTextField(15);
		
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

		
		tfMonth.setBounds(820, 50, 150, 30);
		tfstaffid.setBounds(820, 100, 150, 30);
		graph.setBounds(720,670,250,50);


	
		add(datelb);
		add(tfMonth);
		add(snumlb);
		add(tfstaffid);


		add(graph);

		jsp.setBounds(10, 20, 680, 700);
		add(jsp);





	}
	//화면에 테이블 붙이는 메소드 
	class SalesTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"고객수","날짜","월매출","직원id"};

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
