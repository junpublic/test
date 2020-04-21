package a_sample;

import java.awt.*;
import javax.swing.*;

public class Self extends JFrame {
	// 멤버변수 선언
	JButton b;
	JTextField tf;
	JTextArea ta;
	JLabel l;
	JList list;
	JCheckBox cb, cb2;
	
	// 생성자 함수 & 객체 생성
	public Self() {
		super("나의 창");
		tf = new JTextField("5글자 미만 입력", 40);
		b = new JButton("OK");
		ta = new JTextArea();
		l = new JLabel("NAME");
		cb = new JCheckBox("male", true);
		cb2 = new JCheckBox("female");
		
		//NORTH 영역
		setLayout(new BorderLayout());
		add(tf, BorderLayout.NORTH);
		//WEST 영역
		add(b, BorderLayout.WEST);
		//CENTER 영역
		add(ta, BorderLayout.CENTER);
		//EAST 영역
		add(l, BorderLayout.EAST);
		//SOUTH 영역
		JPanel p = new JPanel();
		p.add(cb);
		p.add(cb2);
		add(p, BorderLayout.SOUTH);
		
		
		
	}
	
	public void display() {
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//출력
	
	public static void main(String[] args) {
		Self s = new Self();
		s.display();

	}

}
