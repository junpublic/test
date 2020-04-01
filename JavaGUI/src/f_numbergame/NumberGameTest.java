package f_numbergame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NumberGameTest {

	public static void main(String[] args) {
		NumberGame game = new NumberGame();
		game.inintChar();
		game.showAnswer();
	}

}

class NumberGame extends JFrame implements ActionListener{
	int getsu = 4;

	// 1.멤버 변수
	JButton[][] b = new JButton[getsu][getsu];

	// 2.버튼위에 지정할 문자 변수
	char[][] answers = new char[getsu][getsu];// char = '\u0000'이 저장됨
	
	
	//5.첫번째 버튼에 대한 저장
	JButton firstClick;
	int firstRow,firstCol;

	void inintChar() {
		char alpha = '0';
		
		BACK:
		for (int i = 0; i < getsu * getsu;) {
			// 임의의 알파벳 만들기
			if (i % 2 == 0) {
				alpha = (char) ('A' + (int) (Math.random() * 26));
				System.out.println(alpha);
				
				//중복검사
				for(int r =0;r<getsu;r++) {
					for(int  c=0;c<getsu;c++) {
						if(answers[r][c] == alpha) continue BACK;
					}
				}

			}
			boolean ok = false;
			do {
				int row = (int) (Math.random() * getsu);// 0,1,2,3 아무거나
				int col = (int) (Math.random() * getsu);
				
				//빈칸에 알파벳 넣어줌
				if (answers[row][col] == '0') {
					answers[row][col] = alpha;
					i++;
					ok = true;
				}
			} while (!ok);
		}
	}

	NumberGame() {

		// 임의의 알파벳을 임의의 위치에 지정

		// 객체 생성
		// 화면구성
		setLayout(new GridLayout(4, 4)); // 그냥 그리드로 나누면 전체 화면을 나눠버림
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[row].length; col++) {
				b[row][col] = new JButton(row + ":" + col);
				add(b[row][col]);

				// 문자배열을 0으로 초기화
				answers[row][col] = '0';
				
				//이벤트연결
				b[row][col].addActionListener(this);
			}
		}
		// 화면 출력
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void showAnswer() {
		// 답을 보여주기
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[row].length; col++) {

				b[row][col].setText(String.valueOf(answers[row][col]));// 스트링은 객체이기 때문에 캐스팅이 안됨 이렇게 해줘야 넣어줄 수 있음
			}
		}

		// 일분 후에 답 가리기

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[row].length; col++) {
				b[row][col].setText(null);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton evt = (JButton)arg0.getSource();
		for(int r=0;r<getsu;r++) {
			for(int c=0;c<getsu;c++) {
				if(b[r][c] ==evt) {
					//첫번쨰 선택인가?
					if(firstClick == null) {
						firstClick = evt;
						firstRow = r;
						firstCol = c;
						evt.setBackground(Color.CYAN);
						evt.removeActionListener(this);//처리가 되면 리스너를 제거해버림
					}else {//두번째 선택이라면
						if(answers[firstRow][firstCol] == answers[r][c]) {
							firstClick.setBackground(Color.RED);
							evt.setBackground(Color.RED);
						}else {
							firstClick.setBackground(null);
						}
						firstClick.addActionListener(this);//제거한 리스너를 다시 추가
						firstClick = null;
						
					}
				}
			}
		}
	}
}
