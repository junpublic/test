package f_numbergame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGameTest {

	public static void main(String[] args) {
		NumberGame ng = new NumberGame();
		ng.initChar();
		ng.showAnswer();//함수 호출
		

	}

}

class NumberGame extends JFrame implements ActionListener{//화면 구성용
	int getsu = 4;
	
	// 1. 멤버변수 선언
	JButton [][] b = new JButton [getsu][getsu];
	
	
	
	//2. 버튼위에 지정할 문자 변수
	char []	[] answers = new char [getsu][getsu];// heap에 잡혀 자동 초기화 : char '\0000' 기본 디폴트 값
	
	
	
	//5. 첫번째 버튼에 대한 저장
	JButton firstClick;
	int firstRow, firstCol;
	
	public NumberGame() {
		// 2. 객체 생성
		// 3. 화면 구성
		setLayout(new GridLayout(4,4));//붙이기 전에 판의 모형을 만들어야 하며, 반복이 되지 않도록 반복문 앞에 위치
		for(int row=0; row<getsu; row++) {
			for(int col=0; col<getsu; col++) {//여기까지는 배열의 형태만 만듬 안에는 null값이 들음
				b[row][col] = new JButton(row + ":" + col);//b[i][j] 배열에 i:j라는 값을 넣음
				add(b[row][col]);//화면에 올림
				
				// 문자 배열을 0으로 초기화
				answers[row][col] = '0';
				
				// 이벤트 연결
				b[row][col].addActionListener(this);
			}
		}
		
		//화면에 출력
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	// 임의의알파벳을 임의의 위치에 지정
	void initChar() {
		char alpha = '0';
		BACK:
		for(int i=0; i<getsu*getsu;) {//알파벳이 입력될 위치 16곳
			
			// 임의의 알파벳 만들기 16칸 중 절반의 개수(똑같은게 2개이니)
			if(i%2 == 0) {
				alpha = (char)('A'+(int)(Math.random()*26));// (char)('A'+0) = 'A', (char)('A'+1) = 'B', (char)('A'+2) = 'C' 처럼 만들어짐
				
				// 기존에 이미 이 알파벳이 있는지 확인
				for(int k=0; k<getsu; k++) {//전체의 가지수를 모두 돌려 보는 2중 for문
					for(int j=0; j<getsu; j++) {
						if(answers[k][j] == alpha) continue BACK;//중복값이 나온다면 다시 알파벳 생성을 지시 // continue는 현재의 반복문에서 다시 반복하게 함으로 Label(BACK)을 붙여 알파벳을 생성하는 반복문으로 이동시킨다.
					}
				}
			}
			
			// 임의의 위치 선정하기
			boolean ok = false;//ok변수가 true가 되는 순간 멈춤
			do {
				int row = (int)(Math.random()*getsu);//0,1,2,3 아무거나
				int col = (int)(Math.random()*getsu);
				
				if(answers[row][col] == '0') {
					answers[row][col] = alpha;
					
					i++;
					ok = true;
				}
				
			}while(!ok);
			
		}
		
	}
	void showAnswer() {
		// 답을 보여주기
		for(int row=0; row<b.length; row++) {
			for(int col=0; col<b[row].length; col++) {
				b[row][col].setText(String.valueOf(answers[row][col]));//캐스팅 하려면 상속관계에 있거나 (캐스팅의 조건)
			}
		}
		
		
		
		
		// 1분 후에 답 가리기
//		try {
//			Thread.sleep(3000);//지연을 준다
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<4; j++) {
//				b[i][j].setText("");//b[i][j] 배열에 들어있던 i:j 값 대신 ""값을 넣음
//			}
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();
		for(int r=0; r<getsu; r++) {
			for(int c=0; c<getsu; c++) {
				if(b[r][c] == evt) {
					//첫번째 선택인지 확인
					if(firstClick == null) {
					firstClick = evt;//현재 눌러진 버튼값을 저장
					firstRow = r;
					firstCol = c;
					evt.setBackground(Color.cyan);
					evt.removeActionListener(this);//첫번째로 누르고 이벤트 객체를 제거
					}else{// 두번째 선택
						if(answers[firstRow][firstCol] == answers[r][c]) {//첫번째 누른 값과 두번째 누른 값이 같다면
							firstClick.setBackground(Color.red);
							evt.setBackground(Color.red);
							
							
							
						}else {
							firstClick.setBackground(null);
						}
						
						firstClick.addActionListener(this);//첫번째로 누르고 이벤트 객체를 제거
						firstClick = null;
					}
					}
			}
		}
		System.out.println("이벤트 확인");
		
	}
}
