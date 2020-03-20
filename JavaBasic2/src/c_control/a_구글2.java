package c_control;

import java.util.Scanner;

public class a_구글2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		int num;
//		num= input.nextInt();//숫자를 입력
//		
//		for(int i=1;i<=num;i++) {
//			int j=i;//i값을 j에 저장해서 줄의 시작값을 저장
		
//			for(int k=0;k<num;k++) {						
//				System.out.print(j +" ");//
//				j+=num;//처음 줄이 1번째 줄이니까 4씩더함
//					//줄이 증가하면 줄의 처음 시작하는 값이 바뀌면서 자동으로 4씩더해서 채워나감
//			}
//			System.out.println();
//		}
//		
//		int h= input.nextInt();
//		int w= input.nextInt();
//		int j=1;
//		for(int i=1;i<=h;i++) {
//			if(i%2==0) {
//				for(int k=1;k<=w;k++) {
//					System.out.print(j--+"\t");
//					
//				}
//				j+=w;
//				j+=1;
//			}else {
//				for(int z=1;z<=w;z++) {
//					System.out.print(j++ +"\t");					
//					}
//				j+=w;
//				j-=1;
//			}
//			System.out.println();
//		}
		
		
		int h= input.nextInt();//h 높이를 입력받음 
		int w= input.nextInt();//w 너비를 입력받음
		int j=1;//출력되는 값
		for(int i=1;i<=h;i++) {//높이만큼 실행
			if(i%2==0) {//짝수번째 줄이면 실행
				for(int k=1;k<=w;k++) {//너비만큼 실행
					System.out.print(--j+"\t");//j값을 빼줌	 --j인 이유는 짝수 줄의 마지막값이 출력된 것보다 1크게 저장되기 때문이다.		
				}
				j+=w;//감소한 출력값(j)에 다시 너비(w)만큼 더해줘서 다음 홀수줄의 첫번째 값에 이어지는 수로 바꾸어 준다.
				
			}else {//홀수번째 줄이면 실행
				for(int z=1;z<=w;z++) {//너비만큼 실행
					System.out.print(j++ +"\t");//j값을 증가시킴					
					}
				j+=w;//넓이(w)만큼 출력되는(j) 값에 더해주면 홀수줄은 출력되는(j) 값 감소시켜서 역순으로 증가하는 것처럼 출력한다.			
			}
			System.out.println();
		}
			

	}

}
