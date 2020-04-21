package y_kyochon_ain;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;



public class Main extends JFrame implements ActionListener {
	//멤버선언
	Honey honey;
	Original original;
	Red red;
	JButton shopb;
	ShoppingBasket sb;	

	Main(){
		// 객체생성
		honey = new Honey();
		original = new Original();
		red = new Red();
		shopb = new JButton("장바구니");
		sb = new ShoppingBasket();

		// 화면구성
		JTabbedPane jt = new JTabbedPane();
		jt.add("교촌시리즈", original);
		jt.add("교촌허니시리즈", honey);
		jt.add("교촌레드시리즈", red);
		add(jt);
		add(shopb, BorderLayout.SOUTH);

		// 화면출력
		setTitle("교촌치킨");
		setSize(1000,500);
		setVisible(true);
		setLocation(200,250);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	// 이벤트 연결, 이벤트 객체 생성
	public void eventProc() {
		shopb.addActionListener(this);



		// 장바구니창만 종료하게함
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, 1, new ImageIcon("src/y_kyochon/imgs/logo.png"));
//				int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if(result == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}

		});

	}

	// 이벤트 핸들러
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		if(evt == shopb) {
			sb.setVisible(true);
		}
	}





	//객체선언
	public static void main(String[] args) {
		Main m = new Main();
		m.eventProc();

	}


}
