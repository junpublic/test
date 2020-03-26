package e_static_sample;

public class DBConnect {
	
//	DBConnect con=null;//상관없다. 처음에는 비어있지만 if문이 한번 돌아서 con은  DBConnect의 주소값을 가르킨다.
	static DBConnect con=null;
	
	private DBConnect(){
		System.out.println("실제로 디비 연결");
	}
	
//	public void getInstance() {//con은 한번 돌고 더이상 null이 아니기 때문에 연결되어있는 주소로 간다.
//		if(con==null) con = new DBConnect(); // DBConnect의 주소값을 con에 넣기
//		
//	}
	public static DBConnect getInstance() {//con은 한번 돌고 더이상 null이 아니기 때문에 연결되어있는 주소로 간다.
		if(con==null) con = new DBConnect(); // DBConnect의 주소값을 con에 넣기
		return con;
	}
}
