package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Red extends JButton implements ActionListener{
	JButton Red_1,Red_2,Red_3;//오리지널 치킨 버튼
	
	Red  (){
		Red_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R1.png"));
		Red_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R2.png"));
		Red_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\R3.png"));
		Red_1.setBackground(Color.WHITE);
		Red_2.setBackground(Color.WHITE);
		Red_3.setBackground(Color.WHITE);
		eventProc();
		setLayout(new GridLayout(1,3));
		add(Red_1);
		add(Red_2);
		add(Red_3);
	}
	public void eventProc() {
		Red_1.addActionListener(this);
		Red_2.addActionListener(this);
		Red_3.addActionListener(this);
	}
	
public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		if (b == Red_1) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드스틱을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {
				Main.chicken.add(Main.Chicken[6]);
				Main.price.add(Main.Price[6]);
			} else if (result == JOptionPane.NO_OPTION) {

			}
		}
		if(b == Red_2) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드콤보을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {
				Main.chicken.add(Main.Chicken[7]);
				Main.price.add(Main.Price[7]);
			} else if (result == JOptionPane.NO_OPTION) {

			}
			
		}
		if(b == Red_3) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드오리지날을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {
				Main.chicken.add(Main.Chicken[8]);
				Main.price.add(Main.Price[8]);
			} else if (result == JOptionPane.NO_OPTION) {

			}
			
		}
	}

	
	
	
}
