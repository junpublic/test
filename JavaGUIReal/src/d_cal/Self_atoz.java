package d_cal;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Self_atoz extends JFrame {
	JButton [] b = new JButton[26];
	
	public Self_atoz() {
		for(int i=0; i<26; i++) {
			for(char ch='A'; ch<='A'+i; ch++) {
				b[i] = new JButton(String.valueOf(ch));	
			}
			
		}
		
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,13));
		for(int i=0; i<26; i++) {
			p.add(b[i]);
		}
		add(p, BorderLayout.CENTER);
		
	}
	public void display() {
		setSize(700,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Self_atoz s = new Self_atoz();
		s.display();
	}

}
