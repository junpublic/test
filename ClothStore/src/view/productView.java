package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.dao.ProductModel;

import model.vo.Product;
import view.sellView.ButtonEventHandler;
import view.sellView.TradeTableModel;

public class productView extends JPanel {
	JFrame frm;

	// 변수들
	JTextField tfPCode, tfPKind, tfPName, tfPPrice, tfPSize;
	JButton bPDelete, bPModify, bPInsert;

	TradeTableModel tbModelVideo;
	JTable tableProduct;
	TradeTableModel tbModelTrade;

	JCheckBox cbMultiInsert;
	JTextField tfPStock;

	ProductTableModel tbModelProduct;
	ProductModel model;
	// 생성자
	public productView() {
		addLayout();
		eventProc();
		connectDB();   // DB연결
//		selectList();
	}

	public void connectDB() {
		 try {
	         model = new ProductModel();
	      } catch (Exception e) {
	         System.out.println("Video 드라이버 로딩 실패" + e.getMessage());
	         e.printStackTrace();
	      }
		
	}
//	void selectList() {
//		try {
//			ArrayList data = model.selectList();
//			tbModelProduct.data = data;
//			tableProduct.setModel(tbModelProduct);
//			tbModelProduct.fireTableDataChanged();
//		} catch (Exception e) {
//			System.out.println("검색실패:"+e.getMessage());
//		}
//	}

	// 이벤트처리
	public void eventProc() {
		ButtonEventHandler handler = new ButtonEventHandler();
		// 리스너 추가
		bPModify.addActionListener(handler);
		bPDelete.addActionListener(handler);
		bPInsert.addActionListener(handler);
		tfPCode.addActionListener(handler);
		
		tableProduct.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				int row = tableProduct.getSelectedRow();
				int vnum = Integer.valueOf((String) tableProduct.getValueAt(row, 0));//0은 pk(시퀀스)인 NUM
				try {
					Product vo = model.selectByPK(vnum);
					tfPCode.setText(vo.getPcode());
					tfPKind.setText(vo.getPkind());
					tfPName.setText(vo.getPname());
					tfPPrice.setText(String.valueOf(vo.getPprice()));
					tfPSize.setText(vo.getPsize());
					tfPStock.setText(String.valueOf(vo.getPstock()));
					
				} catch (Exception e1) {
					System.out.println("비디오 모델 접속 불가능" + e1.getMessage());
					e1.printStackTrace();
				} 
				
			}
		});



	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();

			if (o == bPDelete) {
				deleteProduct(); // 상품삭제
			} else if (o == bPModify) {
				modifyProduct(); // 상품수정
			} else if (o == bPInsert) {
				insertProduct();
			}else if(o == tfPCode) {
				searchProduct();
			}

		}

	}
	public void searchProduct() {
		String pCode = tfPCode.getText();
		
		
			try {
				tbModelProduct.data = model.selectList(pCode);
				tableProduct.setModel(tbModelProduct);
				tbModelProduct.fireTableDataChanged();
			} catch (Exception e) {
				System.out.println("상품검색 실패:"+e.getMessage());
			}
			
			tfPCode.setText("");
			tfPKind.setText("");
			tfPName.setText("");
			tfPPrice.setText("");
			tfPSize.setText("");
			tfPKind.setText("");
			
		
	}

	public void insertProduct() {
		// 1. 각 화면의 입력값들 얻어오기
		String pCode = tfPCode.getText();
		String pKind = tfPKind.getText();
		String pName = tfPName.getText();
		String pPrice = tfPPrice.getText();
		String pSize = tfPSize.getText();
		String pStock = tfPStock.getText();

		// 2. Video 클래스에 멤버 변수로 지정
		Product vo = new Product();
		vo.setPcode(pCode);
		vo.setPkind(pKind);
		vo.setPname(pName);
		vo.setPprice(Integer.parseInt(pPrice));
		vo.setPsize(pSize);
		vo.setPstock(Integer.parseInt(pStock));
		

		try {
			model.insertProduct(vo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 4. 화면 초기화
		tfPCode.setText("");
		tfPKind.setText("");
		tfPName.setText("");
		tfPPrice.setText("");
		tfPSize.setText("");
		tfPKind.setText("");
	}

	public void modifyProduct() {
//		

	}

	public void deleteProduct() {
		
		// 1. 화면 텍스트필드의 입력값 얻어오기
		
		
		try {
			ProductModel pdm = new ProductModel();
			String pCode = tfPCode.getText();
			pdm.deleteProduct(pCode);
		} catch (Exception e) {
			System.out.println("삭제 실패:"+e.getMessage());
		}
		// 4. 화면 초기화
				tfPCode.setText("");
				tfPKind.setText("");
				tfPName.setText("");
				tfPPrice.setText("");
				tfPSize.setText("");
				tfPKind.setText("");
		
		

	}

	class ProductTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "상품코드", "상품명", "상품가격", "상품종류", "사이즈", "재고" };

		// =============================================================
		// 1. 기본적인 TabelModel 만들기
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
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	public void addLayout() {

		tfPCode = new JTextField(20);
		tfPKind = new JTextField(20);
		tfPName = new JTextField(20);
		tfPPrice = new JTextField(20);
		tfPSize = new JTextField(20);
		tfPStock = new JTextField("1", 5);
		// 수량

		bPDelete = new JButton("삭제");
		bPModify = new JButton("수정");
		bPInsert = new JButton("삽입");


		tbModelProduct = new ProductTableModel();
		tableProduct = new JTable(tbModelProduct);

		// 오른쪽 영역
		JPanel Right = new JPanel();
		Right.setLayout(new BorderLayout());
		JPanel Right_up = new JPanel();
		Right_up.setLayout(new GridLayout(6, 2));

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
		Right_up.add(tfPStock);
		

		JPanel Right_down = new JPanel();
		Right_down.setLayout(new GridLayout(1, 3));
		Right_down.add(bPInsert);
		Right_down.add(bPModify);
		Right_down.add(bPDelete);
		

		Right.add(Right_up, BorderLayout.CENTER);
		Right.add(Right_down, BorderLayout.SOUTH);

		// 왼쪽영역
		JPanel Left = new JPanel();

		// 오른쪽 영역 위

		Left.setLayout(new BorderLayout());// 센터 노스 값을 주기 위해 BORDERLAYOUT사용

		Left.add(new JScrollPane(tableProduct), BorderLayout.CENTER);

		// 영역을 2개로 나눔
		setLayout(new GridLayout(1, 2));

		add(Left);

		add(Right, BorderLayout.EAST);

	}

}
