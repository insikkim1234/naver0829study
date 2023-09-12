package bit701.day0912;

public class Sungjuk {
	private String name;
	private int kor;
	private int eng;
	
	//생성자로 읽고source generate oconstrucctor 

	public Sungjuk(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	//gettter 생성
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}
	
	
}