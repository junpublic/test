
public class Second {

	public static void main(String[] args) {
		int num=0;
		int num1=0;
		
		for(int i=1;i<=100;i++) {
			if((i%3!=0 || i%5!=0)) {
				num+=i;
			}			
		}
		
		int j=1;
		while(j<=100) {
			if(j%3!=0 || j%5!=0) {
				num1+=j;
			}
			j++;
		}
		System.out.println(num);
		System.out.println(num1);

	}

}
