package a_sample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//is-a 방식

public class Test2 extends JFrame {
	//멤버변수 선언
	// 남자 라디오버튼 / 여자 라디오버튼
	// 성인 라디오버튼 / 미성년 라디오버튼
	JRadioButton rb_male = new JRadioButton("남자", true);// 선언시 외부적인 영향을 받지 않을 경우 변수와 객체를 함께 선언해도 된다.
	JRadioButton rb_female = new JRadioButton("여자", true);
	JRadioButton rb_adult = new JRadioButton("성인");
	JRadioButton rb_child = new JRadioButton("미성년", true);
	
	public Test2() {
		super("나의 창2");//부모의 생성자함수의 인자를 불러오고 내가 원하는 내용으로 바꾸자, 1번째 줄에 써야함
		
		//객체 생성
			
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rb_male);
		bg1.add(rb_female);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rb_adult);
		bg2.add(rb_child);
		
		
		//붙이기
		setLayout(new FlowLayout());
		add(rb_male);
		add(rb_female);
		add(rb_adult);
		add(rb_child);
		
		
		//화면 출력
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame안에 
	}
	
	public static void main(String[] args) {
		
		Test2 t = new Test2();

	}

}
