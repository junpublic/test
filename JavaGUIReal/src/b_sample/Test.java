package b_sample;

// AWT -> Swing

import java.awt.*;
import javax.swing.*;//Layout을 제외하고 화면에 관련된 모든 것에 J 붙이기

public class Test {
	
	// 멤버변수 선언
	JFrame f;// == Frame f = null; 클래스에는 null값이 들어있다.
	JButton b;//
	JLabel l;//단순글씨
	JTextField tf;
	JTextArea ta;
	JCheckBox cb, cb2;
	JList li;
	
	public Test() {//생성자 함수 디폴트로 원래 자동으로 만들어짐
		//객체 생성
		f = new JFrame("나의 창");
		b = new JButton("OK");
		l = new JLabel("NAME");
		tf = new JTextField("이름은 5자 미만입니다", 40);//TextField(String text, int columns) 텍스트와 텍스트가 들어가는 크기를 설정 가능
		ta = new JTextArea();
		cb = new JCheckBox("man", true);
		cb2 = new JCheckBox("woman");
		String [] data = {"rice", "curry", "kimchi", "soup", "water", "pickle"};
		li = new JList(data);
	
		
		//붙이기
		//Layout : 붙이는 방식
		//f.setLayout(new FlowLayout());//FlowLayout : 단락의 텍스트 줄처럼 구성 요소를 방향 흐름으로 배열
		//f.setLayout(new GridLayout(4,2));//
		f.setLayout(new BorderLayout());//
			JPanel p2 = new JPanel(new GridLayout(1,2));
			p2.add(tf);
			p2.add(li);
		f.add(p2, BorderLayout.NORTH);
		f.add(b, BorderLayout.WEST);
		f.add(l, BorderLayout.EAST);
		
		f.add(ta, BorderLayout.CENTER);
			JPanel p = new JPanel();
			//p.setLayout(new GridLayout(2,1));
			p.add(cb);
			p.add(cb2);
		f.add(p, BorderLayout.SOUTH);
		
		//f.add(li);
		
		//화면 출력
		f.setSize(500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//화면을 나갔을 때 모든 걸 종료
		
	}//다시 21라인으로 돌아감

	public static void main(String[] args) {
		Test t = new Test();//이 class Test를 사용하기 위해 메모리에 올려놓음 - 10라인으로 들어감
		
	}

}
