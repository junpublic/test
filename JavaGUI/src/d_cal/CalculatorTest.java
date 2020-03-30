package d_cal;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorTest extends JFrame{
	//멤버 변수 선언
	JFrame a;
	JTextField tf;
//	JButton b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_0;
	
	JButton b_plus,b_equal,b_minus,b_mult,b_nanugi;
	JButton [] b = new JButton[10];
	//객체 생성
	public CalculatorTest() {
		a = new JFrame();
		tf = new JTextField(10);
		
		for(int i = 0; i<10;i++) {
			b[i] = new JButton(String.valueOf(i));
		}
//		b_1 = new JButton("1");
//		b_2 = new JButton("2");
//		b_3 = new JButton("3");
//		b_4 = new JButton("4");
//		b_5 = new JButton("5");
//		b_6 = new JButton("6");
//		b_7 = new JButton("7");
//		b_8 = new JButton("8");
//		b_9 = new JButton("9");
//		b_0 = new JButton("0");
		b_plus = new JButton("+");
		b_equal = new JButton("=");
		b_minus = new JButton("-");
		b_mult = new JButton("*");
		b_nanugi = new JButton("/");
		
		
	}
	
	
	//화면구성 및 출력하기
	public void display() {
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(5,3));
			for(int i = 1;i<10;i++) {
				p.add(b[i]);
			}
//			p.add(b_1);
//			p.add(b_2);
//			p.add(b_3);
//			p.add(b_4);
//			p.add(b_5);
//			p.add(b_6);
//			p.add(b_7);			
//			p.add(b_8);
//			p.add(b_9);
			p.add(b_plus);
			p.add(b[0]);
			p.add(b_equal);			
			p.add(b_minus);
			p.add(b_mult);
			p.add(b_nanugi);
		a.add(p,BorderLayout.CENTER);	
		
		
		
		a.add(tf,BorderLayout.NORTH);
		
		a.setSize(500,400);
		a.setVisible(true);
	}
	public static void main(String[] args) {
		CalculatorTest t = new CalculatorTest();
		t.display();
	}

}
