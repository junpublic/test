package c_control;

public class Text {

	public static void main(String[] args) {
		int n = 1;
		  int sum = 0;
		  while( true ){
		     sum += n;
		     if ( n++   >=   10 ) break;
		  }
		  System.out.println("SUM = " + sum );
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print("<" + i + "," + j + ">");
//			}
//			System.out.println();
//		}
		
////		 int i = 0, j = 0;
////
////	      for( i = 0 ; i < 5 ; i++ ) {
////
////	         for( j = 0 ; j < 4 ; j++ ) {
////
////	             if( i == 2 && j == 1 ) break;
////
////	             if( i == 3 && j == 2 ) continue;
////
////	         }
////
////	      }
//
//	           System.out.println("i = " + i + " , j = " +  j );
//		int i = 2, j = 0;
//		switch (i) {
//		case 2:
//			j += 6;
//		case 4:
//			j += 1;
//		default:
//			j += 2;
//		case 0:
//			j += 4;
//		}
//		System.out.println(j);
//		//i가 1이면 default로 간 다음 거기서부터 밑에까지 쭉 더하고
////		i가 2면 처음부터 쭉 더함
	}

}
