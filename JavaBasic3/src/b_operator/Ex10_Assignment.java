package b_operator;

/*
 *  연산자와 대입연산자를 합치기
 *  	- 산술, 이진논리, 쉬프트
 */
public class Ex10_Assignment {

	public static void main(String[] args) {
		
		int  a = 10;
		int  b = 7;

		a+= b;//17
		System.out.println("+= 결과 : " + a );
		a-= b;//10
		System.out.println("-= 결과 : " + a );
		a*= b;//70
		System.out.println("*= 결과 : " + a );
		a/= b;//10
		System.out.println("/= 결과 : " + a );
		a%= b;//3
		System.out.println("%= 결과 : " + a );
	
	}
}
