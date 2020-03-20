package b_useful_class;

public class StringStringBuffer {

	public static void main(String[] args) {
		//0.기본형
		int a = 10;
		a+=5;
		System.out.println(a);
		
		//1.String: 참조형
//		String s = new String("안녕");
//		System.out.println("안녕");
		String s = "안녕";//s라는 주소값을 저장하는 공간을 stack에 만들고 heap이라는 다른 공간에 "안녕"이라고 만든다.
		s += "하세요";//새롭게 바뀌는 순간 heap이라는 공간에 다른주소의 공간에 새롭게 만들어 지고  s에 주소값이 바뀐다.
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("행복한");//string은 새로운 주소를 만들어서 쓰레기 값이 생겨서 느려지지만 StringBuffer는 원레 주소에 이어붙여서 쓰레기를 만들지 않아 빠름
//		StringBuffer sb2 = "행복한";
//		sb = sb+"목요일";
		sb.append("목요일");
		System.out.println(sb);

	}

}
