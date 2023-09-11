package bit701.day0911;
/*
 * this: 자기 자신을 의미하는 인스턴스 변수
 * 인스턴스 멤버 매서드는 this 변수를 기본적으로 갖고 있다
 * this():생성자에서 다른 생성자 호출시 사용하는 방법이다
 */


class Kiwi
{
	String name;
	int age;
	
	Kiwi()
	{
		//System.out.println("생성자 호출");this()앞에 이게 있으면 오류
		this("홍길동",20);//3번째 생성자 호출
	}
	
	Kiwi(String name)//3번째 생성자 호출
	{
		this(name,30);
	}
	
	Kiwi(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public void writeData()
	{
		System.out.println("name:"+name+"\tage:"+age);
	}
	
}
public class Ex13_ConstThis {

	public static void main(String[] args) {
		Kiwi []karr= {
				new Kiwi(),
				new Kiwi("kim"),
				new Kiwi("lee",35)
		};
		for(Kiwi k:karr)
			k.writeData();

	}

}
