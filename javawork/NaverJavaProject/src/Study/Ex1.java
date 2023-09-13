package Study;
class SuperA
{
	public void process()
	{
		System.out.println("부모가 처리하는 프로세스");
	}
}
class SubA extends SuperA
{
	@Override
	public void process() {
		
		super.process();
		System.out.println("그림을 그린다");
	}
}
class SubB extends SuperA
{
	@Override
	public void process() {
		
		super.process();
		System.out.println("야구게임을 한다");
	}
}

class SubC extends SuperA
{
	@Override
	public void process() {
		
		super.process();
		System.out.println("테니스를 친다");
	}
	
}
public class Ex1 {

	public static void main(String[] args) {
		SubA sub1=new SubA();
		sub1.process();
		
		SubB sub2=new SubB();
		sub2.process();
		
		SubC sub3=new SubC();
		sub3.process();
		
		System.out.println("-".repeat(30));
		
		SuperA sub4=null;
		
		sub4=new SubA();
		sub4.process();
		
		sub4=new SubB();
		sub4.process();
		
		sub4=new SubC();
		sub4.process();

	}

}
