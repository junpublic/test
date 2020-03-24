package e_mathod;

public class Ex03_인자와반환3 {

	public static void main(String[] args) {
		
		int[] arr = add();
		//데이터를 넘겨받아 합을 구하고 출력
		int sum = arr[0]+arr[1];
	}

	static int [] add() {//배열을 넘길때는 자료형을 배열과 같게 해 주어야 한다.
		// 입력데이타
		int a = 10, b = 20;
		int [] arr = {a,b};
		return arr;

	}
}
