package d_array;

public class Ex01_성적 {

	public static void main(String[] args) {
//		int [] kor = new int[5];
//		int [] kor = new int[] {90,80,70,60};
		int [] kor = {90,80,70,60};
		int num = 5;
		int total = 0;
		for(int i =0; i<kor.length;i++) {
			total += num;
			kor[i] = num--;			
			System.out.println(kor[i]);
			
			
		}
		System.out.println(total);
		

	}

}
