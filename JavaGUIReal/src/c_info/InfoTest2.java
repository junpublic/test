package c_info;

import javax.swing.*;
import java.awt.*;//Layout 때문에 필요
import java.awt.event.*;
import java.util.Calendar;

public class InfoTest2 extends JFrame{
	
	// 1. 멤버변수 선언
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit; 
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
	
	InfoTest2(){//생성자
		// 2. 객체 생성
		
		ta = new JTextArea();
		
		bAdd = new JButton("Add", new ImageIcon("src/c_info/imgs/image01.png"));
		bShow = new JButton("Show", new ImageIcon("src/c_info/imgs/image02.png"));
		bSearch = new JButton("Search", new ImageIcon("src/c_info/imgs/image03.png"));
		bDelete = new JButton("Delete", new ImageIcon("src/c_info/imgs/image04.png"));
		bCancel = new JButton("Cancel", new ImageIcon("src/c_info/imgs/image05.png"));
		bExit = new JButton("Exit", new ImageIcon("src/c_info/imgs/image06.png"));
		
		tfName = new JTextField(10);
		tfId = new JTextField(10);
		tfTel = new JTextField(10);
		tfSex = new JTextField(10);
		tfAge = new JTextField(10);
		tfHome = new JTextField(10);
		
		
		//붙이기
		
		setLayout(new BorderLayout());
		//WEST 영역
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(6,2));
		p2.add(new JLabel("Name", new ImageIcon("src/c_info/imgs/image07.png"), JLabel.CENTER));//한번만 쓸 변수는 바로 때려박자
		p2.add(tfName);
		p2.add(new JLabel("Id", JLabel.CENTER));
		p2.add(tfId);
		p2.add(new JLabel("Tel", JLabel.CENTER));
		p2.add(tfTel);
		p2.add(new JLabel("Sex", JLabel.CENTER));
		p2.add(tfSex);
		p2.add(new JLabel("Age", JLabel.CENTER));
		p2.add(tfAge);
		p2.add(new JLabel("Home", JLabel.CENTER));
		p2.add(tfHome);
		add(p2, BorderLayout.WEST);
		
		//CENTER 영역
		add(ta, BorderLayout.CENTER);
		
		//SOUTH 영역
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,6));
		p.add(bAdd);
		p.add(bShow);
		p.add(bSearch);
		p.add(bDelete);
		p.add(bCancel);
		p.add(bExit);
		add(p, BorderLayout.SOUTH);
		
		
	}
	
	void dispay(){
		// 3. 화면 구성 및 출력
		
		setLocation(200, 100);
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void eventProc() {
		//이벤트 핸들러 객체 생성
		MyEvent me = new MyEvent();
		//이벤트 연결
		bAdd.addActionListener(me);
		bShow.addActionListener(me);
		bSearch.addActionListener(me);
		bDelete.addActionListener(me);
		bCancel.addActionListener(me);
		bExit.addActionListener(me);
		
		//텍스트 필드 이벤트 구현,객체형성,연결 한큐에
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
				JOptionPane.showMessageDialog(null, tfName.getText() + "를 입력하셨습니다." );
			}
		});
		tfId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용			
				String id_num = tfId.getText();
				// (1) 주민번호에서 성별을 구하는 코딩
				char sung = id_num.charAt(7);
				if(sung == '1' || sung == '3' || sung == '9') {
					tfSex.setText("남자");
				}else if( sung == '2' | sung == '4' | sung == '0') {
					tfSex.setText("여자");
				}
				// (2) 주민번호에서 출신지를 구해서 출신지 텍스트 필드에 출력
				//char chul = id_num.charAt(8);
				String home = "";
				switch(id_num.charAt(8)) {
				default : home = "한국인"; break;
				case '0' : home = "서울"; break;
				case '1' : home = "인천"; break;
				case '2' : home = "부산"; break;
				case '3' : home = "강원"; break;
				case '4' : home = "제주도"; break;
				}
				tfHome.setText(home);
				// (3) 주민번호에서 나이를 구해서 나이 텍스트 필드에 출력
				String temp = id_num.substring(0,2);
				int nai = Integer.parseInt(temp);
				//int age = 0;
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				if(sung == '1' || sung == '2') {
					//age = year-(1900+nai)+1;
					tfAge.setText(String.valueOf(year-(1900+nai)+1));
				}
				if(sung == '3' || sung == '4') {
					tfAge.setText(String.valueOf(year-(1800+nai)+1));
				}
				if(sung == '9' || sung == '0') {
					tfAge.setText(String.valueOf(year-(2000+nai)+1));
				}
			}
		});
		
		
		
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
				JOptionPane.showMessageDialog(null, tfTel.getText() + "를 입력하셨습니다." );
			}
		});	
		
		
		
		
		tfSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
				
			}
		});
		tfAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
				JOptionPane.showMessageDialog(null, tfAge.getText() + "를 입력하셨습니다." );
			}
		});
		tfHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
				JOptionPane.showMessageDialog(null, tfHome.getText() + "를 입력하셨습니다." );
			}
		});

		
		addWindowListener(new WindowAdapter() {//WindowAdapter()(메소드가) 두 개 이상 Overriding이 될 경우 // Listener를 먼저 쓰고 Adapter쓰기

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if(result == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
				
			}
			
		});
			
	}
	
	
	
	//이벤트 핸들러	
	class MyEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {//부모가 가지고 함수가 똑같거나 크거나 해야한다 그래서 public 사용
			JButton evt = (JButton)e.getSource();//동일한 JButton이라는 형태이기에 Object형 대신 사용하여 형변환
			
			if(evt == bAdd) {
				JOptionPane.showMessageDialog(null,"입력합니다.");
			}
			if(evt == bShow) {
				JOptionPane.showMessageDialog(null, "보여줍니다.");
			}
			if(evt == bSearch) {
				JOptionPane.showMessageDialog(null, "검색합니다.");
			}
			if(evt == bDelete) {
				JOptionPane.showMessageDialog(null, "삭제합니다.");
			}
			if(evt == bCancel) {
				JOptionPane.showMessageDialog(null, "취소합니다.");
			}
			if(evt == bExit) {
				System.exit(0);//사용 종료되는 메소드 / 0은 의미 없는 수
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		InfoTest2 t = new InfoTest2();
		t.eventProc();
		t.dispay();
		

	}

}
