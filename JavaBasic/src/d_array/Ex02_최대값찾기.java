package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex02_최대값찾기 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String line = input.nextLine();
		StringTokenizer st = new StringTokenizer(line);
		int [] score = {} ;
		for(int i=0;st.hasMoreTokens();i++) {
			int su = Integer.parseInt(st.nextToken());
			score[i]=su;
		}
		
		
		int max=0;
		
		for(int i=0;i<score.length;i++) {
			if(max<score[i]) {
				max=score[i];
			}			
		}
		System.out.println(max);

	}

}
