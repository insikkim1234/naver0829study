package bit701.day0913;

class OuterA
{
	int a=10;
	static int b=20;


	//멤버 내부클래스
	class InnerA
	{
		int c=30;
		static int d=40;//jdk11까지는 오류 발생,멤버 내부클래스에서 static 선언 불가

		public void showInner()
		{
			System.out.println("내부 클래스의 매서드");
			System.out.println("외부의 변수a="+a);
			System.out.println("외부의 스태틱변수b="+b);
			System.out.println("내부의 변수c="+c);
			System.out.println("내부의 스태틱변수d="+d);
		}


	}
	//스태틱 내부클래스
	static class InnerB{
		int e=50;
		static int f=60;
		public void showInnerB()
		{
			System.out.println("스태틱 내부 클래스의 매서드");
			//System.out.println("외부a="+a);오류 외부에 있는 일반 인스턴스 변수는 접근 불가
			System.out.println("스태틱 외부b="+b);
			System.out.println("내부e="+e);
			System.out.println("스태틱 내부 f="+f);
			
		}
		
	}

	//외부클래스의 매서드
	public void showOuter()
	{
		InnerA inA=new InnerA();
		inA.showInner();
		InnerB inB=new InnerB();
		inB.showInnerB();
	}
	
}

public class Ex8_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OuterA a=new OuterA();
		a.showOuter();
		System.out.println();
		//다른 클래스에서 직접 내부 크래스의 매서드를 호출하고 싶을경우
		OuterA.InnerA b=new OuterA()/*a로 대체가능*/.new InnerA();
		b.showInner();
		System.out.println();
		//static내부 클래스를 직접 선언하여 매서드를 호출하고자 할 경우
		OuterA.InnerB c=new OuterA.InnerB();
		c.showInnerB();
	}

}
