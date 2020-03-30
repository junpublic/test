package c_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class InfoText extends JFrame{
	//1.멤버변수 선언
	
	JTextArea ta;
	JButton bAdd,bShow,bSearch,bDelete,bExit,bCancel;
	JTextField tfName,tfId,tfTel,tfSex,tfAge,tfHome;
	InfoText(){
		//2.객체 생성
		
		ta = new JTextArea();
		bAdd = new JButton("Add",new ImageIcon("src/c_info/imgs/1.PNG"));
		bAdd.setVerticalTextPosition(JButton.BOTTOM);
		bAdd.setHorizontalTextPosition(JButton.CENTER);
		bAdd.setPressedIcon(new ImageIcon("src/c_info/imgs/3.PNG"));
		bAdd.setRolloverIcon(new ImageIcon("src/c_info/imgs/4.PNG"));
		bAdd.setToolTipText("사용자 정보를 입력합니다");
		bAdd.setMnemonic('i');//alt + i
		
		
		bShow= new JButton("Show",new ImageIcon("src/c_info/imgs/2.PNG"));
		bSearch= new JButton("Search",new ImageIcon("src/c_info/imgs/3.PNG"));
		bDelete= new JButton("Delete",new ImageIcon("src/c_info/imgs/4.PNG"));
		bExit= new JButton("Exit",new ImageIcon("src/c_info/imgs/5.PNG"));
		bCancel= new JButton("Cancel",new ImageIcon("src/c_info/imgs/6.PNG"));
		
		tfName = new JTextField(10);
		tfId= new JTextField(10);
		tfTel= new JTextField(10);
		tfSex= new JTextField(10);
		tfAge= new JTextField(10);
		tfHome= new JTextField(10);
	}
	void display(){
		//3.화면 구성 및 출력
		//왼쪽
		JPanel l = new JPanel();
			l.setLayout(new GridLayout(6,2));
			l.add(new JLabel("Name",new ImageIcon("src/c_info/imgs/7.PNG"),JLabel.CENTER));
			l.add(tfName);
			l.add(new JLabel("ID",new ImageIcon("src/c_info/imgs/8.PNG"),JLabel.CENTER));
			l.add(tfId);
			l.add(new JLabel("Tel",new ImageIcon("src/c_info/imgs/9.PNG"),JLabel.CENTER));
			l.add(tfTel);
			l.add(new JLabel("Sex",new ImageIcon("src/c_info/imgs/10.PNG"),JLabel.CENTER));
			l.add(tfSex);
			l.add(new JLabel("Age",new ImageIcon("src/c_info/imgs/1.PNG"),JLabel.CENTER));
			l.add(tfAge);
			l.add(new JLabel("Home",new ImageIcon("src/c_info/imgs/2.PNG"),JLabel.CENTER));
			l.add(tfHome);
		

		
		
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(1,6));
			p.add(bAdd);
			p.add(bShow);
			p.add(bSearch);
			p.add(bCancel);
			p.add(bDelete);
			p.add(bExit);
		
		
		add(ta,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		add(l,BorderLayout.WEST);
		
		setLocation(200,100);
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	public static void main(String[] args) {
		InfoText t = new InfoText();
		t.display();//함수 부르기

	}

}
