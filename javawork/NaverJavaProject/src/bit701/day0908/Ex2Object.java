package bit701.day0908;

class Bitcamp{
	//인스턴스 멤버 변수
	String name;
	String address;
	static final String STUDYNAME="네이버 클라우드 3기 자바웹";
	
}
public class Ex2Object {

	public static void main(String[] args) {
		Bitcamp stu1=new Bitcamp();
		stu1.name="이미자";
		stu1.address="여의도";
		
		Bitcamp stu2=new Bitcamp();
		stu2.name="이기자";
		stu2.address="제주도";
		
		System.out.println("학생정보1");
		System.out.println("이름:"+stu1.name);
		System.out.println("주소:"+stu1.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);//스태틱은 클래스 이름으로 불러오자
		
		System.out.println("=".repeat(30));
		System.out.println("학생정보2");
		System.out.println("이름:"+stu2.name);
		System.out.println("주소:"+stu2.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);
		
		
		

	}

}
