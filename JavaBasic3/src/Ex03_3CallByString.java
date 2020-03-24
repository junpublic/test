
public class Ex03_3CallByString {

	public static void main(String[] args) {
		String a = new String("안녕");//스트링형은 별종이여서 빼고 생각하자!
		String b = new String("하이");
		add(a, b);
		System.out.println("A = " + a + ",B = " + b);
	}

	static void add(String a, String b) {// StringBuffer는 주소를 가르키기 떄문에 안에서 지역변수에서 바뀌어도 메인에서도 바뀐다.
		 a+=b;
//		a.append(b);// 이건 참조형이기 때문에 이걸 써줘야 문자열을 붙일 수 있다.
		System.out.println("A = " + a + ",B = " + b);
	}

}
