package e_mathod;

public class Ex01_호출2 {

	public static void main(String[] args) {//java의 함수들은 static를 붙여줘야 한다.
		
		System.out.println("main수 시작");
		Ex01_호출2 ex = new Ex01_호출2();
		ex.method();
		System.out.println("main함수 끝");
		
	}
	
	void method() {
		System.out.println("method 실행");
		
	}
}
/*
명명규칙
1.문자 + 숫자 + _ + $ 조합
2. 길이 제한 없음
3. 첫글자에 숫자만 아니면 됨
4. 대소문자 구별
5.예약어(keyword)는 안됨

권장사항
- 클래스명의 첫 글자는 대문자시작
-변수와 메소드명의 소문자로 시작
-라벨명은 전부 대문자
-패키지명은 전부 소문자로
*/