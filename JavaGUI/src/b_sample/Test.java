package b_sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//--------------- has-a 방식
public class Test {

	//멤버변수 선언
	JFrame f;
	JButton b;//
	JLabel l;
	JTextField tf;
	JTextArea ta;
	JCheckBox man,wman;
	JList li;
	public Test() {// 생성하면 자동으로 생기는 함수 그냥 한번 만들어줬음
		//객체 생성
		f = new JFrame("나의 창");
		b = new JButton("ok");
		l = new JLabel("Hello");
		tf = new JTextField("이름은 5자 미만입니다",40);
		ta = new JTextArea("Hello", 5, 40);
		man = new JCheckBox("man",true);
		wman = new JCheckBox("woman",false);
		
		String []  data = {"rice","soup"};
		li = new JList(data);

		//붙이기 //화면에 원하는걸 넣으려면 띄우기 전에 다 만들거 넣어야 한다.
		//붙이는 방식 Layout
//		f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(4,2));
		f.setLayout(new BorderLayout());
		
		
		f.add(b,BorderLayout.WEST);
		f.add(l,BorderLayout.EAST);
//		f.add(tf,BorderLayout.NORTH);
		f.add(ta,BorderLayout.CENTER);//한 영역에 하나밖에 못 붙인다.
		
		JPanel up = new JPanel();
			up.setLayout(new GridLayout(1,2));
			up.add(tf);
			up.add(li);
		f.add(up,BorderLayout.NORTH);
		
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(2,1));
			p.add(man);
			p.add(wman);
		f.add(p,BorderLayout.SOUTH);
//		f.add(li);
		//화면출력
		f.setSize(500,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
		

	}

}
