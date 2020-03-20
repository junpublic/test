package c_control;

public class Ex04_for_개념 {

	public static void main(String[] args) {
		/*
		 * for(초기치;조건식;증가치){
		 * 		반복구문
		 * }
		 */
		
		//0.인사말 5번 출력하기
//		for(int i=0;i<5;i++) {
//			if(i==0|i==4)
//				System.out.println("++++++");
//			else
//				System.out.println("+    +");
//		}
		
		//1.홀짝의 합
//		int hol=0,jack=0;
//		for(long i=1;i<101;i++) {
//			if((i%2)==0) {
//				jack+=i;
//			}else {
//				hol+=i;
//			}
//		}
//		System.out.println("홀수의 합= "+hol);
//		System.out.println("짝수의 합= "+jack);
//		
		//3.A~Z 출력
		for(char ch = 'a';ch<='z';ch++){
			System.out.print(ch);	
		}
		System.out.println();
		//3.A~Z 출력(2개씩 건너뛰기)
		for(char ch = 'a';ch<='z';ch+=2){
			System.out.print(ch);	
		}
		System.out.println();
		//4.Z~A 출력
		for(char ch = 'z';ch>='a';ch--){
			System.out.print(ch);	
		}
	}

}
