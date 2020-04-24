package view;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;

public class StaffView extends JFrame {

	JTabbedPane  pane;
	Worktimeview wtv;
	StaffManageView smv;

	public StaffView() {
		
		wtv = new Worktimeview();
		smv = new StaffManageView();
		
		pane = new JTabbedPane();
		setLayout(new BorderLayout());
		pane.addTab("출근관리" ,wtv);
		pane.addTab("직원관리",smv);
		

		pane.setSelectedIndex(0);

		
		add(pane);
		
		setSize(1000,800);
		
	}

}
