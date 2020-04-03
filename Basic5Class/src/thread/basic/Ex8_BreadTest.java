package thread.basic;
/*
 * 대기실에 들어오는 start
 * 진짜 시작은 run
 * sleep 은 얼마동안 올려보냄
 * wait 는 그냥 올려보냄
 * notifyAll 은 wait로 자고있는 놈들을 다꺠워서 다시 돌려보냄
 * 우선순의를 자바는 딱 정해준대로 하지만  자바가 윈도우 위에서 도는데 윈도우는 기회를 골고루 준다 그래서 우리가 원하는대로 되지 않는다.
 */

class Bread 
{
	String bread;

	//##  	
	boolean isCheck = false;

	public void setBread( String bread )
	{
		this.bread = bread;
		//## 		
		isCheck = true;
		synchronized (bread) {
			
			notifyAll();
		}	
	}

	public String getBread()
	{
		//## 	
		if(!isCheck) {
			try {
				synchronized (bread) {		
					wait();
				}
			} catch (Exception e) {}
		}

		return bread;
	}
}

class Baker extends Thread
{
	Bread bbang;

	Baker( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		bbang.setBread("진열된 완성된 맛있는 빵");
	}
}

class Customer extends Thread
{
	Bread bbang;

	Customer( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		System.out.println("빵을 사감 : " + bbang.getBread());
	}
}

class Ex8_BreadTest
{
	public static void main(String[] args) 
	{
		Bread  bread = new Bread();

		Baker  baker = new Baker( bread );
		Customer customer = new Customer( bread );
		customer.start();
		baker.start();

		try{
			customer.join();
			baker.join();			
		}catch( Exception ex ){}

	}
}
