package bit701.day0914;

public class Student {
	//private으로 이름 점수 혈액형 받기
	private String name;
	private int score;
	private String blood;
	
	//빈 생성자 Student()
	public Student() {
		
	}

	//source generate constructor using fieled
	public Student(String name, int score, String blood) {
		super();
		this.name = name;
		this.score = score;
		this.blood = blood;
	}
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}
	
	
	
	

}
