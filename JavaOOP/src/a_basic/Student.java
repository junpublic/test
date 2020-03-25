package a_basic;

public class Student {
	//멤버변수(member field)
	String name;
	int kor,eng,math;
	private int total;//private를 넣어서 외부에서 변경 불가하게 만든다.
	double avg;
	
	//멤버함수(member method/ member function)
	int calTotal() {
		total = kor +eng + math;
		return total;
	}
	
	double calAvg() {
		avg = (double)total/3;
		return avg;
	}
}
