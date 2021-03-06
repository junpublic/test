package a_basic_class;

public class Ex01_ObjectEqualsEx
{
	public static void main(String[] args)
	{
		 StudentA  a = new StudentA("012345", "송혜교");
		 StudentA  b = new StudentA("012345", "송혜교");
		 
		 if( a.equals(b)) {
			 System.out.println("객체 a와 b는 같다");
		 }else {
			 System.out.println("객체 a와 b는 다르다");
		 }

		 System.out.println( a.toString()  );//우리 눈에는 안보이지만 .toString이 들어가있다.
		 System.out.println( b  );
	}
}

class StudentA extends Object
{
	String  hakbun, name;
	StudentA( String  hakbun, String name)
	{
		this.hakbun = hakbun;
		this.name = name;
	}	
	
	public String toString() {
		return hakbun + "/" + name;
	}

}