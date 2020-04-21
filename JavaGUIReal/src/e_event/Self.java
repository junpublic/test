package e_event;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Self extends JFrame implements ActionListener {
	// 멤버 변수 선언
	JButton b;
	JTextField tf;
	
	public Self() {
		// 객체선언
		b = new JButton("확인");
		tf = new JTextField(10);
		// 화면구성
		setLayout(new FlowLayout());
		add(b);
		add(tf);
		// 화면출력
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
//	public void eventProc() {
//		//이벤트 객체생성
//		MyEvent me = new MyEvent();
//		
//		//이벤트 연결
//		b.addActionListener(me);
//		tf.addActionListener(me);
//	}
	
	
	// 이벤트 핸들러(구현)
//	class MyEvent implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			Object evt = e.getSource();
//			if(evt == b) {
//				String msg = b.getText();
//				JOptionPane.showMessageDialog(null, msg + "입니다.");
//			}else if(evt == tf) {
//				String msg = tf.getText();
//				JOptionPane.showMessageDialog(null, msg + "입니다.");
//			}
//		}
//		
//	}
	void eventProc() {
		b.addActionListener(this);
		tf.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();//오브젝트로 한 이유는 어떠한 입력값이 올지 모르기때문에 모든 것을 담고있는 Object에서 리턴해 주고 캐스팅 해서 사용해라
		if(evt == b) {
			String msg = b.getText();
			JOptionPane.showMessageDialog(null, msg + "입니다");
		}else if(evt == tf) {
			String msg = tf.getText();
			JOptionPane.showMessageDialog(null, msg + "입니다");
		}

	}
	
	
	public static void main(String[] args) {
		Self s = new Self();
		
	}






}
