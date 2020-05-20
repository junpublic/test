package info.beans;

//Bean == VO
public class infoBean {
	//property = 멤버변수
	private String name;//변수명은 소문자
	private String id;//화면에 있는 것과 같은 변수명을로 만들어줌
	
	private int getsu;
	private boolean flag;
	
	public int getGetsu() {
		return getsu;
	}

	public void setGetsu(int getsu) {
		this.getsu = getsu;
	}

	public boolean isFlag() {//boolean 은 is로 만들어짐 그레도 부를 수 있음
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getGender() {//어쩔수 없이 따로 만들었음
		String gender = "";
		char sex = id.charAt(6);
		if(sex=='1'|sex=='3')return "남자";
		else return "여자";
	}
}
