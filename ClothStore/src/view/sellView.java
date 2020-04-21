package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.ProductModel;
import model.dao.SellModel;
import model.vo.Customer;
import model.vo.Product;



public class sellView extends JPanel {
	JFrame frm;

	//변수들
	JTextField tfPCode,tfPSell,tfPStock,tfPTotal;
	JButton bPBuy,bPDelete,bPRefund,bPInsert;
	
	
	JTable  tableSell;
	
	SellTableModel tbModelSell;
	
	JList ShopBasket_name;//장바구니 리스트
	JList ShopBasket_price;//장바구니 가격리스트
	JList ShopBasket_stock;//장바구니 수리스트
	
	SellModel model;
	int total =0;
	int i=0;
	//장바구니 내용 저장
	Vector<String> sellNum= new Vector<String>(); 
	Vector<String> sellName= new Vector<String>(); 
	Vector sellStock= new Vector(); 
	Vector sellProduct= new Vector(); 
	
	public sellView() {
		addLayout();
		eventProc();
		connectDB();
	}
	public void connectDB() {
		 try {
	         model = new SellModel();
	      } catch (Exception e) {
	         System.out.println("Video 드라이버 로딩 실패" + e.getMessage());
	         e.printStackTrace();
	      }
		
	}
	
	 public void eventProc(){
	      ButtonEventHandler handler = new ButtonEventHandler();
	      bPInsert.addActionListener(handler);
	      bPDelete.addActionListener(handler);
	      bPBuy.addActionListener(handler);
	      bPRefund.addActionListener(handler);
	      tfPCode.addActionListener(handler);
	     
	   }      

		// 버튼 이벤트 핸들러 만들기
		class ButtonEventHandler implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();

				if (o == bPBuy) {
					buySell(); // 구매
				} else if (o == bPDelete) {
					deleteSell(); // 삭제
				} else if (o == bPInsert) {
					addSell(); // 삽입
				} else if (o == bPRefund) {
					refundSell(); // 환불
				}else if(o == tfPCode) {
					searchProduct(); 
				}
			}


	   }
		public void searchProduct() {
			String pCode = tfPCode.getText();
			
			
				try {
					tbModelSell.data = model.selectList(pCode);
					tableSell.setModel(tbModelSell);
					tbModelSell.fireTableDataChanged();
				} catch (Exception e) {
					System.out.println("상품검색 실패:"+e.getMessage());
				}
				
				tfPCode.setText("");
		
		}
		//추가
		public void addSell() {
			// 1. 입력한 전화번호 얻어오기
			String code = tfPCode.getText();
			String stock = tfPStock.getText();
			Product vo = null;
			//호출
			try {
				vo = model.searchProduct(code);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = vo.getPname();
			int price = vo.getPprice();
			
			sellNum.add(code);
			sellName.add(name);
			sellStock.add(stock);
			sellProduct.add(price*Integer.parseInt(stock));
			
			System.out.println(sellNum);
			System.out.println(sellName);
			System.out.println(sellProduct);
					
			ShopBasket_name.setListData(sellName); //리스트에 값 업데이트
			ShopBasket_price.setListData(sellProduct);
			ShopBasket_stock.setListData(sellStock);
			
			
			
			total +=(int) sellProduct.get(i);
			i++;
			
			tfPTotal.setText(String.valueOf(total));
			tfPCode.setText("");
			tfPStock.setText("1");
			
		}
		//구매
		public void buySell() {
			Product vo = new Product();
			for(int i=0;i<sellNum.size();i++) {
				
				vo.setPcode(sellNum.get(i));			
				vo.setPprice((int) sellProduct.get(i));
				vo.setPstock((int) sellStock.get(i));;
				
			}
			
		}
		//삭제
		public void deleteSell() {
			int temp =ShopBasket_name.getSelectedIndex(); //int형 임시변수 temp에 현재 선택된 리스트의 번호를 저장
			
			total -=(int) sellProduct.get(temp);
			
			sellNum.remove(temp);
			sellName.remove(temp);
			sellProduct.remove(temp);
			sellStock.remove(temp);
			System.out.println(temp);
			System.out.println(sellNum);
			System.out.println(sellName);
			System.out.println(sellProduct);
			
			
			i--;
			
			
			tfPTotal.setText(String.valueOf(total));
			ShopBasket_name.setListData(sellName); //리스트에 값 업데이트
			ShopBasket_price.setListData(sellProduct);
			ShopBasket_stock.setListData(sellStock);
		}
		//환불
		public void refundSell() {
			
		}
		
	   class SellTableModel extends AbstractTableModel { 
	        
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
	  

	public void addLayout() {
		//텍스트필드
		tfPCode			= new JTextField(10);	
		tfPSell			= new JTextField(10);
		tfPStock		= new JTextField("1",10);
		tfPTotal		= new JTextField(10);	
		
		//버튼
		bPBuy			= new JButton("구매");
		bPDelete			= new JButton("삭제");
		bPInsert			= new JButton("추가");
		bPRefund			= new JButton("환불");
		
		//장바구니
		ShopBasket_name 	= new JList();	
		ShopBasket_name.setLayout(new FlowLayout());
		ShopBasket_name.setVisible(true);
		ShopBasket_name.setFixedCellWidth(10);
		ShopBasket_name.setFixedCellHeight(30);
		
		ShopBasket_price 	= new JList();	
		ShopBasket_price .setLayout(new FlowLayout());
		ShopBasket_price .setVisible(true);
		ShopBasket_price .setFixedCellWidth(10);
		ShopBasket_price .setFixedCellHeight(30);
		
		ShopBasket_stock 	= new JList();	
		ShopBasket_stock.setLayout(new FlowLayout());
		ShopBasket_stock.setVisible(true);
		ShopBasket_stock.setFixedCellWidth(10);
		ShopBasket_stock.setFixedCellHeight(30);
		
		tbModelSell = new SellTableModel();
		tableSell = new JTable(tbModelSell);
		
		//오른쪽 영역
		JPanel Right = new JPanel();
		Right.setLayout(new BorderLayout());
			//오른쪽위
			JPanel Right_up = new JPanel();
				Right_up.setLayout(new GridLayout(2,1));
				JPanel Right_up_up = new JPanel();
				 	Right_up_up.setLayout(new BorderLayout());
					Right_up_up.add(new JLabel("장바구니"),BorderLayout.NORTH);
					JPanel Right_up_up_list = new JPanel();
						Right_up_up_list.setLayout(new GridLayout(1,3));
						Right_up_up_list.add(ShopBasket_name,BorderLayout.CENTER);
						Right_up_up_list.add(ShopBasket_price,BorderLayout.CENTER);
						Right_up_up_list.add(ShopBasket_stock,BorderLayout.CENTER);
					Right_up_up.add(Right_up_up_list);
				JPanel Right_up_down = new JPanel();
					Right_up_down.setLayout(new GridLayout(4,2));
					Right_up_down.add(new JLabel("총합"));
					Right_up_down.add(tfPTotal);
					Right_up_down.add(new JLabel("거래코드"));
					Right_up_down.add(tfPSell);
					Right_up_down.add(new JLabel("상품코드"));
					Right_up_down.add(tfPCode);				
					Right_up_down.add(new JLabel("수량"));
					Right_up_down.add(tfPStock);
				Right_up.add(Right_up_up);
				Right_up.add(Right_up_down);
				
			
				//오른쪽 아래
			JPanel Right_down = new JPanel();
				Right_down.setLayout(new GridLayout(2,2));
				Right_down.add(bPInsert);
				Right_down.add(bPDelete);
				Right_down.add(bPBuy);
				Right_down.add(bPRefund);
		Right.add(Right_up,BorderLayout.CENTER);
		Right.add(Right_down,BorderLayout.SOUTH);
		
		//왼쪽영역
		 JPanel Left= new JPanel();	     
	      
	         
	      Left.setLayout(new BorderLayout());//센터 노스 값을 주기 위해 BORDERLAYOUT사용	      
	      
	      Left.add(new JScrollPane(tableSell), BorderLayout.CENTER);
	      
	      // 영역을 2개로 나눔
	      setLayout(new BorderLayout());
	     
	      add(Left,BorderLayout.CENTER);
		
		
		
		
		add(Right,BorderLayout.EAST);
		
	}
	 
	
}
