package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex08_성적2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("학생수-> ");
		int su = input.nextInt();
		
		//점수를 저장할 변수(score)를 학생수만큼 선언
		int [][] score = new int[su][3];
		
		//입력	
		for(int i=0;i<su;i++) {
			Scanner sc = new Scanner(System.in);//스캐너를 새로 만들어 주지 않으면 위에 입력한 값을 인식한다.
			System.out.print((i+1)+"째 학생의 성적을 입력-> ");
			String line = sc.nextLine();
			StringTokenizer ST= new StringTokenizer(line,"/");
			for(int j=0;ST.hasMoreTokens();j++) {
				score[i][j] = Integer.parseInt(ST.nextToken());
			}
		
		}
		//출력	
		int sum[] = new int[su];
		int avg[] = new int[su];
		
		int ksum[] = new int[3];
		int kavg[] = new int[3];
		for (int i = 0; i < su; i++) {

			for (int j = 0; j < 3; j++) {

				sum[i] += score[i][j];

			}
			avg[i] = sum[i] / su;
			System.out.printf("%d째 학생의 총점은 %d 이고 평균은 %d 입니다.", i + 1, sum[i], avg[i]);
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < su; j++) {

				ksum[i] += score[j][i];

			}
			kavg[i] = ksum[i] / su;
			switch(i) {
				case 0:
					System.out.printf("국어과목 총점은 %d 이고 평균은 %d 입니다.", ksum[i], kavg[i]);
					break;
				case 1:
					System.out.printf("영어과목 총점은 %d 이고 평균은 %d 입니다.", ksum[i], kavg[i]);
					break;
				case 2:
					System.out.printf("수학과목 총점은 %d 이고 평균은 %d 입니다.", ksum[i], kavg[i]);
					break;
			}
			
			System.out.println();
		}

	}

}
