
public class Main2 {

	public static void main(String[] args) {
		Person p = method();
		output(p);

	}
	static void output(Person p) {
		System.out.println("이름="+p.getName());
		System.out.println("나이="+p.getAge());
		System.out.println("키="+p.getHeight());
		
	}
	static Person method() {
		Person p = new Person();
		String name = "홍길자";
		int age = 24;
		double height =190.99;
		
		
		p.setAge(age);
		p.setName(name);
		p.setHeight(height);
		
		return p;
		
	}
}

class Person {//비추한다. 왜냐하면 틀린곳을 파일명에서 찾기 힘들기 떄문에 따로 만드는 것을 권장
	private String name;
	private int age;
	private double height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}

