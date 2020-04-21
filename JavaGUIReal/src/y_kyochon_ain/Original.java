package y_kyochon_ain;

import javax.swing.*;
import java.awt.*;

public class Original extends JPanel {
	JButton  Original1;//오리지날
	JButton  Original2;//교촌콤보
	JButton  Original3;//교촌스틱
	
	Original(){
		
		Original1 = new JButton(new ImageIcon("src/y_kyochon/imgs/o1.png"));
		Original2 = new JButton(new ImageIcon("src/y_kyochon/imgs/o2.png"));
		Original3 = new JButton(new ImageIcon("src/y_kyochon/imgs/o3.png"));
		
		Original1.setBackground(Color.white);
		Original2.setBackground(Color.white);
		Original3.setBackground(Color.white);
		
		setLayout(new GridLayout(1,3));
		add(Original1);
		add(Original2);
		add(Original3);
		
		
	}
}
