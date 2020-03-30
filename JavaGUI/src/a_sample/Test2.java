package a_sample;

import java.awt.Button;
import java.awt.Frame;

//is-a 방식

public class Test2 extends Frame{
	//멤버변수 선언
	Button b;
	public Test2() {
		super("나의 창2");//부모의 기본생성자 함수 불려짐 ,바꾸고 싶으면 이렇게 바꾸면됨 , 첫번째 라인에 와야됨
		
		//객체 생성
		b = new Button("OK2");
		//붙이기
		add(b);
		//화면 출력
		setSize(500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		Test2 t = new Test2();

	}

}
