package y_kyochon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class Main extends JFrame implements ActionListener{
	Original original;
	Honey honey;
	Red red;
	JButton ShopB;
	ShopB shopB;
	Main(){
		original = new Original();
		honey = new Honey();
		red = new Red();
		ShopB = new JButton("장바구니");
		
		JTabbedPane pane = new JTabbedPane();//창을 텝으로 만들어줌
		pane.add("교촌시리즈",original);
		pane.add("교촌허니시리즈",honey);
		pane.add("교촌레드시리즈",red);
		
		ShopB.addActionListener(this);
		add(pane);
		add(ShopB,BorderLayout.SOUTH);
		
		
		
		
		
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new  Main();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();			
			shopB = new ShopB();		
		
	}
}
