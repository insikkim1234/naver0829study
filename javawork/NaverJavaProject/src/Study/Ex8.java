package Study;

class OuterA
{
	int a=10;
	static int b=20;
	
	class InnerA
	{
		int c=30;
		static int d=40;
		
		public void showInner()
		{
			System.out.println("내부 클래스의 메서드");
			System.out.println("외부의 변수 a="+a);
			System.out.println("외부의 변수 b="+b);
			System.out.println("외부의 변수 c="+c);
			System.out.println("외부의 변수 d="+d);
		}
	}
	
	static class InnerB
	{
		int e=50;
		static int f=60;
		public void showInnerB()
		{
			System.out.println("스태틱 내부 클래스의 매서드");
			//System.out.println("외부a="+a);
			System.out.println("스태틱 외부 b="+b);
			System.out.println("내부e="+e);
			System.out.println("스태틱 내부 f="+f);
			
		}
	}
	
	public void showOuter()
	{
		InnerA inA=new InnerA();
		inA.showInner();
		InnerB inB=new InnerB();
		inB.showInnerB();
	}
	
	
}

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OuterA a=new OuterA();
		a.showOuter();
		System.out.println();
		
		OuterA.InnerA b=new OuterA().new InnerA();
		b.showInner();
		System.out.println();
		
		OuterA.InnerB c=new OuterA.InnerB();
		c.showInnerB();

	}

}
