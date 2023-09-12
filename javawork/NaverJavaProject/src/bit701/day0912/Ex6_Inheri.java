package bit701.day0912;
class SuperA
{
	public void processA()
	{
		System.out.println("부모가 가진 메서드 A");
	}
	
	protected void processB()
	{
		System.out.println("부모가 가진 메서드 B");
	}
	
	private void processC()//상속 안됨
	{
		System.out.println("부모가 가진 메서드 C");
	}
}

class SubA extends SuperA
{
	public void show()
	{
		//this는 자기 자신 주소를 가진 인스턴스 변수이다
		//this로 processA()호출 시 현재 클래스에 없으면 부모로부터 찾아서 가져온다(필요하다면 부모의 부모까지 올라간다)
		this.processA();
		this.processB();
		//부모의 주소값을 가진 인스턴스 변수 super
		//반드시 super로만 부모메서드를 가져와야 하는 경우
		//부모의 매서드를 자식이 오버라이드 한 경우(오버라이드 안했으면 상관없는데 했으면 서로 다른결과 가져온다)
		super.processA();//부모의 매서드이므로 super로도 가져올 수 있다
		super.processB();
		
		
	}
}

public class Ex6_Inheri {

	public static void main(String[] args) {
		SubA sub1=new SubA();
		sub1.processA();
		sub1.processB();
		//sub1.processC();//private는 패키지 상관없이 상속 안되는 오류 발생
		System.out.println("----------");
		sub1.show();

	}

}
