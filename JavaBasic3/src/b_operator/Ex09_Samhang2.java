package b_operator;

import java.util.Scanner;

public class Ex09_Samhang2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score;
		
		System.out.print("점수를 입력하세요:");
		score = scan.nextInt();
		
		String yes = (score>80)? "합격":"불합격";
		System.out.println(yes);

	}

}
