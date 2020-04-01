package c_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class InfoText2 extends JFrame{
	//1.멤버변수 선언
	
	JTextArea ta;
	JButton bAdd,bShow,bSearch,bDelete,bExit,bCancel;
	JTextField tfName,tfId,tfTel,tfSex,tfAge,tfHome;
	InfoText2(){
		//2.객체 생성
		
		ta = new JTextArea();
		bAdd = new JButton("Add",new ImageIcon("src/c_info/imgs/1.PNG"));
		bShow= new JButton("Show",new ImageIcon("src/c_info/imgs/2.PNG"));
		bSearch= new JButton("Search",new ImageIcon("src/c_info/imgs/3.PNG"));
		bDelete= new JButton("Delete",new ImageIcon("src/c_info/imgs/4.PNG"));
		bExit= new JButton("Exit",new ImageIcon("src/c_info/imgs/5.PNG"));
		bCancel= new JButton("Cancel",new ImageIcon("src/c_info/imgs/6.PNG"));
		
		tfName = new JTextField(10);
		tfId= new JTextField(10);
		tfTel= new JTextField(10);
		tfSex= new JTextField(10);
		tfAge= new JTextField(10);
		tfHome= new JTextField(10);
	}
	void display(){
		//3.화면 구성 및 출력
		//왼쪽
		JPanel l = new JPanel();
			l.setLayout(new GridLayout(6,2));
			l.add(new JLabel("Name",new ImageIcon("src/c_info/imgs/7.PNG"),JLabel.CENTER));
			l.add(tfName);
			l.add(new JLabel("ID",new ImageIcon("src/c_info/imgs/8.PNG"),JLabel.CENTER));
			l.add(tfId);
			l.add(new JLabel("Tel",new ImageIcon("src/c_info/imgs/9.PNG"),JLabel.CENTER));
			l.add(tfTel);
			l.add(new JLabel("Sex",new ImageIcon("src/c_info/imgs/10.PNG"),JLabel.CENTER));
			l.add(tfSex);
			l.add(new JLabel("Age",new ImageIcon("src/c_info/imgs/1.PNG"),JLabel.CENTER));
			l.add(tfAge);
			l.add(new JLabel("Home",new ImageIcon("src/c_info/imgs/2.PNG"),JLabel.CENTER));
			l.add(tfHome);
		

		
		
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(1,6));
			p.add(bAdd);
			p.add(bShow);
			p.add(bSearch);
			p.add(bCancel);
			p.add(bDelete);
			p.add(bExit);
		
		
		add(ta,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		add(l,BorderLayout.WEST);
		
		setLocation(200,100);
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//이렇게 안나가게 바꿔줘야 안나
			
	}
	public void eventProc() {
		//(2)이벤트 핸들러 객체 생성
		MyEvent me = new MyEvent();
		
		//(3)이벤트 연결
		bAdd.addActionListener(me);
		bShow.addActionListener(me);
		bCancel.addActionListener(me);
		bSearch.addActionListener(me);
		bDelete.addActionListener(me);
		bExit.addActionListener(me);
		//텍스트 필드 이벤트 처리
		tfName.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{//이름없는 클래스를 버튼에 넣어버림?
					@Override
					public void actionPerformed(ActionEvent e) {	
							String msg = tfName.getText();
							JOptionPane.showMessageDialog(null, msg + " 입력됨");						
					}		
				});
		tfId.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{
					@Override
					public void actionPerformed(ActionEvent e) {	
							String id = tfId.getText();
							char sung =id.charAt(7);
							Calendar cal = Calendar.getInstance();
							int year = cal.get(Calendar.YEAR);
							
							//성별 출력
							System.out.println(sung);
							if(sung =='1' | sung =='3' | sung =='9') {
								tfSex.setText("남자");
							}
							else if(sung =='2' | sung =='4' | sung =='0') {
								tfSex.setText("여자");
								
								
							}
							char chul = id.charAt(8);
							
							//지역명 출력
							switch(chul) {
							case '0' :tfHome.setText("서울");
								break;
							case '1' :tfHome.setText("인천/부산");
								break;
							case '2' :tfHome.setText("경기도");
								break;
							}
							
							
							String nai = id.substring(0,2);
							int nai2 = Integer.parseInt(nai);
											
							if(sung == '0'| sung == '9')
								tfAge.setText(Integer.toString(year - (1800 + nai2) + 1));
							else if(sung == '1'| sung == '2')
								tfAge.setText(Integer.toString(year - (1900 + nai2) + 1)); 
							else if(sung == '3'| sung == '4')
								tfAge.setText(Integer.toString(year - (2000 + nai2) + 1)); 
							
							
					}		
				});
		tfTel.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{
					@Override
					public void actionPerformed(ActionEvent e) {	
							String msg = tfTel.getText();
							JOptionPane.showMessageDialog(null, msg + " 입력됨");						
					}		
				});
		tfSex.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{
					@Override
					public void actionPerformed(ActionEvent e) {	
							String msg = tfSex.getText();
							JOptionPane.showMessageDialog(null, msg + " 입력됨");						
					}		
				});
		tfAge.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{
					@Override
					public void actionPerformed(ActionEvent e) {	
							String msg = tfAge.getText();
							JOptionPane.showMessageDialog(null, msg + " 입력됨");						
					}		
				});
		tfHome.addActionListener(new ActionListener()//MyEvent는 변수같은 클래스여서 안넣어도됨,그냥 넣어버려도 된다.
				{
					@Override
					public void actionPerformed(ActionEvent e) {	
							String home = tfHome.getText();
							
											
					}		
				});
		//윈도우 x버튼 눌렀을 떄 의 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "진짜 나가시겠습니까?");
				if(result == JOptionPane.OK_OPTION)
					System.exit(0);
				
			}
		});

			

		
			
		
		

	}
	class MyEvent implements ActionListener{//이벤트 핸들러를 따로 만들어서 객체를 생성해서 불러옴

		@Override
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();// 어떤 이벤트가 발생할지 모르기 때문에 오브젝트로 받음
			if (evt == bAdd) {
				String msg = bAdd.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 입력");
			} else if (evt == bShow) {
				String msg = bShow.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 입력");
			} else if (evt == bSearch) {
				String msg = bSearch.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 입력");
			} else if (evt == bCancel) {
				String msg = bCancel.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 입력");
			} else if (evt == bDelete) {
				String msg = bDelete.getText();
				JOptionPane.showMessageDialog(null, msg + "버튼 입력");
			} else if (evt == bExit) {
				System.exit(0);//의미없는 숫자 넣어줌
			} 


		}		
	}
	public static void main(String[] args) {
		InfoText2 t = new InfoText2();
		t.display();//함수 부르기
		t.eventProc() ;
	}

}
