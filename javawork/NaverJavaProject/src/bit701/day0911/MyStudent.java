package bit701.day0911;

public class MyStudent {
	private String name;
	private int kor,eng;
	
	//setter getter
	public void setName(String name)
	{
		this.name=name;
	}
	public void setKor(int kor)
	{
		this.kor=kor;
	}
	public void setEng(int eng)
	{
		this.eng=eng;
	}
	
	public String getName()
	{
		return name;
	}
	public int getKor()
	{
		return kor;
	}
	public int getEng()
	{
		return eng;
	}
	
	
	public MyStudent(String name,int kor,int eng) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	}
	
	//두과목의 합계를 구해서 리턴
	public int getTotal()
	{
		return kor+eng;
	}
	
	//두 과목의 평균
	public double getAverage()
	{
		return getTotal()/2.0;
	}
	
	//평균에 따른 등급 리턴
	public String getGrade()
	{
		double avg=this.getAverage();
		if(avg>=90)
		{
			return "a그룹";
		}
		else if(avg>=80)
		{
			return "b그룹";
		}
		else {
			return "탈락";
		}
	}

}
