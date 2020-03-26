package f_innerclass;

class Outer//outer는 밑의 클래서 inner를 멤버변수로 본다. //class안에 class가 들어가면 파일명에 $가 들어간다. 1)
{
	class Inner//멤버변수라서 static을 붙일 수 있다.2)
	{
		void naJabara(){//여기도 static 붙일 수 있드아.!//3)
			System.out.println("잡아보슈~~");
		}
	}
}

public class InnerTest {
	public static void main(String[] args) 
	{
		Outer o = new Outer();//1)
		Outer.Inner in = o.new Inner();//static을 안붙였때는 이렇게//1)
		
//		Outer.Inner in = new Outer.Inner();//2)
		in.naJabara();//static 붙였으면 이렇게//1)2)
		
//		Outer.Inner.naJabara();//제일 안쪽 naJabara에 static을 붙이면 이렇게 할 수 있다.//3)
	}
}


