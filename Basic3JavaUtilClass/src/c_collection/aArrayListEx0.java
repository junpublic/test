
package c_collection;
import java.util.ArrayList;

//
class aArrayListEx0
{
	public static void main(String[] args) 
	{
		ArrayList data = dataSet();
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
		// dataSet() 안의 변수 값들을 여기서 출력한다면??
		
	}

	static ArrayList dataSet()
	{
		String	name = "김태희";
		int		age = 31;
		double	height = 162.3;

		ArrayList data = new ArrayList();//배열을 동적으로 잡아줌
		data.add(name);
		data.add(age);
		data.add(height);
		
		return data;
	}
}
