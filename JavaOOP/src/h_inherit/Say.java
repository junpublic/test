package h_inherit;

public class Say extends Choice{
	String Kor,Eng,Jap;
	public Say(int LChoice, int MChoice,String Kor,String Eng,String Jap) {
		super(LChoice, MChoice);
		this.Kor = Kor;
		this.Eng = Eng;
		this.Jap = Jap;
		
	}

}
