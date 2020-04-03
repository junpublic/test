package y_kyochon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class Main extends JFrame implements ActionListener{
	public static String[] Chicken= {"교촌스틱","교촌순살","교촌오리지날","교촌허니스틱","교촌허니콤보","교촌허니오리지날","교촌레드스틱","교촌레드콤보","교촌레드오리지날"};
	public static int[] Price = {17000,18000,15000,18000,18000,15000,18000,18000,16000};
	public static ArrayList chicken = new ArrayList();
	public static ArrayList price = new ArrayList();
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
		shopB = new ShopB();
		
		JTabbedPane pane = new JTabbedPane();//창을 텝으로 만들어줌
		pane.add("교촌시리즈",original);
		pane.add("교촌허니시리즈",honey);
		pane.add("교촌레드시리즈",red);
		
		
		ShopB.addActionListener(this);
		add(pane);
		add(ShopB,BorderLayout.SOUTH);
		
		
//		static ArrayList arrayList;
		
		
		
		setSize(1000,1000);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "진짜 나가시겠습니까?");
				if(result == JOptionPane.OK_OPTION)
					System.exit(0);
				
			}
		});
	}
	public static void main(String[] args) {
		new  Main();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();
			
			shopB.setVisible(true);
		
	}
}
