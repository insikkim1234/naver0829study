package bit701.day0912;
class SuperC
{
	protected String name;
	protected int age;
	
	public SuperC() {
		System.out.println("부모 디폴트 생성자 호출");
		name="홍길동";
		age=10;
	}
	SuperC(String name,int age)
	{
		System.out.println("부모의 두번째 생성자 호출");
		this.name=name;
		this.age=age;
	}
}

class SubC extends SuperC
{
	String hp;
	
	SubC()
	{
		super();//기본으로 쓰지 않아도 내부적으로 호출되어 있음(생략 가능 단 디폴트인 경우에만)
		System.out.println("서브클래스의 디폴트 생성자 호출");
		hp="010-111-222";
	}
	
	SubC(String hp)
	{
		System.out.println("sub의 두번째 생성자호출");
		this.hp=hp;
	}
	
/*	SubC(String name,int age,String hp)
	{
		System.out.println("sub의 세번째 생성자호출");
		this.name=name;
		this.age=age;
		this.hp=hp;
	}*/
	
	//위의 방법보다는 아래의 방법으로 부모 생성자를 호출하는 경우가 많다
	SubC(String name,int age,String hp)
	{
		super(name,age);
		System.out.println("sub의 세번째 생성자호출");
		this.hp=hp;
	}
	
	public void dataShow()
	{
		//부모클래스의 맴버변수가 프로텍티드이므로 패키지 상관없이 접근 가능
		System.out.println("이름:"+this.name);//셋다 super여도 상관 없음
		System.out.println("나이"+this.age);
		System.out.println("핸드폰"+this.hp);
		System.out.println("-".repeat(30));
	}
}
public class Ex8_InheriConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubC sub1=new SubC();
		sub1.dataShow();
		SubC sub2=new SubC("010-4545-6767");
		sub2.dataShow();
		SubC sub3=new SubC("캔디",12,"02-455-788");
		sub3.dataShow();
		

	}

}
