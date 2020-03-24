package c_control;

import java.util.Scanner;

public class problem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		int a,b,c,t;//입력받는 변수 a,b,c  값을 잠깐 저장해 놓는 변수 t
//		
//		a = scan.nextInt();
//		b = scan.nextInt();
//		c = scan.nextInt();//세 정수를 다 입력
//		if(a>b) {//a와 b의 값을 비교해서 값의 자리를 바꿔줌
//			t = a;
//			a = b;
//			b = t;
//		}
//		if(b>c) {//b와 c의 값을 비교해서 값의 자리를 바꿔줌
//			t = b;
//			b = c;
//			c = t;
//		}
//		//위의 과정을 한번 더 반복함
//		if(a>b) {
//			t = a;
//			a = b;
//			b = t;
//		}
//		if(b>c) {
//			t = b;
//			b = c;
//			c = t;
//		}
		
		int a,b,c,t,t2;//입력받는 변수 a,b,c  값을 잠깐 저장해 놓는 변수 t
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();//
		
		if(a>b&a>c) {
			
		}
		t = ((a>b)==(a>c))?(b>c)?b:c:a;
		t = ((b>a)==(b>c))?(a>c)?a:c:b;
//		t = ((c>a)==(c>b))?(a>c)?a:c:b;
		System.out.println(t);//마지막에 a,b,c가 크기순으로 정렬되고 가운데 값을 출력하면 두번째로 큰 정수가 출력된다.
	
		
	}

}
