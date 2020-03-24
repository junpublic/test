package c_control;

public class Ex04_for_중첩 {

	public static void main(String[] args) {
		
//		for(int i=0;i<5;i++) {
//			for(int k=0;k<i;k++) {
//				System.out.print(" ");
//				
//			}
//			for(int k=0;k<5-i;k++) {
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
		
		//===================================
		//A-Z한줄에 출력
		//위의 문자들을 26줄 출력
		//문제1 )
//		for(int i =0;i<26;i++) {
//			for(char ch = 'a';ch<='a'+i;ch++) {
//				System.out.print(ch);
//			}
//			System.out.println();
//		}
		
		//===================================		
		//문제2 )
//		for(int i =0;i<26;i++) {
//			for(char ch = 'a';ch<='z'-i;ch++) {
//				System.out.print(ch);
//			}
//			System.out.println();
//		}
		//===================================		
		//문제3 )
//		for(int i =0;i<26;i++) {
//			for(char ch = (char)('a'+i);ch<='z';ch++) {
//				System.out.print(ch);
//				
//			}
//			System.out.println();
//		}
//		
		//===================================	
		//문제4 )
//		for(int i =26;i>0;i--) {
//			for(char ch = 'z';ch>='a'+i-1;ch--) {
//				System.out.print(ch);
//			}
//			System.out.println();
//		}
//		
		//===================================	
		//문제5 )
//		for(int i =0;i<26;i++) {
////			for(int j =0;j<i;j++) {
////				System.out.print(" ");
////			}
//			for(char ch = (char)('a'+i);ch<='z';ch++) {
//				System.out.print(ch);
//				
//			}
//			System.out.println();
//		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(i+j+" ");
			}
			System.out.println();
		}
	}

}
