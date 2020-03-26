package h_inherit;

public class Introduce extends Choice{
	String Kor,Eng,Jap;
	public Introduce(int LChoice, int MChoice,String Kor,String Eng,String Jap) {
		super(LChoice, MChoice);
		this.Kor = Kor;
		this.Eng = Eng;
		this.Jap = Jap;
		
	}

}
