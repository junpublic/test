package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Honey extends JButton implements ActionListener{
	JButton Honey_1,Honey_2,Honey_3;//오리지널 치킨 버튼
	
	Honey (){
		Honey_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H1.jpg"));
		Honey_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H2.jpg"));
		Honey_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\H3.jpg"));
		
		Honey_1.setBackground(Color.WHITE);
		Honey_2.setBackground(Color.WHITE);
		Honey_3.setBackground(Color.WHITE);
		eventProc();
		setLayout(new GridLayout(1,3));
		
		add(Honey_1);
		add(Honey_2);
		add(Honey_3);
	}

	public void eventProc() {
		Honey_1.addActionListener(this);
		Honey_2.addActionListener(this);
		Honey_3.addActionListener(this);
	}
	
public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		if (b == Honey_1) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드스틱을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {

			} else if (result == JOptionPane.NO_OPTION) {

			}
		}
		if(b == Honey_2) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드콤보을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {

			} else if (result == JOptionPane.NO_OPTION) {

			}
			
		}
		if(b == Honey_3) {
			int result = JOptionPane.showConfirmDialog(null, "교촌레드오리지날을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {

			} else if (result == JOptionPane.NO_OPTION) {

			}
			
		}
	}


	
	
}
