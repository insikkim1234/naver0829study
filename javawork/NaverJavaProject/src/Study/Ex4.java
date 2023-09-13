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
}
public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
