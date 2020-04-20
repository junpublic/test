import java.util.Scanner;

class bank {
	String yegumju = "홍길동";
	String gejwa="111-111-111";
	int left=10000;
	
	int out(int minus){
		if(left < minus){
			left -= minus;
		}else if ((left -= minus)<0){
		System.out.println("잔액이 부족합니다.");
		
		}
		return left;
		
	}
	int in(int plus) {
		left += plus;
		System.out.println(plus);
		return left;
		
	}
	
	public String toString() {
		
		return "예금주:"+ yegumju+",계좌번호:"+gejwa +", 잔액:"+left +"원";
		
	}
	
}

public class THired {
	
	public static void main(String[] args) {
		bank b = new bank();
		int plus = 20000;
		int minus = 30000;
		
		
		b.in(plus);
		b.out(minus);
		System.out.println(b.toString());
		
	}
	
}
