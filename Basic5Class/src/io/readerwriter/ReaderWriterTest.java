package io.readerwriter;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReaderWriterTest {
	public static void main(String args[]) {
		UIForm3 ui = new UIForm3();
		ui.addLayout();
		ui.eventProc();
	}
}

//========================================
//	화면을 관리하는 클래스 
//----------------------------------------
class UIForm3 extends JFrame {
	JTextArea ta;
	JButton bSave, bLoad, bClear;

	UIForm3() {
		ta = new JTextArea();
		bSave = new JButton("파일저장");
		bLoad = new JButton("파일읽기");
		bClear = new JButton("화면지우기");
	}

	void addLayout() {
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		pCenter.add("Center", new JScrollPane(ta));

		JPanel pSouth = new JPanel();
		pSouth.add(bSave);
		pSouth.add(bLoad);
		pSouth.add(bClear);

		getContentPane().add("Center", pCenter);
		getContentPane().add("South", pSouth);

		setSize(400, 350);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {
		EventHandler hdlr = new EventHandler();

		bSave.addActionListener(hdlr);
		bLoad.addActionListener(hdlr);
		bClear.addActionListener(hdlr);


	}

	class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object evt = ev.getSource();

			// "화일저장" 버튼이 눌렸을 때
			if (evt == bSave) {
				JFileChooser fd = new JFileChooser();
				int returnValue = fd.showSaveDialog(null);// 그냥 null넣어준다
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File f = fd.getSelectedFile();
					try {
						/**
						 * @@@@@@@@@@@@@@@@@@@@@@@@@
						 */
						String msg = ta.getText();

						FileWriter fw = new FileWriter(f);// 선택한 파일을 가져옴
						fw.write(msg);
						fw.close();

					} catch (Exception ex) {
						System.out.println("저장 실패");
					}
				}
			}

			// "화일읽기" 버튼이 눌렸을 때
//			bLoad.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent ev) {
//					Object evt = ev.getSource();

					// "화일저장" 버튼이 눌렸을 때
					if (evt == bLoad) {
						JFileChooser fd = new JFileChooser();
						int returnValue = fd.showOpenDialog(null);// 무엇을 골랐는지 저장함//그냥 null넣어준다
						if (returnValue == JFileChooser.APPROVE_OPTION) {// 승인버튼을 눌렀을 때만
							File f = fd.getSelectedFile();// 선택한 파일을 가져옴
							try {
								/**
								 * @@@@@@@@@@@@@@@@@@@@@@@@@
								 */

								FileReader fr = new FileReader(f);// 선택한 파일을 가져옴
								char[] data = new char[1024];
								fr.read(data);

								ta.setText(String.valueOf(data));
								fr.close();

							} catch (Exception ex) {
								System.out.println("저장 실패");
							}
						}

					}
//				}
//			});
//			bClear.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
					if (evt == bClear) {
						ta.setText(null);
					}
//				}
//			});
		}
	}
}
