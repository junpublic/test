package a_sample;




import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

//is-a 방식

public class Test2 extends JFrame{
	//멤버변수 선언
	//남자 라디오 버튼/여자 라디오 버튼
	//성인 라디오 버튼/미성년 라디오 버튼
	//
	JRadioButton man,woman,old,young;

	public Test2() {
		super("나의 창2");//부모의 기본생성자 함수 불려짐 ,바꾸고 싶으면 이렇게 바꾸면됨 , 첫번째 라인에 와야됨
		
		//객체 생성

		man = new JRadioButton("man",true);
		woman = new JRadioButton("woman");
		old = new JRadioButton("old");
		young = new JRadioButton("young",true);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(man);
		bg1.add(woman);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(old);
		bg2.add(young);
		//붙이기
		setLayout(new FlowLayout());

		add(man);
		add(woman);
		add(old);
		add(young);
		
		//화면 출력
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Test2 t = new Test2();

	}

}
