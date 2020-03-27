package c_collection;

import java.util.ArrayList;
import java.util.Collections;

public class aArrayListEx2 {
	public static void main(String[] args) 
	{
		ArrayList<String>  list = new ArrayList<String>(4);//generices -> '<>'안에 형을 지정해주면 그것만 들어감
		list.add("rabbit");  
		list.add("zebra");
		list.add("squirrel");
		list.add("fox");
		list.add("lion");
		list.add("elephant");
		// 노랜표시 없애려면 generics 지정
		
		for(String data:list) {//형변환이 빠져서 프로그램이 훨씬 빨라짐. generices를 쓰고 타입이 같아야 쓸 수 있다. 
			System.out.println(data);
		}
		
		for(int i=0;i<list.size();i++) {
			String data = (String) list.get(i);//캐스팅 안해주면 오브젝트형을 넘긴다. 이유는 어떤형태이든 다 넘겨주기 위해서
			System.out.println(data);
		}
	}
}
