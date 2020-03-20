package c_control;

public class Ex07_break_continue {

	public static void main(String[] args) {
		
		HERE://<-이름은 자유롭게 하고 이것을 라벨이라고 하는데 자신이 나가고 싶은 블럭을 나가게 해줌
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
//				if(j==1)break;//블럭 벗어나는 문장(반복 벗어나기
//				if(j==1)continue;//블럭 끝으로 가기(반복은 수행함)
//				if(j==1)break HERE;//라벨이 붙은 블럭을 나감
				if(j==1)continue HERE;//라벨이 붙은 블럭의 끝으로 감
				System.out.println("<" + i + "," + j + ">");
			
			}
			System.out.println("데이타");
		}

	}

}
