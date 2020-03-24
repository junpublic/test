package e_mathod;

public class Ex04_변수의범위 {
	// 멤버변수 // 이렇게 선언하는 것을 멤버변수라고 한다.
	static int a, b;// 이렇게 메인 밖에다 변수를 선언하면 밑에 전부 사용가능하다.static에서 쓰므로 static도 선언
	static int sum;//스택이 아닌 곳에 변수생김

	public static void main(String[] args) {//함수 안에 선언된 것들은 지역변수라고 한다.
		//스택에 변수가 생김
		
		 a = 10;
		b = 20;

//		int a = 10, b = 20;
//
//		add(a, b);

		add(a, b);
		System.out.println("합:" + sum);

	}

	static void add(int a, int b) {
		sum = a + b;//0이 나오는 이유는 나가는 순간 0으로 초기화 된다.

	}

}
