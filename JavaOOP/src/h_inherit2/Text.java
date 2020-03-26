package h_inherit2;

import java.awt.*;
//has-a 관계라고함 :MyFrame1 has a Frame
class MyFrame1{
	Frame f;
	MyFrame1(){
		f = new Frame("나의 첫 화면");
		f.setSize(500,300);//사이즈
		f.setVisible(true);//화면에 띄울레?
		
	}
}
public class Text {
	
	public static void main(String[] args) {
		new MyFrame1();
	}
	
}