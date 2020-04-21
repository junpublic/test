package b_sample;

import javax.swing.*;
import java.awt.*;

public class Self extends JFrame {
	JTextField tf = null;
	JTextArea ta = null;
	JButton b = null;
	JLabel l = null;
	JCheckBox cb = null;
	JCheckBox cb2 = null;
	JList list = null;	
	
	public Self() {
		super("나의 창");
		tf = new JTextField("이름은 5글자 미만 입니다.");
		String [] data = {"rice", "kimch", "water"};
		list = new JList(data);
		b = new JButton("OK");
		
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		p.add(tf);
		p.add(list);
		add(p, BorderLayout.NORTH);
		
	}
	
	public void display() {
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		Self s = new Self();
		s.display();

	}

}
