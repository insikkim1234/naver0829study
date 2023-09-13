package bit701.day0913;
abstract class AbstEx1{
	int a=100;
	final String str="abstract test";//상수
	public String getStr()
	{
		return str;
	}
	//추상 메서드 추가
	abstract public int getA();
}
abstract class AbstEx2 extends AbstEx1
{
	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return a;
	}
	
	abstract public void show();//새로운 추상 메서드 추가
}

class AbstEx3 extends AbstEx2
{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("마지막 기능구현한 클래스");
	}
}

public class Ex4_InheriAbstract {

	public static void main(String[] args) {
		//AbstEx1 ex1=new AbstEx1();//오류발생함 왜냐면 abstrat클래스는 객체생성 불가
		//AbstEx1 ex1=new AbstEx2();
		//System.out.println("a="+ex1.getA());
		//System.out.println("a="+ex1.getStr());
		//show 메서드 추가했더니 오류 발생
		
		AbstEx3 ex3=new AbstEx3();
		System.out.println("a="+ex3.getA());
		System.out.println("str="+ex3.getStr());
		ex3.show();
		
		System.out.println("----");
		AbstEx1 ex4=new AbstEx3();
		System.out.println("a="+ex4.getA());
		System.out.println("str="+ex4.getStr());
		//ex4.show();//show를 처음 추가한 곳이 두반째기에 오류 발생

	}

}
