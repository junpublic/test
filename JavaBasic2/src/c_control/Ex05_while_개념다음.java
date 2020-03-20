package c_control;

import java.util.Scanner;

public class Ex05_while_개념다음 {

	public static void main(String[] args) {
		
		String result = "";
		
		do {
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요");
		
		int su = input.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",su,i,su*i);
		}
		System.out.println("구구단 다시 할까요?:");
		result = input.next();
		
		}while(result.equals("Y")|result.equals("y"));//while문은 조건에 만족할 때까지 반복하고 조건문이 false면 시작 안합
	}												//do-while문은 계속 반복하다가 조건이 만족되면 종료된다.무조건 처음에는 한번은 그냥 실행됨 조건에 안맞으면 종료됨

}
