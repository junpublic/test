package h_inherit;

import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Choice Lchoice = null;
		Choice Mchoice = null;
		 Hello hello ;
		 Introduce introduce;
		 Say say;
		 Scanner input = new Scanner(System.in);
		  System.out.println("언어선택(1. kor  2.eng   3.math");
		  int LChoice = input.nextInt();
		  System.out.println("메세지(1.인사말  2.자기소개   3.하고싶은말");
		  int MChoice = input.nextInt();
		  //1)부모변수에 자식생성 가능함(상속관계)
		  switch(LChoice) {
		  case 1: hello = new Hello(LChoice,MChoice,"안녕하세요","Hello","곤니치와"); break;
		  case 2: introduce = new Introduce(LChoice,MChoice,"내 이름은 정준","My name is jun","와타시와 정준"); break;
		  case 3: say = new Say(LChoice,MChoice,"ㅂㅂ","bye bye","사요나라"); break;
		  }
		  // 출력*****
		 
		  
		  switch(MChoice) {
		  case 1: Hello.output(); break;
		  case 2: Introduce.output(); break;
		  case 3: Say.output(); break;
		  }
		 //2)overriding
		  i.output();
	}
}
