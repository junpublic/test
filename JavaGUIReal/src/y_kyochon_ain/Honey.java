package y_kyochon_ain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Honey extends JPanel implements ActionListener{
	String [] menu = {"교촌허니스틱","교촌허니순살","교촌허니콤보"};
	int [] price = {18000,20000,18000};
	JButton[] honey = new JButton[menu.length];
	
//	JButton honey1;//허니순살
//	JButton honey2;//허니스틱
//	JButton honey3;//허니콤보

	
	Honey(){
		setLayout(new GridLayout(1,3));

		for(int i=0; i<honey.length; i++) {
			honey[i] = new JButton(new ImageIcon("src/y_kyochon/imgs/h" + (i+1) +".jpg"));
			honey[i].setBackground(Color.white);
			add(honey[i]);
		}
		
		eventProc();
		
//		honey[0] = new JButton();
//		honey[1] = new JButton();
//		honey[2] = new JButton();
		
//		honey[0] = new JButton(new ImageIcon("src/y_kyochon/imgs/h" +1+".jpg"));
//		honey[1] = new JButton(new ImageIcon("src/y_kyochon/imgs/h2.jpg"));
//		honey[2] = new JButton(new ImageIcon("src/y_kyochon/imgs/h3.jpg"));
		
		
//		honey[0].setBackground(Color.white);
//		honey[1].setBackground(Color.white);
//		honey[2].setBackground(Color.white);
//		
//		add(honey[0]);
//		add(honey[1]);
//		add(honey[2]);
		
		
	}
	public void eventProc() {
		for(int i=0; i<honey.length; i++) {
			honey[i].addActionListener(this);
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		for(int i=0; i<honey.length; i++) {
		if(evt == honey[i]) {
			int result = JOptionPane.showConfirmDialog(null, "장바구니에 담겠습니까?", "구매결정", JOptionPane.YES_NO_OPTION, 0, new ImageIcon("src/y_kyochon/imgs/logo.png"));
			if(result == JOptionPane.OK_OPTION) {
				ShoppingBasket.chicken.add(menu[i]);
				ShoppingBasket.pay.add(price[i]);
//				System.out.println(ShoppingBasket.chicken.get(i));
//				System.out.println(ShoppingBasket.pay.get(i));
				
				
			}
		}
		}
	}
}
