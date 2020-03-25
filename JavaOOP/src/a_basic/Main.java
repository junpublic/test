package a_basic;

public class Main {

	public static void main(String[] args) {
		//변수 선언
//		Student s;
		//객체 생성(메모리에 확보)
//		s = new Student();
		Student s = new Student();
		s.kor = 70;
		s.eng = 80;
		s.math = 99;
		System.out.println("총점: "+s.calTotal());//ctrl버튼 누르면 그 클래스 안으로 들어가짐
		
		s.total = 100;
		System.out.println("평균: "+s.calAvg());
	}

}
