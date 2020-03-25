package e_static;
/*
 * 단 하나로 공유: static
 */
public class Book {
	private static int count;//메모리에 하나 올려서 공유하려고

	public Book(){
		count++;
		System.out.println("책 한개 생성");
	}
	
	public static int getCount() {//클레스명 접근을 하려고
		return count;
	}
	
}
