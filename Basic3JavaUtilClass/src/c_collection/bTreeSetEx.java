package c_collection;
import java.util.TreeSet;

public class bTreeSetEx 
{
	public static void main(String[] args) 
	{
		TreeSet  set = new TreeSet();//크면 오른쪽 작으면 왼쪽으로 자동 정렬됨
		
		set.add("elephant");
		set.add("tiger");
		set.add("lion");	
		set.add("cat");
		set.add("dog");
		set.add("ant");
		set.add("snack");
		set.add("zebra");
		set.add("bee");
		set.add("lion");

		System.out.println( set );
		

	}
}
