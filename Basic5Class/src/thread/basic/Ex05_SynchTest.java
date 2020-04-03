package thread.basic;

class Count{
	int i;
	void increment() {//synchronized tc1이 실행하는 동안 다른놈들은 접근 못한다.//동기화
		synchronized (this) {//()안에 객체를 줘야 하는데 없어서 this를 해줌
			i++;
		}
		//다른 코딩이 많으면 동기화가 필요한 프로그램에게만 synchronized해줘야 한다.
		
	}
}

class ThreadCount extends Thread{
	
	Count cnt;
	
	ThreadCount(Count cnt){
		this.cnt = cnt;
	}
	
	public void run() {
		for(int i=0;i<100000000;i++) {
			cnt.increment();
		}
	}
}

public class Ex05_SynchTest {

	public static void main(String[] args) {//메인 쓰레드
		Count cnt = new Count();
		ThreadCount tc1 = new ThreadCount(cnt);//2번쨰 쓰레드
		tc1.start();//run함수를 부르려면 start해줘야한다.
		ThreadCount tc2 = new ThreadCount(cnt);//3번째 쓰레드
		tc2.start();
		
		try {
			tc1.join();//쓰레드가 끝날때까지 기다려줘
			tc2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("i의 결과:"+cnt.i);
	}
	

}
