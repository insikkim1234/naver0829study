package bit701.day0908;

public class Ex5SawonCall {

	public static void main(String[] args) {
		Sawon sa=new Sawon();
		sa.setSawonNo("bit1234");
		sa.setName("홍길동");
		sa.setAge(23);
		
		System.out.println("신입사원1정보");
		Ex5SawonCall.printSawon(sa);//같은 클래스 내의 메서드는 클래스명 생략 가능
		
		Sawon sa2=new Sawon();
		sa2.setSawonNo("bit0000");
		sa2.setName("강호동");
		sa2.setAge(35);
		
		System.out.println("신입사원2정보");
		Ex5SawonCall.printSawon(sa2);
		

	}
	//함수형태로 만들고 호출
	public static void printSawon(Sawon s)
	{
		System.out.println("사원번호 :"+s.getSawonNo());
		System.out.println("사원명 : "+s.getName());
		System.out.println("나이: "+s.getAge());
		System.out.println();
		
	}

}
