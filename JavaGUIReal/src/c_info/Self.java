package c_info;

import javax.swing.*;
import java.awt.*;

public class Self extends JFrame {
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit; 
		
	
	public Self() {
		ta = new JTextArea();
		
		tfName = new JTextField(10);
		tfId = new JTextField(10);
		tfTel = new JTextField(10);
		tfSex = new JTextField(10);
		tfAge = new JTextField(10);
		tfHome = new JTextField(10);
		
		bAdd = new JButton("Add", new ImageIcon("src/c_info/imgs/image01.png"));
		bShow = new JButton("Show", new ImageIcon("src/c_info/imgs/image02.png"));
		bSearch = new JButton("Search", new ImageIcon("src/c_info/imgs/image03.png"));
		bDelete = new JButton("Delete", new ImageIcon("src/c_info/imgs/image04.png"));
		bCancel = new JButton("Cancel", new ImageIcon("src/c_info/imgs/image05.png"));
		bExit = new JButton("Exit", new ImageIcon("src/c_info/imgs/image06.png"));
		
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(6,1));
		p.add(new JLabel ("Name"));
		p.add(tfName);
		p.add(tfId);
		p.add(tfTel);
		p.add(tfSex);
		p.add(tfAge);
		p.add(tfHome);
		add(p, BorderLayout.WEST);
		add(ta, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,6));
		p2.add(bAdd);
		p2.add(bShow);
		p2.add(bSearch);
		p2.add(bDelete);
		p2.add(bCancel);
		p2.add(bExit);
		add(p2, BorderLayout.SOUTH);
	}
	public void display() {
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Self s = new Self();
		s.display();

	}

}
