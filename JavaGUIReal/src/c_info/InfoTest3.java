package c_info;

import javax.swing.*;
import java.awt.*;//Layout 때문에 필요

public class InfoTest3 extends JFrame{
	
	// 1. 멤버변수 선언
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit; 
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	
	InfoTest3(){//생성자
		// 2. 객체 생성
		
		ta = new JTextArea();
		
		bAdd = new JButton("Add", new ImageIcon("src/c_info/imgs/image01.png"));
		bShow = new JButton("Show", new ImageIcon("src/c_info/imgs/image02.png"));
		bSearch = new JButton("Search", new ImageIcon("src/c_info/imgs/image03.png"));
		bDelete = new JButton("Delete", new ImageIcon("src/c_info/imgs/image04.png"));
		bCancel = new JButton("Cancel", new ImageIcon("src/c_info/imgs/image05.png"));
		bExit = new JButton("Exit", new ImageIcon("src/c_info/imgs/image06.png"));
		
		tfName = new JTextField(10);
		tfId = new JTextField(10);
		tfTel = new JTextField(10);
		tfSex = new JTextField(10);
		tfAge = new JTextField(10);
		tfHome = new JTextField(10);
		
		
		//붙이기
		
		setLayout(new BorderLayout());
		//WEST 영역
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(6,2));
		p2.add(new JLabel("Name", new ImageIcon("src/c_info/imgs/image07.png"), JLabel.CENTER));//한번만 쓸 변수는 바로 때려박자
		p2.add(tfName);
		p2.add(new JLabel("Id", JLabel.CENTER));
		p2.add(tfId);
		p2.add(new JLabel("Tel", JLabel.CENTER));
		p2.add(tfTel);
		p2.add(new JLabel("Sex", JLabel.CENTER));
		p2.add(tfSex);
		p2.add(new JLabel("Age", JLabel.CENTER));
		p2.add(tfAge);
		p2.add(new JLabel("Home", JLabel.CENTER));
		p2.add(tfHome);
		add(p2, BorderLayout.WEST);
		
		//CENTER 영역
		add(ta, BorderLayout.CENTER);
		
		//SOUTH 영역
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,6));
		p.add(bAdd);
		p.add(bShow);
		p.add(bSearch);
		p.add(bDelete);
		p.add(bCancel);
		p.add(bExit);
		add(p, BorderLayout.SOUTH);
		
		
	}
	
	void dispay(){
		// 3. 화면 구성 및 출력
		
		setLocation(200, 100);
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		
		InfoTest3 t = new InfoTest3();
		t.dispay();

	}

}
