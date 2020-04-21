package d_cal;

import java.awt.*;
import javax.swing.*;

public class CalculatorTest2 extends JFrame{
	// 1. 멤버 선언 위치
	JTextField tf = null;
	JButton bp, be, bm, bmt, bsh;
	JButton [] b = new JButton[10];
	
	// 2. 객체 생성
	public CalculatorTest2(){
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
		
		bp = new JButton("+");
		be = new JButton("=");
		bm = new JButton("-");
		bmt = new JButton("*");
		bsh = new JButton("/");
		
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
		p.add(bp);
		p.add(b[0]);
		p.add(be);
		p.add(bm);
		p.add(bmt);
		p.add(bsh);
		add(p, BorderLayout.CENTER);
		
	}
	// 3. 화면 구성 및 출력하기
	public void dispaly() {
		setTitle("유치원 계산기");
		setSize(500, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		CalculatorTest2 t = new CalculatorTest2();
		t.dispaly();

	}

}
