package Study;
abstract class AbstEx1{
	int a=100;
	final String str="abstract test";//상수
	public String getStr()
	{
		return str;
	}
	abstract public int getA();
}

abstract class AbstEx2 extends AbstEx1
{
	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return a;
	}
	
	abstract public void show();
}

class AbstEx3 extends AbstEx2
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Ex4 {

	public static void main(String[] args) {
		// 오류가 뜨는데 추상클래스는 객체생성이 불가하기 때문AbstEx1 ex1=new AbstEx1();
		//geta getstr show모두 사용가능
		AbstEx3 ex3=new AbstEx3();
		System.out.println("a="+ex3.getA());
		System.out.println("str="+ex3.getStr());
		ex3.show();
		//geta getstr만 사용가능(show는 2에서 처음 생성되었으므로 사용불가
		AbstEx1 ex4=new AbstEx3();
		System.out.println("a="+ex4.getA());
		System.out.println("str="+ex4.getStr());
		

	}

}
