package a_sample;

import java.awt.*;
//--------------------------------has-a 방식: 객체를 생성해서 사용
public class Test {
	
	// 멤버변수 선언
	Frame f;// == Frame f = null; 클래스에는 null값이 들어있다.
	Button b;//
	Label l;//단순글씨
	TextField tf;
	TextArea ta;
	Checkbox cb, cb2;
	List li;
	
	public Test() {//생성자 함수 디폴트로 원래 자동으로 만들어짐
		//객체 생성
		f = new Frame("나의 창");
		b = new Button("OK");
		l = new Label("NAME");
		tf = new TextField("이름은 5자 미만입니다", 40);//TextField(String text, int columns) 텍스트와 텍스트가 들어가는 크기를 설정 가능
		ta = new TextArea();
		cb = new Checkbox("man", true);
		cb2 = new Checkbox("woman");  
		li = new List();
		li.add("rice");
		li.add("curry");
		li.add("kimchi");
		li.add("soup");
		li.add("water");
		
		//붙이기
		//Layout : 붙이는 방식
		//f.setLayout(new FlowLayout());//FlowLayout : 단락의 텍스트 줄처럼 구성 요소를 방향 흐름으로 배열
		//f.setLayout(new GridLayout(4,2));//FlowLayout : 단락의 텍스트 줄처럼 구성 요소를 방향 흐름으로 배열
		f.setLayout(new BorderLayout());//FlowLayout : 단락의 텍스트 줄처럼 구성 요소를 방향 흐름으로 배열
		f.add(b, BorderLayout.WEST);
		f.add(l, BorderLayout.EAST);
		f.add(tf, BorderLayout.NORTH);
		f.add(ta, BorderLayout.CENTER);
			Panel p = new Panel();
			//p.setLayout(new GridLayout(2,1));
			p.add(cb);
			p.add(cb2);
		f.add(p, BorderLayout.SOUTH);
		
		//f.add(li);
		
		//화면 출력
		f.setSize(500, 400);
		f.setVisible(true);
		
	}//다시 21라인으로 돌아감

	public static void main(String[] args) {
		Test t = new Test();//이 class Test를 사용하기 위해 메모리에 올려놓음 - 10라인으로 들어감
		
	}

}
