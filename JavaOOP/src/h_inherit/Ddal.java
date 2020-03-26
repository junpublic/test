package h_inherit;

public class Ddal  extends Umma{//상속관계를 맺음 umma가 부모 ddal 자식
	public Ddal() {
		System.out.println("자식의 기본생성자");
	}
	public void gene() {
		System.out.println("자식은 자식이다.");
	}
	public void study() {
		System.out.println("딸은 학생");
	}
}
