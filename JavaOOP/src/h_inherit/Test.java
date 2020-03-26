package h_inherit;
/*
 * overloading: 동일한 함수명으로 인자의 사료형과 갯수 다른 함수들
 * 
 * overriding : 상속관계에서 인자와 반환값까지 동일한 함수들
 */
public class Test {

	public static void main(String[] args) {

		//1.각각의 클래스 생성
//		Umma u = new Umma();
//		u.gene();
//		u.job();
		
//		Ddal d = new Ddal();
//		d.gene();
//		d.study();
//		
//		
//		//*
//		d.job();//딸이라고 만들어지는 순간 부모까지 같이 다올라감

		//2.부모 변수에 자식 객체 생성
//		Umma dal = new Ddal();
////	dal.study();// 엄마로 선언해서 딸로는 엄마꺼를 못 가져옴
//		dal.job();//엄마 안에 있어서 가져올 수 있음
//		dal.gene();//엄마에 지니가 있어서 딸에있는 지니도 찾아올 수 있음
		
		//3.객체임을 확인
//		Ddal d = new Ddal();//딸은 엄마까지 다 포함하고있다.
//		if(d instanceof Ddal) {
//			System.out.println("딸 객체");
//		}
//		if(d instanceof Umma) {
//			System.out.println("부모 객체");
//		}
		
		//4.형변환
		//	(casting):기본형
//		StringBuffer sb = (StringBuffer)a;
		
//		Umma a = new Umma();
//		Ddal b = (Ddal)a;//Ddal은 아직 메모리에 올리지 않아서 캐스팅이 안됨
		
		Ddal c = new Ddal();//Ddal로 잡으면 엄마딸 다 잡힘
		Umma d = (Umma)c;//up-casting// 엄마부터 읽어옴
		Ddal e = (Ddal)d;//down-casting//이미 전체가 잡혀있어서 다 읽음
		
	}

}
