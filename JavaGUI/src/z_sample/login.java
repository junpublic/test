package z_sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

public class login extends JFrame{
	JTextField f1,f2;
	JButton b1;
	
	login(){
		f1 = new JTextField(10);
		f2 = new JTextField(10);
		b1 = new JButton("로그인");
	}
	
	void display() {
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(2,2));
			p.add(id);
			p.add(f1);
			p.add(pw);
			p.add(f2);
		add(p,BorderLayout.CENTER);
		add(b1,BorderLayout.EAST);
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		login log = new login();
		log.display();
	}

}
