package d_array;

import java.util.Calendar;

public class Ex03_요일 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();//
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.printf("%d 년  %d 월  %d 일",y,m+1,d);
		System.out.printf(" %d 시  %d 분  %d 초\n",hour,min,sec);
		
		String [] yoil = {"","일","월","화","수","목","금","토"};
		
		
		System.out.println(yoil[cal.get(Calendar.DAY_OF_WEEK)]+"요일");
	}

}
