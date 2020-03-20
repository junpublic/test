package d_array;



public class Ex05_Lotto {

	public static void main(String[] args) {

	
		int[] lotto = new int[6];
		boolean check;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
				}
			}
//			for(int j=0;j<i;j++) {
//				if(lotto[i]==lotto[j]) {
//					check=true;
//					break;
//				}
//			}
//			if(!check) {
//				lotto[j] = temp;
//			}
		} // 동일숫자 배제

	
		for (int i = lotto.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int t;
					t = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = t;
				}
			}
		}
	
		for (int i = 0; i < 6; i++) {
			System.out.print(lotto[i] + "/");
		}

	}

}
