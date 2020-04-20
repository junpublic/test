package	 view;

import java.awt.*;
import java.awt.color.CMMException;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel; 
import javax.swing.text.TabExpander;

import model.dao.VideoModel;
import model.vo.Video;


public class VideoView extends JPanel 
{	
	//	member field
	JTextField	tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
	JComboBox	comVideoJanre;
	JTextArea	taVideoContent;

	JCheckBox	cbMultiInsert;
	JTextField	tfInsertCount;

	JButton		bVideoInsert, bVideoModify, bVideoDelete;

	JComboBox	comVideoSearch;
	JTextField	tfVideoSearch;
	JTable		tableVideo;
	
	VideoTableModel tbModelVideo;
	//모델단 변수 선언
	VideoModel model;
	

	//##############################################
	//	constructor method
	public VideoView(){
		addLayout(); 	// 화면설계
		initStyle();
		eventProc();
		connectDB();	// DB연결
	}
	
	public void connectDB(){	// DB연결
		try {
			model = new VideoModel();
		} catch (Exception e) {
			System.out.println("Video 드라이버 로딩 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void eventProc(){
		ButtonEventHandler handler = new ButtonEventHandler();
		bVideoInsert.addActionListener(handler);
		bVideoModify.addActionListener(handler);
		bVideoDelete.addActionListener(handler);
		tfVideoSearch.addActionListener(handler);
		
		cbMultiInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfInsertCount.setEditable(cbMultiInsert.isSelected());
//------------------ 같은 내용				
//				if(cbMultiInsert.isSelected()) tfInsertCount.setEditable(true);
//				else tfInsertCount.setEditable(true);
//------------------ 같은 내용		
//			Object o = e.getSource();
//				if(o==cbMultiInsert) {
//					tfInsertCount.setEditable(true);
//				}
				
			}
		});
		// JTable에서 마우스 클릭시 (영화 선택시)
		tableVideo.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				int row = tableVideo.getSelectedRow();
				int vnum = (Integer)tableVideo.getValueAt(row, 0);//0은 pk(시퀀스)인 NUM
				try {
					Video vo = model.selectByPK(vnum);
					tfVideoNum.setText(String.valueOf(vo.getVideoNo()));
					comVideoJanre.setSelectedItem(String.valueOf(vo.getGenre()));
					tfVideoDirector.setText(vo.getDirector());
					tfVideoTitle.setText(vo.getVideoName());
					tfVideoActor.setText(vo.getActor());
					taVideoContent.setText(vo.getExp());
					
				} catch (Exception e1) {
					System.out.println("비디오 모델 접속 불가능" + e1.getMessage());
					e1.printStackTrace();
				} 
				
			}
		});
		
		
	}		
	
	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			
			if(o==bVideoInsert){  
				registVideo();					// 비디오 등록
			}
			else if(o==bVideoModify){  
				modifyVideo();					// 비디오 정보 수정
			}
			else if(o==bVideoDelete){  
				deleteVideo();					// 비디오 정보 삭제
			}
			else if(o==tfVideoSearch){
				searchVideo();					// 비디오 검색
			}
		}
	}
	
	// 입고 클릭시  - 비디오 정보 등록
	public void registVideo(){
		//JOptionPane.showMessageDialog(null, "입고");
		//1. 각 화면의 입력값들 얻어오기
		String genre = /*(String)*/comVideoJanre.getSelectedItem().toString();
		String vTitle = tfVideoTitle.getText();
		String vDirector = tfVideoDirector.getText();
		String vActor = tfVideoActor.getText();
		String vTa = taVideoContent.getText();
		int cnt = Integer.parseInt(tfInsertCount.getText());
		//2. Video 클래스에 멤버 변수로 지정
		Video vo = new Video();
		vo.setGenre(genre);
		vo.setVideoName(vTitle);
		vo.setDirector(vDirector);
		vo.setActor(vActor);
		vo.setExp(vTa);
		
		//3. 모델단 insertVideo(Video vo, int count)함수를 호출하여 2번의 객체 넘기기
		try {
			model.insertVideo(vo, cnt);
		} catch (Exception e) {
			System.out.println("insertvideo 호출 오류" + e.getMessage());
			e.printStackTrace();
		}
		
		//4. 화면 초기화
		tfVideoTitle.setText("");
		tfVideoDirector.setText("");
		tfVideoActor.setText("");
		taVideoContent.setText("");
		cbMultiInsert.setSelected(false);
	}
	
	public void initStyle(){   // 입력하지 못하게 만듬.
		tfVideoNum.setEditable(false);
		tfInsertCount.setEditable(false);		
		tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	// 수정 클릭시 - 비디오 정보 수정
	public void modifyVideo(){
		JOptionPane.showMessageDialog(null, "수정");
	}
	
	// 삭제 클릭시 - 비디오 정보 삭제
	public void deleteVideo(){
		
		JOptionPane.showMessageDialog(null, "삭제");
	}
	
	// 비디오현황검색
		public void searchVideo(){
			//String type = (String)comVideoSearch.getSelectedItem();
			//JOptionPane.showMessageDialog(null, "검색");
			int index = comVideoSearch.getSelectedIndex();//제목이면 0, 배우면 1
			String word = tfVideoSearch.getText();
			
			try {
				ArrayList data = model.selectVideo(index, word);
				tbModelVideo.data = data;
				tableVideo.setModel(tbModelVideo);
				tbModelVideo.fireTableDataChanged();
				
				
			} catch (Exception e) {
				System.out.println("비디오 검색 실패:" + e.getMessage());
				e.printStackTrace();
			}
		}
		
	
	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		tfVideoNum = new JTextField();
		tfVideoTitle = new JTextField();
		tfVideoDirector = new JTextField();
		tfVideoActor = new JTextField();
		
		String []cbJanreStr = {"멜로","엑션","스릴","코미디"};
		comVideoJanre = new JComboBox(cbJanreStr);
		taVideoContent = new JTextArea();
		
		cbMultiInsert = new JCheckBox("다중입고");
		tfInsertCount = new JTextField("1",5);
	
		bVideoInsert = new JButton("입고");
		bVideoModify = new JButton("수정");
		bVideoDelete = new JButton("삭제");
		
		String []cbVideoSearch = {"제목","배우"};
		comVideoSearch = new JComboBox(cbVideoSearch);
		tfVideoSearch = new JTextField(15);
		
		tbModelVideo = new VideoTableModel();
		tableVideo = new JTable(tbModelVideo);

		//*********************************************************************
		// 화면 구성
		// 왼쪽 영역
		JPanel p_left = new JPanel();
			//왼쪽 영역 센터
			JPanel p_left_c = new JPanel();
			p_left_c.setBorder(new TitledBorder("비디오 정보 입력"));
				
				JPanel p_left_c_up = new JPanel();
				p_left_c_up.setLayout(new GridLayout(5, 2));
				p_left_c_up.add(new JLabel("비디오 번호"));
				p_left_c_up.add(tfVideoNum);
				p_left_c_up.add(new JLabel("장르"));
				p_left_c_up.add(comVideoJanre);
				p_left_c_up.add(new JLabel("제목"));
				p_left_c_up.add(tfVideoTitle);
				p_left_c_up.add(new JLabel("감독"));
				p_left_c_up.add(tfVideoDirector);
				p_left_c_up.add(new JLabel("배우"));
				p_left_c_up.add(tfVideoActor);
				
				JPanel p_left_c_down = new JPanel();
				p_left_c_down.setLayout(new BorderLayout());
				p_left_c_down.add(new JLabel("설명"), BorderLayout.WEST);
				p_left_c_down.add(taVideoContent, BorderLayout.CENTER);
			
				
			p_left_c.setLayout(new BorderLayout());
			p_left_c.add(p_left_c_up, BorderLayout.NORTH);
			p_left_c.add(p_left_c_down, BorderLayout.CENTER);
			
			
			
			// 왼쪽 영역 아래
			JPanel p_left_s = new JPanel();
				JPanel p_left_s_up = new JPanel();
				p_left_s_up.setBorder(new TitledBorder("다중입력시 선택하세요"));
				p_left_s_up.add(cbMultiInsert);
				p_left_s_up.add(tfInsertCount);
				p_left_s_up.add(new JLabel("개"));
				
				JPanel p_left_s_down = new JPanel(new GridLayout (1,3));
				p_left_s_down.add(bVideoInsert);
				p_left_s_down.add(bVideoModify);
				p_left_s_down.add(bVideoDelete);
				
				
				p_left_s.setLayout(new GridLayout(2,1));
				p_left_s.add(p_left_s_up);
				p_left_s.add(p_left_s_down);
			
			
		p_left.setLayout(new BorderLayout());
		p_left.add(p_left_c, BorderLayout.CENTER);
		p_left.add(p_left_s, BorderLayout.SOUTH);
		
		
		// 오른쪽 영역
		JPanel p_right= new JPanel();
		p_right.setBorder(new TitledBorder("비디오 검색"));
		
			// 오른쪽 영역 위
			JPanel p_right_up = new JPanel();
			p_right_up.add(comVideoSearch);
			p_right_up.add(tfVideoSearch);
			
		p_right.setLayout(new BorderLayout());//센터 노스 값을 주기 위해 BORDERLAYOUT사용
		p_right.add(p_right_up, BorderLayout.NORTH);
		
		p_right.add(new JScrollPane(tableVideo), BorderLayout.CENTER);
		
		// 영역을 2개로 나눔
		setLayout(new GridLayout(1,2));
		add(p_left);
		add(p_right);
		
		
		
		
		
		
	}
	
	//화면에 테이블 붙이는 메소드 
	class VideoTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목", "배우"};

		//=============================================================
		// 1. 기본적인 TabelModel  만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		    public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }
		    
		    public String getColumnName(int col){
		    	return columnNames[col];
		    }
	}
}


