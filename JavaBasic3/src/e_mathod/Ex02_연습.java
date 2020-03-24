package e_mathod;

import java.util.Scanner;

public class Ex02_연습 {
	
	public static void main(String[] args) {
//		(문제 1) 영문자를 입력하여 이 문자가 소문자이면 true을 반환 그렇지 않으면 false을 반환하는 메소드를 작성하시오.
//		  함수명 : checkLower
//		  인자 : char
//		  리턴(반환) : boolean
		Scanner input = new Scanner(System.in);
		char ch = input.next().charAt(0);
		boolean result = checkLower(ch);
		
		if (checkLower(ch) == true) {
			System.out.println("소문자");
		} else {
			System.out.println("대문자");
		}

//		-----------------------------------------	
	}

	static boolean checkLower(char ch) {

		if (ch >= 'a' & ch <= 'z') {
			return true;
		} else {
			return false;
		}

	}
}
