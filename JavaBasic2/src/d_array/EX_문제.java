package d_array;

public class EX_문제 {

	public static void main(String[] args) {
//		int a[][] = new int[][] {{3,-5, 12 }, {-2, 1, 1, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}};
//		int b[] = new int[a.length];
//		int max=0;
//		for (int i = 0; i < a.length; i++) {
//
//			for (int j = 0; j < a[i].length; j++) {// 더한 값을
//				b[i] += a[i][j];
//
//			}
//
//		}
//		for (int i = 0; i < a.length; i++) {
//
//			if (b[i] > b[max])
//				max = i;
//
//		}
//
//		System.out.println("결과=" + max + "행");
//
		int a[][]=new int[][]{{3,-5, 12, 3, -21}, {-2, 11, 2, -7, -11}, {21, -21, -35, -93, -11}, {9, 14, 39, -98, -1}};
		int b[] = new int[a.length];//행의 길이만큼  배열을 만듦
		int c[] = new int[a[1].length];//열의 길이만큼  배열을 만듦
		int max=0;
		int max2=0;
		for (int i = 0; i < a.length; i++) {//행의 길이만큼 반복

			for (int j = 0; j < a[i].length; j++) {// 행을 더한 값
				b[i] += a[i][j];

			}
			

		}
		for (int i = 0; i < a[1].length; i++) {//열의 길이만큼 반복
			for (int j = 0; j < a.length; j++) {// 열을 더한 값
				c[i] += a[j][i];
			}
		}
		// 행의 최댓값 저장
		for (int i = 0; i < b.length; i++) {//행의 길이만큼 반복

			if (b[i] > b[max])
				max = i;

		}
		//열의 최댓값 저장
		for (int i = 0; i < c.length; i++) {// 열의 최댓값 출력
			if (c[i] > c[max2])
				max2 = i;
		}

		System.out.println("결과=" + max + " 행" + max2 + " 열");

	}

}
