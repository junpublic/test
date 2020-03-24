package b_operator;

/**
 * 증가(++)/감소(--) 연산자
 */
public class Ex01_IncDec {

	public static void main(String[] args) {

		int a = 5;
		int b = 7;
		
		// [4]
		System.out.println("a="+ ++a + " b= "+ --b);//a = 6,b=6
		System.out.println("a="+ a++ + " b= "+ b--);//a=6,b=6
		System.out.println("a="+ a + " b= "+ b);//a=7 , b=5
		
//		
		
//		// [3] 증가감소연산자는 위치가 중요하다
//				int result = a++;
//				System.out.println("결과: "+result);
//				
//				int result2 = ++a;
//				System.out.println("결과: "+result2);
		// [1]
//		System.out.println("a= " + a + ",b= " + b);
//		System.out.println("a= " + (a + 1) + ",b= " + (b + 1));

		// [2]
//		b= ++a;
//		c=a++;
//		System.out.println("a="+(a));
//		System.out.println("++a="+(b));
//		System.out.println("a++="+(c));
//		
		

	}

}
