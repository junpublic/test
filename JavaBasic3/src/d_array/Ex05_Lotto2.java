package d_array;



public class Ex05_Lotto2 {

	public static void main(String[] args) {

	
		int[][] lotto = new int[5][6];
		boolean truth[] = new boolean[6];
		
//		for (int j = 0; j < lotto.length; j++) {//행의 크기만큼 반복함
//			for (int i = 0; i < lotto[j].length; i++) {//열의 크기만큼 반복함
//				lotto[j][i] = (int) (Math.random() * 45) + 1;//45보다 작은 무작위 수를 배열에 넣는다.
//			}
//		} // 동일숫자 배제
		
		
		for (int j = 0; j < lotto.length; j++) {// 행의 크기만큼 반복함
			while (true) {
				int cnt=0;
				for (int i = 0; i < lotto[j].length; i++) {// 열의 크기만큼 반복함
					lotto[j][i] = (int) (Math.random() * 45) + 1;// 45보다 작은 무작위 수를 배열에 넣는다.
				}
				

			} // 동일숫자 배제

		}
		
		for (int k = 0; k < lotto.length; k++) {//행을 증가시킴
			for (int j = lotto[k].length - 1; j > 0; j--) {					//열의 초기값에 -1을 해준 이유는 밑의 스와핑 과정에서 배열의 길이보다 1적게해야 오류없이 실행된다. 
				for (int i = 0; i < j; i++) {//J값이 준 만큼 실행된다.				//감소하면서 FOR문을 하는 이유는 가장 큰 값이 제일 뒤로 가게 되면서 끝은 검사 할 필요가 없어진다.
					if (lotto[k][i] > lotto[k][i + 1]) {//만약 앞의 값이 뒤의 값보다 크면 배열의 값을 서로 바꿔준다.
						int t;//바꾸는 변수의 값을 잠시 저장
						t = lotto[k][i];//값의 자리를 바꿔준다.
						lotto[k][i] = lotto[k][i + 1];
						lotto[k][i + 1] = t;
					}
				}
			}
		}

		for (int j = 0; j < lotto.length; j++) {
			for (int i = 0; i < lotto[j].length; i++) {
				System.out.print(lotto[j][i] + "/");//배열 안의 값을 출력한다.
			}
		System.out.println();
		}
	}

}
