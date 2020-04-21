package y_kyochon_ain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShoppingBasket extends JFrame{
//	String [] menu = {"교촌허니스틱","교촌허니순살","교촌허니콤보","교촌레드스틱","교촌레드콤보","교촌레드오리지날","교촌오리지날","교촌콤보","교촌스틱"};
//	int [] price = {18000,20000,18000,18000,18000,16000,15000,17000,17000};
	public static ArrayList<String> chicken = new ArrayList<String>();
	public static ArrayList<Integer> pay = new ArrayList<Integer>();
	JList list;
	JTextField tf;
	JButton delete;


	ShoppingBasket(){
		tf = new JTextField(10);
		tf.setText(String.valueOf(pay));
		list = new JList(chicken.toArray());
		
		
		delete = new JButton("삭제");
		//list = new JList(pay.toArray());



		
		JPanel TotalP = new JPanel();
		TotalP.add(tf);
		TotalP.add(new JLabel("총합 금액"));
		add(TotalP, BorderLayout.CENTER);
		JPanel basketP = new JPanel(); 
		basketP.setLayout(new GridLayout(1,2));
		//basketP.add(list);
		basketP.add(list);
		basketP.add(delete);
		add(basketP, BorderLayout.NORTH);
		
		
		setTitle("교촌치킨 / 장바구니");
		setSize(500,500);
		//setVisible(true);//
		setLocation(1200,250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
