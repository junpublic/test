package f_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex03_throws {

	public static void main(String[] args) {
		try {
		readFile();
		System.out.println("파일처리 성공");
		}catch(Exception ex) {
			System.out.println("실패");
		}
	}
	static void readFile() throws Exception{//발생하는 오류를 데이터를 불러온 곳으로 떠넘김
		FileInputStream fis = new FileInputStream("abd.txt");// 파일을 찾음
		System.out.println("파일 연결");
	}
}
