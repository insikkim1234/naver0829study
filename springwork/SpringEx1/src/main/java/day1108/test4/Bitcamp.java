package day1108.test4;

import lombok.Setter;

//(7)setter불러오기
@Setter
public class Bitcamp {
	//(6)Student클래스와 Sawon클래스 불러오기
	private Student stu;
	private Sawon sawon;
	
	//(8)출력 틀을 만들기 위한 infoProcess()함수 생성
	public void infoProcess()
	{
		System.out.println("** 학생정보 **");
		System.out.println("이름:"+stu.getName());
		System.out.println("혈액형:"+stu.getBlood());
		System.out.println("나이:"+stu.getAge());
		System.out.println();
		System.out.println("** 사원 정보**");
		System.out.println("사원명:"+sawon.getName());
		System.out.println("지역:"+sawon.getCity());
		System.out.println("취미:");
		for(String h:sawon.getHobby())
			System.out.println(h);
	}
	//(9) appcontext1.xml에 
	// 1.id를 stu로 해서 Student.java로 연결후name/age/blood지정
	// 2.id를 sawon으로 해서 Sawon.java로 연결 후name/city/hobby지정
	// 3.id를 bit으로 해서 sawon,stu불러옴
}
