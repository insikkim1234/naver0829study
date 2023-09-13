package bit701.day0913;

class Parent
{
	public void method1()
	{
		System.out.println("parent-method1");
	}
	public void method2()
	{
		System.out.println("parent-method2");
	}
}

//상속받는 클래스
class Child extends Parent
{
	@Override
	public void method2() {
		System.out.println("child-method2");
	}
	
	public void method3()
	{
		System.out.println("child-method3");
	}
}

public class Book309 {

	public static void main(String[] args) {
		Child a=new Child();
		a.method1();//상속받은 메서드
		a.method2();//child의 method2가 호출
		a.method3();//child에만 있는 메서드
		System.out.println("-".repeat(30));
		Parent b=new Child();
		b.method1();
		b.method2();
		//b.method3();얘는 오버라이드 한 매서드만 호출하므로 오류
		//출력하고 싶으면
		((Child)b).method3();
		

	}

}
