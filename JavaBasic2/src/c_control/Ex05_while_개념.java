package c_control;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex05_while_개념 {

	public static void main(String[] args) {
//		int i=0;
//		int j=0;
//		while(i<11) {
//			j+=i;
//			i++;
//		}
//		System.out.println(j);
//======================================================
//		//구구단 출력
//		Scanner scan = new Scanner(System.in);
//		System.out.print("숫자를 입력해 주세요: ");
//		int su = scan.nextInt();
//
////		for (int i = 1; i <= 9; i++) {
////			System.out.printf("%d * %d = %d\n",su,i,su*i);
////		}
//		
//		int i=1;
//		while(i<=9) {
//			System.out.printf("%d * %d = %d\n",su,i,su*i);
//			i++;
//		}
//======================================================
//		Scanner scan = new Scanner(System.in);
//		System.out.print("점수를 입력해 주세요(90/80/60): ");
//		String line = scan.nextLine();
//		StringTokenizer st = new StringTokenizer(line,"/");//입력받은 값을 구분해서 나눠준다. 기본은 space, 뒤에 ")"같이 넣어주면 그걸 기준으로 나눔
//		while(st.hasMoreTokens()) {//한번 단어를 나눈 뒤 그 뒤에도 단어가 있으면 실행
//			String temp = st.nextToken();//단어를 넣어줌
//			int su = Integer.parseInt(temp);//문자를 숫자로 변환
//			System.out.println(++su);
//		}
//======================================================		
//		문제 2)
//	 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램을 작성하시오.
//	 
//	 입력
//	 10 20 30 55 66 77 88 99 100 15
//	 
//	 출력
//	 짝수 : 6개
//	 홀수 : 4개
//
//
//		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("점수를 입력해 주세요: ");
//		String line = scan.nextLine();
//		int hol=0,jack=0;
//		StringTokenizer st = new StringTokenizer(line);//입력받은 값을 구분해서 나눠준다
//		while(st.hasMoreTokens()) {//다음 토큰을 가져옴
//			String temp = st.nextToken();//단어를 넣어줌
//			int su = Integer.parseInt(temp);//문자를 숫자로 변환
//			if(su%2==0) {
//				jack++;
//			}else {
//				hol++;
//			}
//		}
//		System.out.println("\n짝수:"+jack);
//		System.out.println("홀수:"+hol);
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(line);
		
		while(st.hasMoreElements()) {
			String temp = st.nextToken();
			
		}
	}
}
