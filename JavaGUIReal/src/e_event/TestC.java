package e_event;

import java.awt.*;//*의 의미는 모든 클래스 즉, awt안에 모든 클래스만 사용 하위 폴더에는 안들어가짐
import javax.swing.*;
import java.awt.event.*;

public class TestC extends JFrame{
	//멤버변수 선언
	JTextField tf;
	JButton b;
	
	public TestC() {
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
//		// (2) 이벤트 핸들러 객체를 생성
//		MyEvent me = new MyEvent();
//		
//		// (3) 이벤트 연결
//		b.addActionListener(me);
//===========같은 것이지만 축약형=================== me를 한번만 사용하기 때문에
		// (1) 이벤트 핸들러 구현
		// (2) 이벤트 핸들러 객체를 생성		
		// (3) 이벤트 연결
		b.addActionListener(new ActionListener()//ActionListener를 구현한 이름없는 클래스를 new로 만듬 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = b.getText();
				JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");
			}
		});

		tf.addActionListener(new ActionListener()//ActionListener를 구현한 이름없는 클래스를 구현하고 new로 객체 생성
				{//추상메소드, 인터페이스는 객체 생성이 안된다.
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, tf.getText() + "를 입력하셨습니다.");
			}
				});
	}
	
	// (1) 이벤트 핸들러
//	class MyEvent implements ActionListener{//inner class TestA.myEvent & 인터페이스 Listener 구현 & 인터페이스 안에서는 설계만, 어떤 코딩을 하면 안된다.
//		@Override
//		public void actionPerformed(ActionEvent e) {//jvm이 불러줌 + 사용자가 이벤트가 발생했을 때
//			Object evt = e.getSource();//어떤 이벤트(버튼, 텍스트 필드 등) 모르기때문에 모든 걸 담은 Object에서 리턴해주고 캐스팅으로 사용할 것
//				String msg = b.getText();
//				JOptionPane.showMessageDialog(null, msg + "를 입력하셨습니다.");
//		}
//	}
	
	public static void main(String[] args) {
		TestC test = new TestC();//객체선언
		test.eventProc();

	}

}
