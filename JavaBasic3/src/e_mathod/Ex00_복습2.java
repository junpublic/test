package e_mathod;

import java.util.Scanner;

public class Ex00_복습2 {
	static int jumsu;

	public static void main(String[] args) {
		String result = func();
		// 여기서 합격 여부를 출력하려면?
		System.out.println("결과:"+result);
		System.out.println(method());
	}

	/** 
	 * method1
	 *  	- 점수를 입력받아 합격여부 확인하는 메소드
	 */
	static  String func() {
		Scanner in = new Scanner(System.in);		
		 jumsu = in.nextInt();
		if( jumsu >= 80) return "합격";
		else return "불합격";
	}
	
	/**
	 * 점수를 넘겨받아 성적을 구하는 메소드
	 */
	static char method() {
	
		if(jumsu>=90) {
			return 'A';
		}else if(jumsu>=80) {
			return 'B';
		}else if(jumsu>=80) {
			return 'C';
		}else {
			return 'F';
		}
			
	}

}
