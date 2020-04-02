package thread.basic;

public class Ex1_ThreadTest {

	public static void main(String[] args) {
		MakeCar1 work1 = new MakeCar1("차만들기");
		work1.start();
		
		MakeCar1 work2 = new MakeCar1("엔진부착");
		work2.start();

	}

}
class MakeCar1 extends Thread{
	String work;
	
	MakeCar1(String _work){//this를 쓰지 않기 위해 이렇게도 한다.
		work = _work;
		
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(work + "작업중");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
//멀리프로개래밍 비슷(멀티쓰레드)

//1. Thread 상속 또는 Runnable 구현
//2.run() 오버라이딩
//3. run()호출: start()->run() ghcnfehla
