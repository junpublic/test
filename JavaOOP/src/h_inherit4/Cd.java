package h_inherit4;

public class Cd extends Item{
	String singer;
	
	Cd(){
		System.out.println("Dvd 기본 생성자");
	}
	Cd(String num,String title,String singer){
		super.num = num;
		super.title = title;
		this.singer = singer;
		System.out.println("Dvd 인자 생성자");
	}
	public void output2() {//부모가 미완성이여서 오버라이딩 해야됨  그러러면 추상을 써야됨
		System.out.println(num);
		System.out.println(title);
		System.out.println(singer);
	}
}
