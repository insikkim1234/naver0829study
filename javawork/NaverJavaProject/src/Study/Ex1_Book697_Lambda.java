package Study;
@FunctionalInterface
interface Calculbale{
	public void calculate(int x,int y);
}

public class Ex1_Book697_Lambda {
	
	public static void action(Calculbale calculable)
	{
		int x=10;
		int y=4;
		
		calculable.calculate(x,y);
	}

	public static void main(String[] args) {
		
		
		action((x,y)->{
			int result=x+y;
			System.out.println("add result="+result);
		});
		
		action((x,y)->{
			int result=x-y;
			System.out.println("sub result="+result);
		});

	}

}
