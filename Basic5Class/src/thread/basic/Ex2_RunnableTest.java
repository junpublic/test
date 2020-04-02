package thread.basic;

public class Ex2_RunnableTest {

	public static void main(String[] args) {
		MakeCar2 mc1 = new MakeCar2("차트만들기");
		Thread t1 = new Thread(mc1);
		t1.start();
		//run() 메소드만 채워주면 Runnable 인터페이스를 구현하는 것은 간단합니다. 하지만 Thread를 상속받은 클래스처럼 start() 메소드가 없습니다. 따라서 별도의 쓰레드를 생성 해 주고 구현한 Runnable 인터페이스를 인자로 넘겨주어야 합니다. 다음의 코드처럼요.

//		MakeCar2 mc2 = new MakeCar2("엔진부착");
//		Thread t2 = new Thread(mc2);
//		t2.start();
		

//		Thread t2 = new Thread(new MakeCar2("엔진부착"));
//		t2.start();

		 new Thread(new MakeCar2("엔진부착")).start();//위의 코드를 2단계에 걸쳐 이렇게 줄일 수 있다.

	}

}
class MakeCar2 implements Runnable{
	String work;
	MakeCar2(String work){
		this.work = work;
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