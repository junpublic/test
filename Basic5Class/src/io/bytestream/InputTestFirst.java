package io.bytestream;

/*
	======================================================
	InputStream을 구현한 FileInputStream을 이용한 예
	======================================================
	
	@ int read()
		` 한 바이트를 읽고 이를 0-255사이의 값을 리턴하지만4byte의 int 형으로 리턴
		` 리턴되는 값은 0-255 부호없는 바이트이지만 형변환 과정에서 -128 ~127의 부호 있는 바이트가 된다
		
		
		` 데이타를 읽어들이기 전까지 기다리므로 다른 부분을 실행할 수가 없다
			-> 쓰레드 적용 필요
			
		` 더이상 읽을 바이트가 없으면 -1 리턴
		
		
		
		[ 참고 ]
			int i =  b >= 0 ? b : 256 + b;
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputTestFirst
{
	public static  void main( String args[] ) 
	{
		//1. a.txt 파일에서 읽을 수 있는 스트림을 생성
		//2. 스트림을 통해 하나씩 읽어서 화면에 출력
		try
		{
			FileInputStream fos = new FileInputStream("C:\\Users\\KOSMO_29\\git\\test\\Basic5Class\\a.txt");//파일을 출력하는 통로 만듬

//			for(int i=0;i<26;i++)
//				System.out.print((char)fos.read());
			
			//파일이 끝날때(EOF(end of file)= -1)까지 읽기 //왜 통로는 바이트형으로 데이트를 주고받는데 왜 인트형을 반환하는가? 데이터의 끝에 -1이 있어서 그걸 읽으려고 int형으로 반환
			while(true) {
				int data = fos.read();
				if(data==-1) break;
				System.out.print((char)data);
			}
			
				
			fos.close();//통로를 사용했으면 반듯이 닫아줘야 한다.
			
		}catch(FileNotFoundException e) {
			System.out.println("화일이 존재하지 앖습니다.");
		}catch( IOException ex ){
			System.out.println("읽기실패");
		}
	
		
		
	}	
}

/*
	======================================
		결과 출력
	======================================

	` 숫자만 나오는데, 우선 열개만 읽어서 숫자 자체로 출력하고
	나머지는 읽어서 (char) 형변환 하면 문자로 출력될 것이
*/