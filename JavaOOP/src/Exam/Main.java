package Exam;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("언어선택 1)한국 2)일본 3)영어");
		int sel = input.nextInt();
		System.out.println("메세지선택 1)인사 2)자기소개 3)하고픈말");
		int sel2 = input.nextInt();
		Lang lang = null;

		switch (sel) {
		case 1:
			lang = new Kor();		
			break;
		case 2:
			lang = new Jap();
			break;
		case 3:
			lang = new Eng();
			break;
		}
		switch (sel2) {
		case 1:
			lang.greeting();
			break;
		case 2:
			lang.introduce();
			break;
		case 3:
			lang.hago();
			break;
		}

	}
}
