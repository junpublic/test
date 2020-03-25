package b_encapsulation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//변수 선언
//		Student s;
		//객체 생성(메모리에 확보)
//		s = new Student();
		Scanner input = new Scanner(System.in);
		Student s = new Student();
		s.setKor(70);//private로 바꿔준 변수값은 .set~로 바꿔준다.
		s.setEng(88);
		s.setMath(99); 
//		s.setName("홍길동");
		s.setName(input.nextLine());
		System.out.println(s.getKor()+"/"+s.getEng()+"/"+s.getMath());
		System.out.println(s.getName());
		System.out.println("총점: "+s.calTotal());//ctrl버튼 누르면 그 클래스 안으로 들어가짐
		
//		s.total = 100;
		System.out.println("평균: "+s.calAverage());
		
	}
	/*
	 * [ 결론내기 ] 캡슐화란??? 
	 */
}
