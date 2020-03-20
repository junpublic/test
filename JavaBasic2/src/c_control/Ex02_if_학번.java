package c_control;

import java.util.Scanner;

public class Ex02_if_학번 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("학번을 입력하세요= ");
		
		String id = scan.nextLine();
		String de2 = "";
		String gwa2 = "";
		String year = id.substring(0,4);
		char de = id.charAt(4);
		String gwa = id.substring(5,7);
		
		
		switch(de) {
		case '1':
		de2 = "공대";
			switch(gwa) {
			case "11":
				gwa2 = "컴퓨터학과";
				break;
			case "12":
				gwa2 = "소프트웨어학과";
				break;
			case "13":
				gwa2 = "모바일학과";
				break;
			case "22":
				gwa2 = "자바학과";
				break;
			case "33":
				gwa2 = "서버학과";
				break;
				
				
			}
		break;
			
		
		case '2':
		de2 = "사회대";	

			switch(gwa) {
			case "11":
				gwa2 = "사회학과";
				break;
			case "12":
				gwa2 = "경영학과";
				break;
			case "13":
				gwa2 = "경제학과";
				break;
			}
		break;
		}
		System.out.println(id+"는 "+year+"년도에 입학한 "+de2+" "+gwa2+" 학생입니다.");
		
		
		
		
//		if(de == '1') {
//			de2 = "공대";
//			if(gwa.equals("11")) {
//				gwa2 = "컴퓨터학과";
//			}
//			else if(gwa.equals("12")) {
//				gwa2 = "소프트웨어학과";
//			}
//			else if(gwa.equals("13")) {
//				gwa2 = "모바일학과";
//			}
//			else if(gwa.equals("22")) {
//				gwa2 = "자바학과";
//			}
//			else if(gwa.equals("33")) {
//				gwa2 = "서버학과";
//			}
//		}
//		else if(de == '2'){
//
//			if(gwa.equals("11")) {
//				gwa2 = "사회학과";
//			}else if(gwa.equals("12")) {
//				gwa2 = "경영학과";
//			}else if(gwa.equals("13")) {
//				gwa2 = "경제학과";
//			}
//		}
//		System.out.println(id+"는 "+year+"년도에 입학한 "+de2+" "+gwa2+" 학생입니다.");
		
		

	}

}
