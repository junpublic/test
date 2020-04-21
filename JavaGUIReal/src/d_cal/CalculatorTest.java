package d_cal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CalculatorTest extends JFrame implements ActionListener{
	// 1. 멤버 선언 위치
	JTextField tf = null;
	JButton [] b = new JButton[15];
	int prev;	// 이전값을 저장	
	String op;	// 연산자를 저장
	
	// 2. 객체 생성
	public CalculatorTest(){
		super("유치원 계산기");
		tf = new JTextField(10);
		for(int i=0; i<10; i++) {
			b[i] = new JButton(String.valueOf(i));
		}
//		b0 = new JButton("0");
//		b1 = new JButton("1");
//		b2 = new JButton("2");
//		b3 = new JButton("3");
//		b4 = new JButton("4");
//		b5 = new JButton("5");
//		b6 = new JButton("6");
//		b7 = new JButton("7");
//		b8 = new JButton("8");
//		b9 = new JButton("9");

		b[10] = new JButton("+");
		b[11] = new JButton("=");
		b[12] = new JButton("-");
		b[13] = new JButton("*");
		b[14] = new JButton("/");
		
		setLayout(new BorderLayout());
		//NORTH 영역
		add(tf, BorderLayout.NORTH);
		//CENTER 영역
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,3));
		for(int i=1; i<10; i++) {
			p.add(b[i]);
		}
//		p.add(b1);
//		p.add(b2);
//		p.add(b3);
//		p.add(b4);
//		p.add(b5);
//		p.add(b6);
//		p.add(b7);
//		p.add(b8);
//		p.add(b9);
		p.add(b[10]);
		p.add(b[0]);
		p.add(b[11]);
		p.add(b[12]);
		p.add(b[13]);
		p.add(b[14]);
		add(p, BorderLayout.CENTER);
		
	}
	// 3. 화면 구성 및 출력하기
	public void dispaly() {
		setSize(500, 700);
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
		// 숫자가 눌렸을 때
		for(int i=0; i<10; i++) {
			if(evt ==b[i]) {
				String su = tf.getText();
				su += b[i].getText();
				tf.setText(su);
			}
		}
		// 연산자가 눌렸을 때
		if(evt == b[10]) {
		prev = Integer.parseInt(tf.getText());
		tf.setText(null);
		op = evt.getText();
		}else if(evt == b[12]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();	
		}else if(evt == b[13]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}else if(evt == b[14]) {
			prev = Integer.parseInt(tf.getText());
			tf.setText(null);
			op = evt.getText();
		}
		// '='버튼이 눌렸을 때
		if(evt ==b[11]) {
			int second;
			int result;
			switch(op) {
			case "+" : 
				second = Integer.parseInt(tf.getText());
				result = prev + second;
				tf.setText(String.valueOf(result));
				break;
			case "-" : 
				second = Integer.parseInt(tf.getText());
				result = prev - second;
				tf.setText(String.valueOf(result));
				break;
			case "*" : 
				second = Integer.parseInt(tf.getText());
				result = prev * second;
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
		CalculatorTest t = new CalculatorTest();
		t.dispaly();
		t.eventProc();
	}

}
