package view;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.ClothStore;

import model.LoginModel;

public class LoginView extends JPanel {

	JTextField tfId;
	JTextField tfPw;
	ClothStore cs;
	JButton btnPw;
	LoginModel model;
	//모델단 변수 선언


	public JButton buttonget() {
		return btnPw;
	}





	public LoginView(){

		addLayout();
		connectDB();

	}
	void connectDB(){
		try {
			model = new LoginModel();
		} catch (Exception e) {
			System.out.println("로그인 드라이버 로딩 실패"+e.getMessage());
		}
	}

	public void joinLogin() {
		String id = tfId.getText();
		String pw= tfPw.getText();
		try {
			String temp=model.selectIdPw(id);
			if(pw.equals(temp)) {
				setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
			
		} catch (Exception e) {
			System.out.println("비밀번호 갖고 오기 실패"+e.getMessage());
		}
		
	}

	public void addLayout() {
		tfId = new JTextField(10);
		tfPw = new JTextField(10);

		btnPw = new JButton("LOGIN");


		JLabel logLb = new JLabel("로그인");
		JLabel idLb = new JLabel("ID");
		JLabel pwLb = new JLabel("PW");

		setLayout(null);

		logLb.setHorizontalAlignment(JLabel.CENTER); //logLb라벨 글자 가운데 정렬

		//글자크기 변경
		logLb.setFont(logLb.getFont().deriveFont(50.0f)); 
		idLb.setFont(idLb.getFont().deriveFont(30.0f));
		pwLb.setFont(pwLb.getFont().deriveFont(30.0f));


		logLb.setBounds(350, 50, 300, 160);
		idLb.setBounds(300, 150, 300, 160);
		tfId.setBounds(300, 250, 400, 50);
		pwLb.setBounds(300, 300, 300, 160);
		tfPw.setBounds(300, 400, 400, 50);

		btnPw.setBounds(400, 500, 200, 50);



		add(logLb);


		add(idLb);
		add(tfId);
		add(pwLb);
		add(tfPw);
		add(btnPw);





	}

}
