package Study;



public class Ex1_ThreadTest extends Thread{
	String name;
	int count;
	
	public Ex1_ThreadTest(String name,int count)
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
		Ex1_ThreadTest th1=new Ex1_ThreadTest("one_thread",300);
		Ex1_ThreadTest th2=new Ex1_ThreadTest("two_thread", 300);
		Ex1_ThreadTest th3=new Ex1_ThreadTest("three_thread", 300);
		
		th1.start();
		th2.start();
		th3.start();

	}

}
