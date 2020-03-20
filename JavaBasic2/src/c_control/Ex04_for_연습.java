package c_control;

import java.util.Scanner;

public class Ex04_for_연습 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int num;
//		
//		num = scan.nextInt();
//		
//		for(int i=1;i<=num;i++) {
//			System.out.print(i+ "\t");
//			if(i%5==0) {
//				System.out.println();
//			}
//			
//		}
//		System.out.println("========================================");
//		
		//2문제2)  문자열처리하기
//=======================================================================
		//문자 N(a~z, A~Z)를 입력받아 N이 소문자면 a부터 N까지 인쇄하고
		//N이 대문자이면 문자 N부터  Z까지 출력하라
		//그 밖의 문자가 입력되면 Error 를 출력하라
		//
		//입력  출력
		//f       abcdef
		//X       XYZ
		//6       Error
		
//		char a;
//		a = scan.next().charAt(0);//글자를 입력받음
//		
//		if(a<='z'&& a>='a') {//
//			for(char start = 'a';start<=a;start++)
//			System.out.print(start);
//		}
//		else if(a<='Z'&& a>='A') {
//			for(char start = a;start<='Z';start++)
//			System.out.print(start);
//		}
//		else {
//			System.out.println("Error");
//		}
//		
		
//=======================================================================		
//		문제3 ) 입력받은 문자열의 뒤집어서 출력하세요
//		  
//		   [예]  입력     출력
//		  
//		     안녕 친구   구친 녕안
//		     CarpeDiem   meiDepraC
//		     
//		   [힌트] 문자열의 길이 구할 때   length() 이용
//		
//		String stance = "";
//		stance = scan.nextLine();//문자열을 입력받음
//		
//		for(int i =stance.length()-1;i>=0;i--) {//입력받은 문자의 길이만큼 역순으로 출력함
//			System.out.print(stance.charAt(i));
//		}
//		
//=======================================================================				
//		도전문제 ) 자연수 n을 입력받아 "출력 예"와 같이 n x n크기에 공백으로 구분하여 출력되는 프로그램을 작성하시오
//				10 미만의 홀수만 출력하시오. 주의! 숫자는 공백으로 구분하되 줄사이에 빈줄은 없다.
		
//		입력					
//		3
//		
//		출력
//		1 3 5
//		7 9 1
//		3 5 7
		
		int a;
		a = scan.nextInt();
		int j = -1;
		
		for(int i =1;i<=a*a;i++) {
			if(j>8) {
				
//			if(j<9 &j>=1) {//1부터 9사이이면 2씩 증가시켜서 홀수를 출력함
//				j+=2;
//			}else {//9가 넘으면 다시 1로 초기화
				j=1;
			}else {
				j+=2;
			}
				
			System.out.print(j+" ");
			if(i%a==0) {//입력한 숫자와 
				System.out.println();
			}
		}
		

	}

}
