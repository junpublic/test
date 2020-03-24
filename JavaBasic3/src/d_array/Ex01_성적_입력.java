package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01_성적_입력 {

	public static void main(String[] args) {
		/*학생 점수를 입력받아 평균과 총점을 출력
		 * 
		 * 입력형식: 80/70/60
		 * 출력형식: 
		 * 
		 * 		총점:???
		 * 		평균:???
		 */
		Scanner input = new Scanner(System.in);
		
		int []score = new int[3];
//		int i=0;
		int total =0;
		double avg=0;
		System.out.print("점수를 입력해 주세요(90/80/60): ");
		String line = input.nextLine();
		StringTokenizer st = new StringTokenizer(line,"/");
		for(int i=0;st.hasMoreTokens();i++) {
			String temp = st.nextToken();//
			score[i]=Integer.parseInt(temp);//	
			total+=score[i];
		}
		avg=(double)total/score.length;
		System.out.println("총점: "+total);
		System.out.println("평균: "+avg);
		
		
		
//			String line = input.nextLine();
//			StringTokenizer st = new StringTokenizer(line,"/");//입력받은 값을 구분해서 나눠준다. 기본은 space, 뒤에 ")"같이 넣어주면 그걸 기준으로 나눔
//			while(st.hasMoreTokens()) {//한번 단어를 나눈 뒤 그 뒤에도 단어가 있으면 실행
//				String temp = st.nextToken();//단어를 넣어줌
//				int su = Integer.parseInt(temp);//문자를 숫자로 변환
//				score[i]=su;
//				System.out.printf("scores[%d] = %d\n",i,score[i]);
//				i++;
//			}

//		String line = scan.nextLine();
//		StringTokenizer st = new StringTokenizer(line,"/");//입력받은 값을 구분해서 나눠준다. 기본은 space, 뒤에 ")"같이 넣어주면 그걸 기준으로 나눔
//		while(st.hasMoreTokens()) {//한번 단어를 나눈 뒤 그 뒤에도 단어가 있으면 실행
//			String temp = st.nextToken();//단어를 넣어줌
//			int su = Integer.parseInt(temp);//문자를 숫자로 변환
//			System.out.println(++su);
//		}
		
		
		

	}

}
