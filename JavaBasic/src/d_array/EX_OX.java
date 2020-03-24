package d_array;

import java.util.Scanner;

public class EX_OX {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int su = input.nextInt();
		System.out.println(su);

		for (int j = 0; j < su; j++) {
			Scanner in = new Scanner(System.in);
			char[] ch = in.nextLine().toCharArray();

			int Rpoint = 0;
			int cnt = 0;
			for (int i = 0; i < ch.length; i++) {

				if (ch[i] == 'O') {// 만약 비교 값이 'O'라면
					cnt++;
					Rpoint += cnt;

				} else {
					cnt = 0;
				}

			}
			System.out.println(Rpoint);
		}
	}

}

