package a_datatype;

public class Ex02_Caution {

	public static void main(String[] args) {
		
		// (1) 문자형에 정수를 대입하면?
		char ch = 65;
		System.out.println("ch 값: "+  ch);
		// (2) 정수형에 문자를 대입하면?
		 int su = 'b';
		 System.out.println("su 값: "+ su);
		
		// (3) 실수형 float에 실수를 대입하면?
		 float f = 'f';
		 System.out.println("f 값: "+f);
		
		// (4) 실수형에 정수를 대입하면?
		 double d = 100;
		 System.out.println("d 값: " +d);
		
		// (5) 정수형에 실수를 대입하면?
		 int i = (int)3.6;
		 System.out.println("i 값: " +i);
		// (6) 정수형에 10억 숫자를  대입하면?
		 long a = 10000000000000L;
		 System.out.println("a 값: "+a);

	}

}
