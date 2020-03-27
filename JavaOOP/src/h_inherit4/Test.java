package h_inherit4;

public class Test {

	public static void main(String[] args) {
		
		Item [] item =method();
		for(int i = 0;i<item.length;i++) {
			item[i].output();
		}
	}
	static Item[] method() {
		
//		Item z = new Item();//미완성은 객체생성을 못함
		
		Book b = new Book("001","자바","홍길동","코스모");
		Cd c = new Cd("002","아무노래","지코");
		Dvd d = new Dvd("003","킹덤","배두나","김은희");
		
		Item [] i = new Item[3];//서로다른 데이터 타입을 한번에 넘겨줄 수 없어서 item클레스 베열을 만들어 거기에 넣어준다.
		i[0] = b;
		i[1] = c;
		i[2] = d;
		
		return i;
	}
}
