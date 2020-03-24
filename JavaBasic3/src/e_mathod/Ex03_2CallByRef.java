package e_mathod;

public class Ex03_2CallByRef {
	/**
	 *  메소드의 인자가 참조형인 경우
	 *  		-> 주소 복사됨
	 *  		call by reference 
	 */
	
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("안녕");
		StringBuffer b = new StringBuffer("하이");
		add(a,b);
		System.out.println("A = "+a+",B = "+b);
	}
	static void add(StringBuffer a,StringBuffer b) {//StringBuffer는 주소를 가르키기 떄문에 안에서 지역변수에서 바뀌어도 메인에서도 바뀐다.
		//a+=b;
		a.append(b);//이건 참조형이기 때문에 이걸 써줘야 문자열을 붙일 수 있다.
		System.out.println("A = "+a+",B = "+b);
	}

}
