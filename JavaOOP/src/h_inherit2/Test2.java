package h_inherit2;

import java.awt.Frame;
//is-a : Myframe2 is a Frame
class MyFrame2 extends Frame{//부모가 가지고 있는 메소드를 사용하고 싶을때 사용한다.
	MyFrame2(){
		
//		super("나의 두번쨰 화면");
		setSize(500,300);
		setVisible(true);
	}
	void min() {//부모꺼에 내가 원하는게 없으면 추가한다.
		
	}
}
public class Test2 {

	public static void main(String[] args) {
		new MyFrame2();

	}

}
