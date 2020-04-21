package z_sample;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {//
	//멤버변수 선언 현재 null값
	JTextField tf;
	JTextField tf2;
	JButton b;
	
	
	
	public Login() {//생성자 함수
		b = new JButton("Login");//객체생성
		tf = new JTextField(10);
		tf2 = new JTextField(10);
	
		
		
	}
	
	public void display() {
		JLabel id = new JLabel("아이디");//지역변수 선언
		JLabel pass = new JLabel("비밀번호");
	
		//JFrame의 기본 양식은 BorderLayout이다.
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,2));
		p.add(id);
		p.add(tf);
		p.add(pass);
		p.add(tf2);
		add(p, BorderLayout.CENTER);
		add(b, BorderLayout.EAST);
	
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		Login log = new Login();//객체생성
		log.display();
		
		

	}

}
