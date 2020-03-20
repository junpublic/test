package b_operator;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		
		int score;
		Scanner scan = new Scanner(System.in);
		System.out.println("점수 입력-> ");
		score = scan.nextInt();
		if(score > 80 && score < 90)
			System.out.println("평균");
		else
			System.out.println("평균 아님 멍청아");
	}

}
