package Study;
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

public class Studybook309 {

	public static void main(String[] args) {
		Child a=new Child();
		a.method1();
		a.method2();
		a.method3();
		System.out.println("-".repeat(30));
		
		Parent b=new Child();
		b.method1();
		b.method2();
		((Child)b).method3();

	}

}
