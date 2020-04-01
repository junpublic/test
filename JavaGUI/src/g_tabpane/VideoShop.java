package g_tabpane;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VideoShop extends JFrame{

	VdieoAdmin video;
	RentAdmin rent;
	CustomerAdmin customer;
	
	VideoShop(){
		video = new VdieoAdmin();
		rent = new RentAdmin();
		customer = new CustomerAdmin();
		
		JTabbedPane pane = new JTabbedPane();//창을 텝으로 만들어줌
		pane.add("비디오관리",video);
		pane.add("대여관리",rent);
		pane.add("고객관리",customer);
		
		add(pane);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new VideoShop();

	}

}
