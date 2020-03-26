package h_inherit3;
/*
 * this: 자신 객체를 지칭하는 레퍼런스
 * super : 부모 객체를 지칭하는 레퍼런스
 * 
 * this():다른 생성자함수를 호출할 때  //첫줄에 와야함
 * super():부모 생성자함수를 호출할 때 //첫줄에 와야 함
 * 
 */

public class Book extends item{
	String author,publisher;
	
	Book(){
	System.out.println("Book 기본생성자");
	}
	Book(String num,String title, String author, String publisher){
//		super.num = num;
//		super.title = title;
		super(num,title);
		this.publisher = publisher;
		this.author = author;
		System.out.println("Book 인자생성자");
	}
	public void output() {
		System.out.println(num);
		System.out.println(title);
		System.out.println(author);
		System.out.println(publisher);
	}
}
