package d_array;

public class Ex04_정렬 {

	public static void main(String[] args) {
		int [] score = {90,80,70,60};
		
		for(int i=score.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(score[j] >score[j+1]) {
					int t;
					t=score[j];
					score[j]=score[j+1];
					score[j+1]=t;
				}
			}
		}
		
		for(int a=0;a<score.length;a++) {
			System.out.print(score[a]+"/");
		}

	}

}
