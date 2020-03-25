package b_encapsulation;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		CalculatorExpr expr = new CalculatorExpr();//만든 객체를 메모리에 올려야 사용할 수 있다.
		Scanner input = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		String a = "" ;
		do{
			
			System.out.println("숫자 2개 입력");
			int first = input.nextInt();
			int second = input.nextInt();
			//입력값을 멤버변수에 저장하기
			expr.setNum1(first);
			expr.setNum2(second);
			
			//사칙연산 메소드 호출하여서 출력
			System.out.println(first+"+"+second+"="+expr.getAddition());
			System.out.println(first+"-"+second+"="+expr.getSuvtraction());	
			System.out.println(first+"/"+second+"="+expr.getDivision());
			System.out.println(first+"*"+second+"="+expr.getMultiplication());
			System.out.println("계속 하시겠습니까? y or n?");
			a = input.next();
//			if(a=="y")
//				continue;
//			else if(a=="n")
//				break;
		}while(a.equals("y"));
	}

}
