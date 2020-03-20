package d_array;

import java.util.Scanner;

public class EX_평균구하기 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] point = new int[num][];//입력받은 수 만큼 행을 만들어줌
		int [] sum = new int[point.length];//더한값 저장
		double [] avg = new double[point.length];//평균저장
		double [] per = new double[point.length];//퍼센트 저장

		for (int i = 0; i < point.length; i++) {
			int cnt=0;
			point[i] = new int[(int) (Math.random() * 10) + 1];// 동적으로 메모리를 만들어 준다.
			for (int j = 0; j < point[i].length; j++) {
				point[i][j] = (int) (Math.random() * 100) + 1;
				sum[i] += point[i][j];//총합을 구함
			}
			avg[i]= sum[i]/ point[i].length;//평균을 구함
			
			for(int j=0;j< point[i].length;j++) {//평균보다 높은 값을 잡아낸다.
				if(point[i][j]>avg[i]) {
					cnt++;//맞으면 평균 보다 높은 사람 카운트
				}
				
			}
			per[i]=(double)(cnt*100)/point[i].length;//100분률 구하기
//			per[i]=(double)(cnt/point[i].length)*100;//100분률 구하기
			

		}
		for (int i = 0; i < point.length; i++) {

			for (int j = 0; j <  point[i].length; j++) {
				System.out.print(point[i][j]+" ");
//				sum[i] += score[i][j];

			}
//			avg[i] = sum[i] / su;
			System.out.println(avg[i]+" "+per[i]);
			System.out.println();
		}

	}
	

}
