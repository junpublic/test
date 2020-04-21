package y_kyochon_ain;

import javax.swing.*;
import java.awt.*;

public class Red extends JPanel {
	JButton red1;//레드스틱
	JButton red2;//레드콤보
	JButton red3;//레드오리지날
	
	Red(){
		
		red1 = new JButton(new ImageIcon("src/y_kyochon/imgs/r1.png"));
		red2 = new JButton(new ImageIcon("src/y_kyochon/imgs/r2.png"));
		red3 = new JButton(new ImageIcon("src/y_kyochon/imgs/r3.png"));
		
		red1.setBackground(Color.white);
		red2.setBackground(Color.white);
		red3.setBackground(Color.white);
		
		setLayout(new GridLayout(1,3));
		add(red1);
		add(red2);
		add(red3);
		
		
	}
	
}
