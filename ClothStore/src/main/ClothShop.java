package main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.sellView;

public class ClothShop extends JFrame{
	
	sellView sell;
	public ClothShop() {
		sell = new sellView();
		add(sell);
		
		setSize(800,600);
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	public static void main(String[] args) {
		new ClothShop();
	}

}
