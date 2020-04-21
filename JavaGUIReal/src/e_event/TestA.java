package e_event;

import java.awt.*;//*의 의미는 모든 클래스 즉, awt안에 모든 클래스만 사용 하위 폴더에는 안들어가짐
import javax.swing.*;
import java.awt.event.*;

public class TestA extends JFrame{
	//멤버변수 선언
	JTextField tf;
	JButton b;
	
	public TestA() {
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
	
	public void eventProc() {
		// (2) 이벤트 핸들러 객체를 생성
		MyEvent me = new MyEvent();
		
		// (3) 이벤트 연결
		b.addActionListener(me);
		tf.addActionListener(me);
	}
	
	// (1) 이벤트 핸들러
	class MyEvent implements ActionListener{//inner class TestA.myEvent & 인터페이스 Listener 구현 & 인터페이스 안에서는 설계만, 어떤 코딩을 하면 안된다.
		@Override
		public void actionPerformed(ActionEvent e) {//jvm이 불러줌 + 사용자가 이벤트가 발생했을 때
			Object evt = e.getSource();//어떤 이벤트(버튼, 텍스트 필드 등) 모르기때문에 모든 걸 담은 Object에서 리턴해주고 캐스팅으로 사용할 것
			if(evt == b) {
				String msg = b.getText();
				JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");
			}else if(evt == tf) {
				String msg = tf.getText();
				JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");		
			}
			
		}
	}
	
	public static void main(String[] args) {
		TestA test = new TestA();//객체선언
		test.eventProc();

	}

}
