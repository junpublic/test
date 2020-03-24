package e_mathod;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex00_복습3 {

	static int sum = 0;
	static double avg = 0;
	
	public static void main(String[] args) {
		int [] score = input();
		calScore(score);
		output();
	}
	static void output() {
		System.out.println("총점:"+sum+" 평균: "+avg);
		
	}
	//입력받은 국영수 점수로 총점, 평균을 구하기
	static void calScore(int [] score) {
		
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
		}
		avg= (double)sum/score.length;
		
		
	}
	//국영수 점수를 입력받기
	static int[] input() {
		int kor=0,eng=0,math=0;
		
		Scanner  input = new Scanner(System.in);
		
		kor = input.nextInt();
		eng = input.nextInt();
		math = input.nextInt();
		
		int [] score = {kor,eng,math};
		
		
//		score[0] = kor;
//		score[1] = eng;
//		score[2] = math;
		
		return score;
	}
}
