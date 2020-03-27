package c_collection;

import java.util.ArrayList;

public class aArrayListEx3 {

	public static void main(String[] args) {
//		ArrayList list = method();
		ArrayList<Student> list = method();
//		for(int i=0;i<list.size();i++) {
//			String data = String.valueOf(list.get(i));
//			System.out.println(data);
//		}
//		for(int i=0;i<list.size();i++) {
//			Student data = (Student)list.get(i);
//			System.out.println(data);
//		}
		for(Student data:list) {
			System.out.println(data);
		}
		
	}
	static ArrayList<Student> method() {
		//세명의 학생 정보를 저장 :ArrayList 이용
		Student a = new Student("홍길동",25);
		Student b = new Student("홍길자",35);
		Student c = new Student("홍길숙",20);
		
		ArrayList<Student>  list = new ArrayList<Student>();
//		list.add(String.valueOf(a));
//		list.add(String.valueOf(b));
//		list.add(String.valueOf(c));
		list.add(a);
		list.add(b);
		list.add(c);
		
		return list;
	}
}

//----------------------------------------------------------
class Student{
	String name;
	int age;
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name +"학생은 " +  age + "세 입니다.";
	}
}
