package d_constructor;

import java.util.Scanner;


public class MainArray {
	
	/**
	 * 	3명의 학생 정보를 입력받아 각 학생별 총점 평균을 구한다면
	 */
	
	public static void main(String[] args) {
//		Student[] stu = new Student[3];
		for(int i=0;i<3;i++) {
			Scanner in = new Scanner(System.in);
			System.out.print("이름->");
			String name = in.next();
			System.out.print("국어점수->");
			int k = in.nextInt();
			System.out.print("영어점수->");
			int e = in.nextInt();
			System.out.print("수학점수->");
			int m = in.nextInt();
			
			Student stu = new Student();
//			stu[i] = new  Student(name,k,e,m);
			System.out.println("총점: "+stu.calTotal());
			System.out.println("평균: "+stu.calAverage());
		}
//		for(int i=0;i<3;i++) {
////			System.out.println(stu[i].getName()+" 총점: "+ stu[i].calTotal()+ " 평균: "+stu[i].calAverage());
//			
//		}
		
				
		// 추가적으로 각 과목별 총점을 구한다면?
				
	}

}
