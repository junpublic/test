package c_array;

import java.util.Scanner;

public class Main {

	/**
	 * 			배열을 이용해서 3명의 국영수 점수를 입력받아 총점과 평균을 구한다
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("입력할 학생 수는 ?");
		int num = in.nextInt();
		Student [] s = new Student[num];		// 학생 수 3은 배열의 갯수를 의미한다. 클라스는 따로 다시 선언해줘야한다.
			
		for(int i=0;i<s.length;i++) {
			s[i] = new Student();//클래스를 위한 객체 생성
		}
		
		//각각 학생의 이름과 국영수 점수를 입력받아 이름과 총점평균 출력
		for(int i =0;i<s.length;i++) {
			System.out.print((i+1)+"번쨰 학생 정보 입력?");
			String name = in.next();
			int kor = in.nextInt();
			int eng = in.nextInt();
			int math = in.nextInt();
			
			
			s[i].setName(name);
			s[i].setKor(kor);
			s[i].setEng(eng);
			s[i].setMath(math);
			
			
		}
		
		for(int i =0;i<s.length-1;i++) {
			Student w;
			if(s[i].calTotal()>s[i+1].calTotal()) {
				w = s[i];
				s[i] = s[i+1];
				s[i+1] = w;
			}
		}
		for(int i =s.length-1;i>=0;i--) {
			System.out.println(s[i].getName()+" 총점: "+ s[i].calTotal()+ " 평균: "+s[i].calAverage());
			
		}
	}

}
