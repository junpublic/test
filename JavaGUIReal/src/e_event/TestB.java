package e_event;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// (1) 이벤트 핸들러
public class TestB extends JFrame implements ActionListener{//인터페이스 앞에는 자동으로 public이 잡힌다 + 다중상속이 가능
	//멤버변수 선언
	JTextField tf;
	JButton b;
	
	public TestB() {
		//객체선언
		b = new JButton("확인");
		tf = new JTextField(10);
		
		//화면구성
		setLayout(new FlowLayout());
		add(b);
		add(tf);
		
		//화면출력
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc() {
		// (3) 이벤트 연결
		b.addActionListener(this);//자기 자신 객체를 지칭하는 언어
		tf.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		Object evt = e.getSource();//어떤 이벤트(버튼, 텍스트 필드 등) 모르기때문에 모든 걸 담은 Object에서 리턴해주고 캐스팅으로 사용할 것
		if(evt == b) {
			String msg = b.getText();
			JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");
		}else if(evt == tf) {
			String msg = tf.getText();
			JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");		
		}
	}
	
	public static void main(String[] args) {
		// (2) 이벤트 핸들러 객체 생성
		TestB test = new TestB();//객체선언
		test.eventProc();

	}


}
