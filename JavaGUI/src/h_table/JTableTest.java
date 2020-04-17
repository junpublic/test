package h_table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class JTableTest extends JFrame
{
	JTable table;
	JButton btn;
	MyTableModel myTM;
	
	public JTableTest() {
		//객체생성
		myTM = new MyTableModel(); // JTable의 테이타와 컬럼명(Model)
		table = new JTable(myTM);//JTable의 View
		btn = new JButton("확인");
		
		
		//화면 구성
		add(new JScrollPane(table),BorderLayout.CENTER);//스크롤Pane과 같이 써줘여 한다 한쓰면 안뜸
		add(btn,BorderLayout.NORTH);
		
		//화면 출력
		setBounds(100,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//이벤트 처리
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				change();//클라스 안에 클라사라(이너클래스) 함수를 불러줘야 한다.
				
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e ) {//몇번째행 몇번째열인지 찍어줌
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				System.out.println(row+":"+col+"이벤트 발생");
			}
		});
		
	}
	
	void change() {
		ArrayList data = new ArrayList();
		for(int i=0;i<5;i++) {	//row
			ArrayList temp = new ArrayList();
			for(int j = 0;j<4;j++) {	//col
				if(j==0) temp.add(new Boolean(false));
				temp.add(new Integer(j+1));//int->Integer로 자동변환된다. integer를 써서 명시해줌
			}
			data.add(temp);
		}
		
		myTM.data = data;
		table.setModel(myTM);//view와 model이 바뀌면 자바는 모르니 신호를 줘서 바꿔줘야한다.
		myTM.fireTableDataChanged();//모델측에서 화면(뷰)한테 내용변경됨을 알려줘야 함
		
	}
	
	class MyTableModel extends AbstractTableModel{//테이블에서 데이터를 관리하려고
		String [] columnName = {"하나","둘","삼","사"};//컬럼명을 저장
		ArrayList data = new ArrayList();		
		
		@Override
		public int getColumnCount() {
			
			return columnName.length;
		}

		@Override
		public int getRowCount() {
			
			return data.size();//줄 수
		}

		@Override//몇번째 행에 몇번째 열
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList)data.get(rowIndex);
			return temp.get(columnIndex);
		}
		
		public String getColumnName(int c) {//배열이 있는 것들을 하나씩 가져옴
			return columnName[c];//JTable이 부르는거임 우리는 안씀 ,  오버라이딩만 해주면 된다
		}
		
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
		//---------화면을 수정하는 메소드-------------
		public boolean isCellEditable(int row,int col) {
			if(col<2) return true;
			else return false;
		}
		
		public void setValueAt(Object value,int row, int col) {//편집을 가능하게 함
			ArrayList temp = (ArrayList)data.get(row);
			temp.set(col, value);
			fireTableCellUpdated(row, col);//뷰(화면)에 바뀌었다고 신호를 줘야한다.
		}
		
	}
	public static void main(String[] args) {
		JTableTest jt = new JTableTest();

	}

}
