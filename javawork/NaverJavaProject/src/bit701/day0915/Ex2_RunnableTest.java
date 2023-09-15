package bit701.day0915;

//2. inteface Runnable을 ㅣ용해서 thread 구현하기

public class Ex2_RunnableTest implements Runnable{

	String name;
	int count;


	//소스로 생성
	public  Ex2_RunnableTest(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1;i<=count;i++)
		{
			System.out.println(name+":"+i);
		}
	}

		public static void main(String[] args) {
			Ex2_RunnableTest ex1=new Ex2_RunnableTest("one",300);
			Ex2_RunnableTest ex2=new Ex2_RunnableTest("two",300);
			Ex2_RunnableTest ex3=new Ex2_RunnableTest("three",300);
			
			//thread생성자에 runnable타입의 현재클래스 인스턴스 보내서 생성
			Thread th1=new Thread(ex1);
			Thread th2=new Thread(ex2);
			Thread th3=new Thread(ex3);
			
			th1.start();
			th2.start();
			th3.start();


		}

	}
