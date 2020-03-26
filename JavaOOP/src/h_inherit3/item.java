package h_inherit3;


public class item {
	protected String num,title;
	
	public item(){
		System.out.println("item 기본 생성자");
	}
	
	public item(String num , String title){
		this.num = num;
		this.title = title;
		System.out.println("item 인자 생성자");
	}
	public void output() {
		System.out.println(num);
		System.out.println(title);
	}
}
