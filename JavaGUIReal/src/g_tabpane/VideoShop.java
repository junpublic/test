package g_tabpane;
import javax.swing.*;
import java.awt.*;

public class VideoShop extends JFrame {
	
	VideoAdmin video;
	RentAdmin rent;
	CustomerAdmin customer;
	
	
	VideoShop(){//메모리에서 불려지는 것이 생성자 함수다.
		video = new VideoAdmin();
		rent = new RentAdmin();
		customer = new CustomerAdmin();
		
		setLayout(new BorderLayout());
		
		JTabbedPane pane = new JTabbedPane();
		pane.add("비디오관리", video);
		pane.add("대여관리", rent);
		pane.add("고객관리", customer);
		add(pane);
		
		setSize(700,500);//JFrame을 상속받아야 작동 됨 
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new VideoShop();// 이 class를 사용하기 위해 메모리에 올려놓기 위해 객체선언
		
		
	}

}

