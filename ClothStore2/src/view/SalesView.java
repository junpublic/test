package view;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

import view.graph.DayGraph;
import view.tab.DaySales;
import view.tab.MonthSales;
import view.tab.YearSales;
import view.tab.ProductSales;

public class SalesView extends JFrame {
	DaySales dS;
	MonthSales mS;
	YearSales yS;
	ProductSales pS;
	JTabbedPane  pane;


	public SalesView() {
	
		dS = new DaySales();
		mS = new MonthSales(dS,this);
		yS = new YearSales(mS,this);
		pS = new ProductSales();
		
		pane = new JTabbedPane();
		setLayout(new BorderLayout());
		pane.addTab("일매출" ,dS);
		pane.addTab("월매출",mS);
		pane.addTab("연매출",yS);
		pane.addTab("상품별매출",pS );

		pane.setSelectedIndex(0);

		
		add(pane);
		
		setSize(1000,800);
		
	}
	public void setPane(int n) {
		pane.setSelectedIndex(n);
	}


}


