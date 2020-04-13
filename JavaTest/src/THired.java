import java.util.Scanner;


class bank {
	
	
	String who = "자바맨";
	String num = "123-456";
	int left = 10000;	
	
	
	public int moneyIn(int minus){
		
		
		left -= minus;
		if(left < 0) {
			System.out.println("잔액이 부족합니다.");
		}else {
			System.out.println(left);
		}
		
		return left;
    }
	public int moneyOut(int pluse){
		Scanner sc = new Scanner(System.in);
		
		left += pluse;
		System.out.println(left);
		return left;
    }

	public String toString() {
		return "예금주:"+who+", "+"계좌번호:"+num+", "+"잔액:"+left+"원";
	}
}


public class THired {

	public static void main(String[] args) {
		bank b = new bank();
		
		Scanner sc = new Scanner(System.in);
		
		int minus =sc.nextInt();
		b.moneyIn(minus);
		int pluse =sc.nextInt();
		b.moneyOut(pluse);
		
		
		
		System.out.println(b.toString());
		
	}

	
}

