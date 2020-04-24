package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;
import view.MainView;
import view.SalesView;





public class ClothStore extends JFrame{
	MainView mainview;
	LoginView login;
	SalesView sales;




	public ClothStore() {

		login = new LoginView();
		mainview = new MainView();
		sales = new SalesView();
		
		eventproc();



		add(login);
		//add(sales);
		//화면크기지정
		setSize(1000,800);



		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void eventproc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();

		login.buttonget().addActionListener(btnHandler);
	}



	// 이벤트 등록

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==login.buttonget()){  					
					login.joinLogin();
					add(mainview);
			}

		}
	}



	public static void main(String[] args) {
		new ClothStore();


	}

}
