import java.util.Calendar;

public class First {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int year = 1997;
		int age = cal.get(Calendar.YEAR)-year;
		System.out.println(age + " " + year);
		
	
	}

}
