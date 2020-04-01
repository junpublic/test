package e_event;

import javax.swing.*;
import java.awt.*;//awt밑의 모든 클래스-> 그 하위폴더까지는 아님
import java.awt.event.*;

public class TestA2 extends JFrame{
	JButton b1;
	JTextField t1;
	
	TestA2(){
		b1 = new JButton("b1");
		t1 = new JTextField(10);
		
		setLayout(new FlowLayout());
		add(t1);
		add(b1);
		
		
		setSize(400,400);
		setVisible(true);
		
	}
	public void eventProc() {
		//(2)이벤트 핸들러 객체 생성
//		MyEvent me = new MyEvent();
		
		//(3)이벤트 연결
//		b1.addActionListener(new MyEvent());//객체를 생성하는 순간 연결해버림
		
		
		//(1)이벤트 핸들러 구현
		//(2)이벤트 핸들러 객세 생성
		//(3)//이벤트 연결
		b1.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
		{//이름없는 클래스를 버튼에 넣어버림?
			@Override
			public void actionPerformed(ActionEvent e) {	
					String msg = b1.getText();
					JOptionPane.showMessageDialog(null, msg + "버튼 이벤트 발생");						
			}		
		});
		t1.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {	
				String msg = t1.getText();
				JOptionPane.showMessageDialog(null, msg + "입력하였습니다.");						
			}		
				});
	}
	
	//(1) 이벤트 핸들러
//	class MyEvent implements ActionListener{//이벤트 핸들러를 따로 만들어서 객체를 생성해서 불러옴
//		@Override
//		public void actionPerformed(ActionEvent e) {//버튼만 이벤트 핸들러 따로만듬		
//				String msg = b1.getText();
//				JOptionPane.showMessageDialog(null, msg + "버튼 이벤트 발생");						
//		}		
//	}
	public static void main(String[] args) {
		TestA2 test = new TestA2();
		test.eventProc();
	}

}
