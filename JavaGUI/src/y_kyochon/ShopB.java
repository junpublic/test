package y_kyochon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;




public class ShopB extends JFrame implements ActionListener{
	
	Main main;
	JButton cancle = new JButton("취소");
	JList list;
	
	static String[] OrderChicken;
	static int[] OrderPrice;
	ShopB(){
	JPanel p = new JPanel();
	list = new JList();
//	
//	for(int i=0;i<main.chicken.size();i++) {
//		
//		list.add(main.chicken.get(i));	
//		}
	p.setLayout(new GridLayout(1,2));
	p.add(list);
	p.add(cancle);
	
	add(p,BorderLayout.NORTH);
	setSize(500,500);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
