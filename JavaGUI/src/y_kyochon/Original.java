package y_kyochon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import e_event.TestB;

public class Original  extends JButton implements ActionListener{
	JButton Original_1,Original_2,Original_3;//오리지널 치킨 버튼
	
	Original (){
		Original_1 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O1.PNG"));
		Original_2 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O2.PNG"));
		Original_3 = new JButton(new ImageIcon("C:\\Users\\KOSMO_29\\git\\test\\JavaGUI\\src\\igms\\O3.PNG"));
		Original_1.setBackground(Color.WHITE);
		Original_2.setBackground(Color.WHITE);
		Original_3.setBackground(Color.WHITE);
		eventProc();
		
		setLayout(new GridLayout(1,3));
		add(Original_1);
		add(Original_2);
		add(Original_3);
		
		
	}
	
	public void eventProc() {
		Original_1.addActionListener(this);
		Original_2.addActionListener(this);
		Original_3.addActionListener(this);
	}
	
	//추가할지 취소할지
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		if (b == Original_1) {
			int result = JOptionPane.showConfirmDialog(null, "교촌스틱을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {
				Main.chicken.add(Main.Chicken[0]);
				Main.price.add(Main.Price[0]);
			} 
		}
		if(b == Original_2) {
			int result = JOptionPane.showConfirmDialog(null, "교촌순살을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {

				Main.chicken.add(Main.Chicken[1]);
				Main.price.add(Main.Price[1]);
			} 
			
		}
		if(b == Original_3) {
			int result = JOptionPane.showConfirmDialog(null, "교촌오리지날을 장바구니에 담겠습니까?", "상품", JOptionPane.YES_NO_OPTION, 0);
			if (result == JOptionPane.YES_OPTION) {
				Main.chicken.add(Main.Chicken[2]);
				Main.price.add(Main.Price[2]);
			}
			
		}
	}
	
	
	
		
}

	
	

