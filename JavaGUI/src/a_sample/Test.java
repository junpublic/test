package a_sample;

import java.awt.*;

//--------------- has-a 방식
public class Test {

	//멤버변수 선언
	Frame f;
	Button b;//
	Label l;
	TextField tf;
	TextArea ta;
	Checkbox man,wman;
	List li;
	public Test() {// 생성하면 자동으로 생기는 함수 그냥 한번 만들어줬음
		//객체 생성
		f = new Frame("나의 창");
		b = new Button("ok");
		l = new Label("Hello");
		tf = new TextField("이름은 5자 미만입니다",40);
		ta = new TextArea("Hello", 5, 40);
		man = new Checkbox("man",true);
		wman = new Checkbox("woman",false);
		li = new List();
		li.add("rice");
		li.add("soup");
		//붙이기 //화면에 원하는걸 넣으려면 띄우기 전에 다 만들거 넣어야 한다.
		//붙이는 방식 Layout
//		f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(4,2));
		f.setLayout(new BorderLayout());
		
		
		f.add(b,BorderLayout.WEST);
		f.add(l,BorderLayout.EAST);
		f.add(tf,BorderLayout.NORTH);
		f.add(ta,BorderLayout.CENTER);//한 영역에 하나밖에 못 붙인다.
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(2,1));
		p.add(man);
		p.add(wman);
		f.add(p,BorderLayout.SOUTH);
		f.add(li);
		//화면출력
		f.setSize(500,400);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
		

	}

}
