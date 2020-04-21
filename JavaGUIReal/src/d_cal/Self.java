package d_cal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Self extends JFrame implements ActionListener {
	//멤버변수
	JTextField tf;
	JButton [] b = new JButton[15];
	int prev; //이전값을 저장
	String op; //연산자를 저장
	
	
	public Self() {
		//객체 생성
		tf = new JTextField(10);
		for(int i = 0; i<10; i++) {
			b[i] = new JButton(String.valueOf(i));
			
		}
		b[10] = new JButton("+");
		b[11] = new JButton("=");
		b[12] = new JButton("-");
		b[13] = new JButton("*");
		b[14] = new JButton("/");
		
		add(tf, BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,3));
		for(int i=1; i<10; i++) {
			p.add(b[i]);
		}
		p.add(b[10]);
		p.add(b[0]);
		p.add(b[11]);
		p.add(b[12]);
		p.add(b[13]);
		p.add(b[14]);
		add(p, BorderLayout.CENTER);
		
	}
	public void display() {
		setTitle("유치원 계산기");
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void eventProc() {
		for(int i=0; i<b.length; i++) {
			b[i].addActionListener(this);			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();
		for(int i=0; i<10; i++) {
			if(evt == b[i]) {
				String su = tf.getText();
				su += b[i].getText();
				tf.setText(su);
			}
			
		}
		if(evt == b[10]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}if(evt == b[12]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}if(evt == b[13]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}if(evt == b[14]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}
		if(evt == b[11]) {
			int second;
			int result;
			switch(op) {
			case "+" : 
				second = Integer.parseInt(tf.getText());
				result = prev + second;
				tf.setText(String.valueOf(result));
				break;
			case "*" : 
				second = Integer.parseInt(tf.getText());
				result = prev * second;
				tf.setText(String.valueOf(result));
				break;
			case "-" : 
				second = Integer.parseInt(tf.getText());
				result = prev - second;
				tf.setText(String.valueOf(result));
				break;
			case "/" : 
				second = Integer.parseInt(tf.getText());
				result = prev / second;
				tf.setText(String.valueOf(result));
				break;
				
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Self s = new Self();
		s.display();
		s.eventProc();
	}
}
