package c_control;

public class Ex_while_연습 {

	public static void main(String[] args) {
		
//		for(int i =30;i<34;i++) {
//			int su = i;
//			boolean su369 = false;
//			
//			
		
		while(su != 0) {//계속 반복됨
//				int na = su % 10;//su를 10으로 나눈 나머지를 na에 넣음
//				if(na==3|na==6|na==9) {//나머지가 3,6,9이면
//					System.out.print("짝");//'짝' 출력
//					su369 = true;
//				}
//				su/=10;//su를 초기화 시켜줌 (ex. 303 이면 1의자리를 없엔 30을 su에 넣어줌)
//			}(303이면 1의 자리 , 10의자리,100의 자리에 3,6,9가 있는지 체크하고  답은 '짝 짝'이 나온다.
//			
//			if(su369)//3,6,9이면 줄만 바뀜
//				System.out.println();
//			else //그 이외의 숫자는 그냥 출력
//				System.out.println(i);
//		}
		int cnt = 0;
		for(int i=1;i<=10000;i++) {
			int su = i;
		
			while(su != 0) {
				int na = su % 10;
				if(na ==8) {
					cnt++;
				}
				su/=10;
			}			
		}
		System.out.println(cnt);
		
	}

}
