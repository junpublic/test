package d_array;

public class Ex07_동적크기 {

	public static void main(String[] args) {
		char [][] star = new char[5][];
		
		//입력
		
		for(int i=0;i<star.length;i++) {
			
			star[i] = new char[i+1];//동적으로 메모리를 만들어 준다.
			for(int j=0;j<i+1;j++) {
				
				star[i][j]='&';
				
			}
		}
		
		//출력
		for(int i=0;i<star.length;i++) {//
			for(int j=0;j<star[i].length;j++) {
				System.out.print(star[i][j]+" ");
			}
			System.out.println();
		}

	}

}
