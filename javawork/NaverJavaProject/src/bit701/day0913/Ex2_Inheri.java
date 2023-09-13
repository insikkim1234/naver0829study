package bit701.day0913;
//1번 예제의 클래스 메서드 사용

public class Ex2_Inheri {
	//인자를 SubA로 하면 이것만 보낼 수 있음
	/*public static void processPlay(SubA sub)
	{
		sub.process();
	}
	public static void processPlay(SubB sub)
	{
		sub.process();
	}
	public static void processPlay(SubC sub)
	{
		sub.process();
	}*/
	//위 3개를 하나로 줄이는 방법
	//인자를 부모 클래스로 선언
	public static void processPlay(SuperA sub)
	{
		//호출할 수 있는 메서드는 오버라이딩 된 메서드 뿐이다(다형성때문)
		sub.process();
		//sub 변수에 누가 생성되어있느냐에 따라서 하는 일이 달라짐(다형성)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());

	}

}
