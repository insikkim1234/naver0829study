package Study;

@FunctionalInterface
interface Orange
{
	public void write();

}
@FunctionalInterface
interface DataAdd
{
	public void add(int x,int y);

}


public class Ex4_Lambda {
	public void abstMethod1()
	{
		Orange or=new Orange()
		{

			@Override
			public void write() {
				System.out.println("안녕하세요");
				
			}
			
		};
		or.write();
	}
	
	public void abstMethod2()
	{
		Orange or=()->System.out.println("반가워요");
		or.write();
		
		Orange or2=()->{
			System.out.println("람다람다");
			System.out.println("여러줄 썼어요");
		};
		or2.write();
	}
	public void abstMethod3()
	{
		DataAdd add1=(int x, int y)->System.out.println(x+"+"+y+"="+(x+y));
		add1.add(100,200);
		add1.add(5, 7);
	}

	public static void main(String[] args) {
		Ex4_Lambda ex=new Ex4_Lambda();
		ex.abstMethod1();
		ex.abstMethod2();
		ex.abstMethod3();

	}

}
