package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class EX_야구게임 {

	public static void main(String[] args) {

		int[] baseball = new int[3];//문제가 저장되는 배열
		int[] answer = new int[3];//정답 저장되는 배열
//		int[] num = new int[10];
		
		
//		for(int i=0;i<10;i++) {
//			num[i]=i;
//		}
//		for(int i=0;i<baseball.length;i++) {//랜덤숫자를 넣어줌
//			//중복수 배제
//			baseball[i]= (int)(Math.random()*9);//배열에서 랜덤 숫자를 뽑아서 넣는다.
//			System.out.print(baseball[i]+" ");
//		}
	
//			while (true) {
//				for (int i = 0; i < baseball.length; i++) {//baseball배열의 크기만큼 반복
//					
//					baseball[i] = (int) (Math.random() * 10);//랜덤 숫자를 넣는다.
//
//				}
//				// 중복수 배제
//				if ((baseball[0] != baseball[1]) & (baseball[1] != baseball[2]) & (baseball[0] != baseball[2])) {
//					break;//각 배열의 값들을 전부 비교해서 3개의 변수 전부 같이 않을때 저장됨
//				}
//
//			}
			for (int i = 0; i < baseball.length; i++) {//baseball배열의 크기만큼 반복
				
				baseball[i] = (int) (Math.random() * 10);//랜덤 숫자를 넣는다.
				for(int h=0;i<baseball.length;h++) {
					if(baseball[i]==baseball[h]) {
						i--;
					}
				}
				
			}
			for (int i = 0; i < baseball.length; i++) {
				System.out.print(baseball[i] + " ");//정답을 출력
			}
			System.out.println();
		
		
		
		
		while (true) {
			int strike=0,ball=0;//스트라이크와 볼 변수, 반복할 때마다 초기화됨
			// 정답 입력
			Scanner input = new Scanner(System.in);
			System.out.println("숫자 입력-> ");
			String line = input.nextLine();//숫자를 입력받음
			
			StringTokenizer st = new StringTokenizer(line);//
			for (int i = 0; st.hasMoreTokens(); i++) {
				int su = Integer.parseInt(st.nextToken());
				answer[i] = su;
			}
			// 값 비교
			OUT: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (baseball[i] == answer[j])//숫자가 같으면 실행
						if (i == j) {//숫자가 같고 자릿수 까지 같으면 스트라이크 증가
							strike++;
							if (strike == 3)//스트라이크가 3회가 되면 빠져나감
								break OUT;
						} else {//숫자가 같지만 자릿수는 다르면
							ball++;//
						}
				}
			}
			// 스트라이크 볼 출력
			System.out.println("strike=" + strike);//스트라이크 값 출력
			System.out.println("ball=" + ball);//볼 값 출력
			if(strike==3) {
				break;//스트라이크가 3회면 while문을 종료시킴
			}

		}
	}

}
