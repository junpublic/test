package e_event;

import javax.swing.*;
import java.awt.*;//awt밑의 모든 클래스-> 그 하위폴더까지는 아님
import java.awt.event.*;

public class TestA extends JFrame{
	JButton b1;
	JTextField t1;
	
	TestA(){
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
		MyEvent me = new MyEvent();
		
		//(3)이벤트 연결
		b1.addActionListener(me);
		t1.addActionListener(me);
	}
	
	//(1) 이벤트 핸들러
	class MyEvent implements ActionListener{//이벤트 핸들러를 따로 만들어서 객체를 생성해서 불러옴

		@Override
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();//어떤 이벤트가 발생할지 모르기 때문에 오브젝트로 받음
			if(evt ==b1) {
				String msg = b1.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 이벤트 발생1");
			}else if(evt == t1) {
				String msg = t1.getText();
				JOptionPane.showMessageDialog(null,msg+ "를 입력하셨습니다.");
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		TestA test = new TestA();
		test.eventProc();
	}

}
