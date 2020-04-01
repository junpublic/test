package d_cal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorTest extends JFrame implements ActionListener{
	//멤버 변수 선언
	JFrame a;
	JTextField tf;

	int prev;//이전값
	String op;//연산자
	
	JButton b_plus,b_equal,b_minus,b_mult,b_nanugi;
	JButton [] b = new JButton[10];
	//객체 생성
	public CalculatorTest() {
		a = new JFrame();
		tf = new JTextField(10);
		
		for(int i = 0; i<10;i++) {
			b[i] = new JButton(String.valueOf(i));
		}

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
			p.add(b_plus);
			p.add(b[0]);
			p.add(b_equal);			
			p.add(b_minus);
			p.add(b_mult);
			p.add(b_nanugi);
		a.add(p,BorderLayout.CENTER);	
		
		
		
		a.add(tf,BorderLayout.NORTH);
		
		a.setSize(300,300);
		a.setVisible(true);
	}

	//이벤트 등록
	public void eventProc() {
		for(int i=0;i<b.length;i++) {
			b[i].addActionListener(this);
		}
		b_plus.addActionListener(this);
		b_equal .addActionListener(this);
		b_minus.addActionListener(this);
		b_mult.addActionListener(this);
		b_nanugi.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();
		
		//숫자가 눌렸을 때
		for(int i=0;i<10;i++) {
			if(evt == b[i]) {
				String su = tf.getText();
				su += b[i].getText();
				tf.setText(su);
			}
		}
		if(evt ==b_plus) {
			prev = Integer.parseInt(tf.getText());//수를 가져옴
			tf.setText(null);//초기화
			op = evt.getText();
		}else if(evt == b_minus) {
			prev = Integer.parseInt(tf.getText());//수를 가져옴
			tf.setText(null);//초기화
			op = evt.getText();
		}else if(evt == b_mult) {
			prev = Integer.parseInt(tf.getText());//수를 가져옴
			tf.setText(null);//초기화
			op = evt.getText();
		}else if(evt ==b_nanugi) {
			prev = Integer.parseInt(tf.getText());//수를 가져옴
			tf.setText(null);//초기화
			op = evt.getText();
		}
		if(evt == b_equal) {
			int result=0;
			int second =0;
			switch(op) {
			case "+":
				second = Integer.parseInt(tf.getText());
				result = prev + second;
				tf.setText(String.valueOf(result));
				break;
			case "*":
				second = Integer.parseInt(tf.getText());
				result= prev * second;
				tf.setText(String.valueOf(result));
				break;
			case "/":
				second = Integer.parseInt(tf.getText());
				result = prev / second;
				tf.setText(String.valueOf(result));
				break;
			case "-":
				second = Integer.parseInt(tf.getText());
				result = prev - second;
				tf.setText(String.valueOf(result));
				break;
				
				
			}
		}
		
		
		
		
	}
	public static void main(String[] args) {
		CalculatorTest t = new CalculatorTest();
		t.display();
		t.eventProc();
	}

}
