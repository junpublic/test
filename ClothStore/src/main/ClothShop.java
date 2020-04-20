package main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.productView;
import view.sellView;

public class ClothShop extends JFrame{
	
	sellView sell;
	productView product;
	public ClothShop() {
		sell = new sellView();
		product = new productView();
		add(sell);
		add(product);
		
		setSize(800,600);
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	public static void main(String[] args) {
		new ClothShop();
	}

}
