package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Red extends JButton{
	JButton Red_1,Red_2,Red_3;//오리지널 치킨 버튼
	
	Red  (){
		Red_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R1.png"));
		Red_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R2.png"));
		Red_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R3.png"));
		Red_1.setBackground(Color.WHITE);
		Red_2.setBackground(Color.WHITE);
		Red_3.setBackground(Color.WHITE);
		setLayout(new GridLayout(1,3));
		add(Red_1);
		add(Red_2);
		add(Red_3);
	}

	
	
	
}
