package f_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch {

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("data.txt");// 파일을 찾음
			System.out.println("파일 연결");
			fis.read();// 파일 읽어옴
//			fis.close();//서버는 열면 반듣이 닫아줘라. 이 줄에 오기 전에 위에서 오류를 잡아내면 종료가 안되니 finally에 넣ㅎ기

//		} catch (FileNotFoundException e) { //구체적으로 예외를 잡고 싶으면 이렇게 잡고 아니면 Exception만 해주면 다 잡음
//			System.out.println("파일없음예외:");
////			e.printStackTrace();
//		} catch (IOException e) {//입출력 예외
//			System.out.println("읽을 때 예외발생");
		}catch(Exception e) {//모든 예외를 다 잡는다.
			System.out.println("그 외 예외처리");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
			}

		}

	}

}
