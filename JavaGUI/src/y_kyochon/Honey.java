package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Honey extends JButton{
	JButton Honey_1,Honey_2,Honey_3;//오리지널 치킨 버튼
	
	Honey (){
		Honey_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H1.jpg"));
		Honey_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H2.jpg"));
		Honey_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H3.jpg"));
		Honey_1.setBackground(Color.WHITE);
		Honey_2.setBackground(Color.WHITE);
		Honey_3.setBackground(Color.WHITE);
		setLayout(new GridLayout(1,3));
		add(Honey_1);
		add(Honey_2);
		add(Honey_3);
	}

	
	
}
