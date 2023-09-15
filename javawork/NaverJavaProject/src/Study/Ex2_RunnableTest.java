package Study;

public class Ex2_RunnableTest implements Runnable {
	
	String name;int count;
	
	public Ex2_RunnableTest(String name,int count)
	{
		super();
		this.name=name;
		this.count=count;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=count;i++)
		{
			System.out.println(name+":"+i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_RunnableTest ex1=new Ex2_RunnableTest("one",300);
		Ex2_RunnableTest ex2=new Ex2_RunnableTest("two", 300);
		Ex2_RunnableTest ex3=new Ex2_RunnableTest("three", 300);
		
		Thread th1=new Thread(ex1);
		Thread th2=new Thread(ex2);
		Thread th3=new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();

	}

}
