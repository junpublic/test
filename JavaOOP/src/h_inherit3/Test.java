package h_inherit3;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Book b = new Book("0001","자바","홍길동","코스모");
//		b.output();//부모변수에는 super를 붙여준다.
		item i = null;
		
		Book b = null;
		  Dvd  d = null;
		  Cd   c = null;
	  
		  Scanner input = new Scanner(System.in);
		  System.out.println("상품선택(1. Book  2.Dvd   3.Cd");
		  int sel = input.nextInt();
		  //1)부모변수에 자식생성 가능함(상속관계)
		  switch(sel) {
		  case 1: b = new Book("0001","자바","홍길동","코스모"); break;
		  case 2: d = new Dvd("002","킹덤","주지훈","김은희"); break;
		  case 3: c = new Cd("00001","아는노래","지코"); break;
		  }
		  // 출력*****
		 
		  switch(sel) {
		  case 1: b.output(); break;
		  case 2: d.output(); break;
		  case 3: c.output(); break;
		  }
		 //2)overriding
		  i.output();
	}

}
