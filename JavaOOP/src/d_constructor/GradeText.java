package d_constructor;

import java.awt.geom.GeneralPath;
import java.util.Scanner;

import c_array.Student;

public class GradeText {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("명수를 입력하세요: ");
		int num = input.nextInt();
		int [] jumsu = new int[num];
		
		
		System.out.print("점수를 입력하세요");
		for(int i=0;i<jumsu.length;i++) {
			jumsu[i] = input.nextInt();//클래스를 위한 객체 생성
		}
		GradeExpr ge = new GradeExpr(jumsu);
		System.out.println("총점: "+ge.getTotal());
		System.out.println("평균: "+ge.getAverage());
		System.out.println("최고 점수: "+ge.getGoodScore());
		System.out.println("최소 점수: "+ge.getBadScore());
		
		

	}

}
