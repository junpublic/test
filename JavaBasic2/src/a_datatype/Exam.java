package a_datatype;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		int age,tall;
		String name;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이: ");
		age = scan.nextInt();
		
		System.out.print("키 : ");
		tall = scan.nextInt();
		
		System.out.print("이름 : ");
		scan.nextLine();
		name = scan.nextLine();
		
		
		
		System.out.println("이름 = "+name+" 나이 = "+age+" 키 = "+tall);
	}

}
