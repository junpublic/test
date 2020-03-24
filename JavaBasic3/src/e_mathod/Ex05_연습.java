package e_mathod;

import java.util.Scanner;

/*입력받은 첫 번쨰 정수만큼의 행과 두번쨰 정수만큼의 문자 배열을 만들어
 * 입력받은 문자로 시작하는 알파벳을 저장하기
 * 
 * 
 *  F G H I
 *  J K L M 
 *  N O P Q
 *  
 */
public class Ex05_연습 {

	public static void main(String[] args) {
		char [][] result = input();//makeSquare에서 만들어진 ch배열을 result에 저장
		output(result);//ch배열을 출력
		

	}
	/* 두정수와 알파뱃 문자 하나를 입력받기
	 * 
	 */

	static char[][] input() {
		Scanner input = new Scanner(System.in);
		System.out.println("두 정수와 알파벳 문자 하나를 입력->");
		int first = input.nextInt();//행 입력
		int second = input.nextInt();//열 입력
		char alpha = input.next().charAt(0);//문자 입력
		
		
		char [][]  result = makeSquare(first,second,alpha);//반환받음 ch배열을 저장함
		return result;//ch 값을 다시반환함
	}
	static char[][]  makeSquare(int first,int second,char alpha) {//리턴값과 형식이 같아야함
		char [][] ch = new char[first][second];//입력받은 수의 크기만큼 배열을 만듦
		for(int i=0;i<ch.length;i++) {//길이만큼 배열을 만듦
			for(int j=0;j<ch[i].length;j++) {
				ch[i][j] = alpha++;//문자의 아스키 코드를 증가시켜 문자를 바꿈
			}
		}
		return ch;//저장한 배열을 반환함
		
		
	}
	//변수를 출력
	static void output(char [][] ch) {
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[i].length;j++) {
				System.out.print(ch[i][j]+" ");
			}
			System.out.println();
		}
	}
}
