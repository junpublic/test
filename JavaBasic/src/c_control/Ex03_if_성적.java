package c_control;

import java.util.Scanner;

public class Ex03_if_성적 {

	public static void main(String[] args) {
		//국,영,수 점수 입력받아서 총점, 평균 출력
		//평균에 따른 학점(A~F)출력
		//=if 문 이용
		
		int kor,eng,math;
		double all,avg;
		char score;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 영어 수학 점수를 차례대로 입력하세요:");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		all = kor+ eng+ math;
		avg = all/3F;
		
		if(avg>=90) {
			score = 'A';
		}
		else if(avg>=80) {
			score = 'B';
		}
		else if(avg>=70) {
			score = 'C';
		}
		else if(avg>=60) {
			score = 'D';
		}
		else if(avg>=50) {
			score = 'E';
		}
		else{
			score = 'F';
		}
		
		System.out.println("평균은 "+score+"학점입니다.");
		
	}

}
