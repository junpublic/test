package h_jtable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class JTableTest extends JFrame {

	JTable table;//변수만 선언하고 객체 생성을 안해 null포인트 익셉션 발생
	JButton btn;
	MyTableModel myTM;


	public JTableTest() {
		// 객체생성
		//Jtable의 view
		myTM = new MyTableModel();// Jtable의 데이터와 컬럼명(Model)
		table = new JTable(myTM);//테이블 안에있는 데이터를 관리하는 모델(데이터 관리용 class MyTableModel 생성)과 데이터를 감지하는 뷰(화면 관리용 JTable)를 따로 관리해야한다. 
		btn = new JButton("확인");


		// 화면구성 기본값 보더 레이아웃
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(btn, BorderLayout.NORTH);


		// 화면출력
		setBounds(100, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//엑스버튼 누르면 꺼짐 엑스버튼 눌러도 안꺼지려면 donothing

		// 이벤트처리
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				System.out.println(row + ":" + col + "이벤트 발생");
			}
		});
	}
	void change() {
		ArrayList data = new ArrayList();//행의 배열
		for(int i=0; i<5; i++) {// row
			ArrayList temp = new ArrayList();//열의 배열
			for(int j=0; j<4; j++) {// col
				if(j==0) temp.add(new Boolean(false));
				else temp.add(new Integer(j+1)); //Integer로 명시해줌 열 안에 들어가는 내용물 
			}
			data.add(temp);//행 data에 열 데이터 넣음
		}
		myTM.data = data;
		table.setModel(myTM);//화면에도 변경된 데이터 업데이트
		myTM.fireTableDataChanged(); // 모델측에서 화면(뷰)한테 내용 변경됨을 알려줘야 함
	}


	class MyTableModel extends AbstractTableModel{//테이블에서 데이터를 관리하려고
		String [] columnName = {"하나", "둘", "셋", "넷"};//테이블 위 목록들을 컬럼의 배열 형태로 만듬
		ArrayList data = new ArrayList();


		@Override
		public int getColumnCount() {//컬럼의 개수
			return columnName.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {//n열의 n행을 리턴하는 함수
			ArrayList temp = (ArrayList)data.get(rowIndex);//get()는 무조건 오브젝트에서 따옴 따라서 형변환을 통해 ArrayList temp에 담자 // n열 = temp
			return temp.get(columnIndex);//n행 = columnIndex -> n열의 n행의 데이터를 리턴
		}//추상메소드

		public String getColumnName(int c) {
			return columnName[c];
		}
//---------------------이 메서드로 false가 다 체크박스로 변함-----------------------------
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
//------------------------화면을 수정하게 하는 메서드---------------------------------------------------------------------------
		public boolean isCellEditable(int row, int col) {
			if(col < 2) return true;
			else return false;
		}

		public void setValueAt(Object value, int row, int col) {
			ArrayList temp = (ArrayList)data.get(row);
			temp.set(col, value);
			fireTableCellUpdated(row, col);
		}

	}




	public static void main(String[] args) {
		JTableTest jt = new JTableTest();


	}

}
