package e_event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//(1)이벤트 핸들러
public class TestB extends JFrame implements ActionListener{//자기 자신을 이벤트 핸들러로 만들어 버림
	JButton b1;
	JTextField t1;
	TestB(){
		b1 = new JButton("b1");
		t1 = new JTextField(10);
		
		setLayout(new FlowLayout());
		add(b1);
		add(t1);
		
		setSize(400,400);
		setVisible(true);
		
	}
	void eventProc() {
		b1.addActionListener(this);
		t1.addActionListener(this);//자기 자신의 객체를 지칭하는 언어
	}
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
	public static void main(String[] args) {
		//(2)이벤트핸들러 객체 생성
		TestB test = new TestB();
		test.eventProc();
		
	}

	

}