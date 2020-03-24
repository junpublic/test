package c_control;

import java.util.Calendar;
import java.util.Locale;

public class Ex01_if_주민번호 {

	public static void main(String[] args) {
		String id = "700725-1122355";
		int nYear;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		char sung =id.charAt(7);
		
		System.out.println(sung);
		if(sung =='1' | sung =='3' | sung =='9') {
			System.out.println("남자");	
		}
		else if(sung =='2' | sung =='4' | sung =='0') {
			System.out.println("여자");	
		}
		
		String nai = id.substring(0,2);
		int nai2 = Integer.parseInt(nai);
		
		int age = 0;
		
		if(sung == '0'| sung == '9')
			age = year - (1800 + nai2) + 1;
		else if(sung == '1'| sung == '2')
			age = year - (1900 + nai2) + 1;
		else if(sung == '3'| sung == '4')
			age = year - (2000 + nai2) + 1;
		System.out.println("나이: "+age);
	}

}
