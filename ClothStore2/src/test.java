	import java.text.SimpleDateFormat;



	 
	public class test {
	    public static void main(String[] args) {
	        String nowTime = getCurrentTime("YYYY. MM. DD HH:mm:ss");
	        System.out.println(nowTime);
	    }
	    
	    public static String getCurrentTime(String timeFormat){
	        return new SimpleDateFormat(timeFormat).format(System.currentTimeMillis());
	    }
	}
	 


	
