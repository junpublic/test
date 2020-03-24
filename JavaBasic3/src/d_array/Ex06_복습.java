package d_array;

import java.util.Scanner;

public class Ex06_복습 {

	public static void main(String[] args) {
		//3x4 char 배열 ch 를 선언
//		char [][] ch = new char[3][4];
		int [][] ch = new int[3][4];
		
		//2.값 입력
		Scanner input = new Scanner(System.in);
		
//		char al='1';
		int al=1;
		
		for(int i=0;i<ch.length;i++) {//for문의 각 조건식이 들어가는 곳마다 반복 횟수가 다르다. 그것을 이용해서 원하는 만큼 다른 것을 반복 시킬 수 있다.
			for(int j=0;j<ch[i].length;j++,al++) {
//				ch[i][j]= input.nextLine().charAt(index);
				ch[i][j]=al;
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
		//3.출력
//		for(int i=0;i<ch.length;i++) {
//			for(int j=0;j<ch[i].length;j++) {
//				System.out.print(ch[i][j]);
//			}
//			System.out.println();
//		}
	}

}
