package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Original  extends JButton{
	JButton Original_1,Original_2,Original_3;//오리지널 치킨 버튼
	
	Original (){
		Original_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O1.PNG"));
		Original_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O2.PNG"));
		Original_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O3.PNG"));
		Original_1.setBackground(Color.WHITE);
		Original_2.setBackground(Color.WHITE);
		Original_3.setBackground(Color.WHITE);
		setLayout(new GridLayout(1,3));
		add(Original_1);
		add(Original_2);
		add(Original_3);
	}

	
	
}
