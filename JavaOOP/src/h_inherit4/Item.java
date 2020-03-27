package h_inherit4;


public abstract class Item {//클래스도 미완성이니 앞에 붙여줌
	protected String num,title;
	
	public Item(){
		System.out.println("item 기본 생성자");
	}
	
	public Item(String num , String title){
		this.num = num;
		this.title = title;
		System.out.println("item 인자 생성자");
	}
	public abstract void output();//미완성코드임 그러니 반드시 오버라이딩 해야됨
}
