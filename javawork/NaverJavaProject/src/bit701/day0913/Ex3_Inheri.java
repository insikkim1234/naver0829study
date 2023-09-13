package bit701.day0913;
//다형성 처리시 부모가 하는 일이 없을경우 어떻게 해야할까요
//오버라이딩을 위해서 메서드는 만들어야 한다
abstract class SuperColor
{
//	public void draw()
//	{
//		//g하는 일이 없으므로 안에 내용도 없음
//	}
	
	//오버라이드를 위해서 {}부분을 없앤다
	//abstract 추상화 미완성적인 메서드라는 의미
	//class의 멤버 메서드 중 한개이상의 추상 메서드가 있는경우
	//반드시 클래스도 추상화시켜야 한다
	//즉 클래스 앞에 abstract를 붙인다
	
	abstract public void draw();
	//오버라이드를 안할 경우 호출 가능
	//서브클래스에만 있는 메서드는 호출 불가능(부모로 선언시)
	public void parentJob()
	{
		System.out.println("부모는 오늘도 돈을 벌어온다");
	}
}
//3개의 서브 클래스들
class SubRed extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("집안 청소를 한다");
	}
}
class SubGreen extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("식사 준비를 한다");
	}
}
class SubBlue extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("설거지를 한다");
	}
}


public class Ex3_Inheri {
	public static void draw(SuperColor s)
	{
		s.parentJob();//오버라이드를 하진 않았지만 부모에게만 있는 함수는 불러올수있음
		s.draw();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SuperColor ss=new SuperColor() {
			
			@Override
			public void draw() {
				// TODO Auto-generated method stub
				
			}
		};
		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());

	}

}
