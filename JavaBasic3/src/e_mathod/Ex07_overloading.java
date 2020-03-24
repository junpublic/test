package e_mathod;
/*오버로딩(overloading)
 * -인자의 자료형과 갯수가 다른 동일한 함수들
 * -리턴형만 다른 함수는 오버로딩이 아닙니다.
 * 
 */

public class Ex07_overloading {

	public static void main(String[] args) {
		//각각의 자료형 변수의 값에 "화이팅!!" 더하여 출력
		String str = new String("홍길순");
		StringBuffer sb = new StringBuffer("홍길자");
		char [] ch = new char[] {'홍','길','동'};
		
		fighting(str);//변수의 형태에 맞게 골라서 실행하는 것이 오버로딩이다.
		fighting(sb);
		fighting(ch);
		
	}
	static void fighting(char [] s) {
//		for(int i=0;i<s.length;i++) {
//			System.out.print(s[i]);
//		}
//		System.out.print("화이팅!!!!");
		String st = new String();
		for(int i=0;i<s.length;i++) {
			st+=s[i];
		}
		System.out.print(st+"화이팅!!!!");
	}
	
	static void fighting(StringBuffer s) {
		System.out.println(s.append("화이팅!!!!"));
	}
	static void fighting(String s) {
		System.out.println(s+"화이팅!!!!");
	}
}


//	2.
//
//	다음 아래의
//	method 메소드를오버로딩
//	한 메소드들은?
//
//long  method ( int a , int b ) {   return  a+b;   }
//
//	(1)
//
//	void method ( int x, int y )     {  return x+y;   }//인수가 같아서 안돔
//
//	(2)
//
//	long method ( long a, long b ) {  return a+b;   }//가능
//
//	(3)
//
//	long Method ( long a, long b ) {  return a+b;   }//다른함수임
//
//	(4)
//
//	long method ( int a, long b )  {  return a+b; }//가능