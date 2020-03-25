package d_constructor;

public class GradeExpr {

	private  int []jumsu;

	
	public GradeExpr(int[] jumsu) {
		this.jumsu = jumsu;
	}
	double getAverage(){
		return getTotal()/jumsu.length;
	}
	int getTotal() {
		int total=0;
		for(int i=0;i<jumsu.length;i++) {
			total +=jumsu[i];
		}
		return total;
	}
	int getGoodScore() {
		int a;
		for(int i=0;i<jumsu.length;i++) {
			for(int j=0;j<jumsu.length-i-1;j++) {
				if(this.jumsu[i]>jumsu[i+1]) {
					a = jumsu[i];
					jumsu[i] = jumsu[i+1];
					jumsu[i+1] = a;

				}
			}
		}
		return jumsu[jumsu.length-1];
	}
	int getBadScore() {
		int a;
		for(int i=0;i<jumsu.length;i++) {
			for(int j=0;j<jumsu.length-i-1;j++) {
				if(this.jumsu[i]>jumsu[i+1]) {
					a = jumsu[i];
					jumsu[i] = jumsu[i+1];
					jumsu[i+1] = a;

				}
			}
		}
		return jumsu[0];
	}
}
