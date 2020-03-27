package h_inherit4;

public class Dvd extends Item{
	String actor,gamdok;

	Dvd() {
		System.out.println("Dvd 기본 생성자");
	}

	Dvd(String num, String title, String actor, String gamdok) {
		super.num = num;
		super.title = title;
		this.actor = actor;
		this.gamdok = gamdok;
		System.out.println("Dvd 인자 생성자");
	}
	
//	public void output() {
//		System.out.println(num);
//		System.out.println(title);
//		System.out.println(actor);
//		System.out.println(gamdok);
//	}
}
