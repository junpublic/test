package y_kyochon;

public class chicken{
	private String chickenName;
	private int chickenPrice;
	
	chicken(String chickenName,int chickenPrice){
		this.chickenName = chickenName;
		this.chickenPrice = chickenPrice;
	}

	public String getChickenName() {
		return chickenName;
	}

	public void setChickenName(String chickenName) {
		this.chickenName = chickenName;
	}

	public int getChickenPrice() {
		return chickenPrice;
	}

	public void setChickenPrice(int chickenPrice) {
		this.chickenPrice = chickenPrice;
	}
	
	
}