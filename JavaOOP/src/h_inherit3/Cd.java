package h_inherit3;

public class Cd extends item{
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
	public void output() {
		System.out.println(num);
		System.out.println(title);
		System.out.println(singer);
	}
}
