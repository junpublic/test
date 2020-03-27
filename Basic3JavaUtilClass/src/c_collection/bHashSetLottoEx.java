package c_collection;
import java.util.*;

public class bHashSetLottoEx 
{
	public static void main(String[] args) 
	{
		HashSet<Integer> lottos = new HashSet<Integer>();//숫자가 중복되지 않음 중복되면 그 숫자를 없어지게함
		while(lottos.size()<6) {//6칸이 찰때까지 돈다.
			int num = (int)(Math.random()*45+1);
		lottos.add(num);
		}
//		System.out.println(lottos);
		ArrayList<Integer> list = new ArrayList<Integer>(lottos);
		Collections.sort(list);//배열을 숫자 크기로 정렬
		System.out.println(list);
	}
}
