package e_mathod;

public class Ex06_main인자 {

	public static void main(String[] args) {
		//서버 접속
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println("위의 정보로 서버접속");

	}

}
/*직접 운영체제에서 자바 실행할 때
 *	(1)자바 컴파일( Hello.java->Hello.class)
 * 		javac Hello.java 
 *   
 * 	(2)자바 실행(Hello.class)
 * 		java Hello
 * 
 * 	문자열을 입력하면 실행
 * 		java Ex06_main인자 서버ip 서버
 */
