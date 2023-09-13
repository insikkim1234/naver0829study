package Study;

abstract class SuperColor
{
	abstract public void draw();
	
	public void parentJob()
	{
		System.out.println("부모는 오늘도 돈을 벌어온다");
	}
}

class SubRed extends SuperColor
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("집안청슬ㄹ 한다");
		
	}
	
}
class SubGreen extends SuperColor{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("식사 준비를 한다");
		
	}
	
}
class SubBlue extends SuperColor{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("설거지를 한다");
		
	}
	
}

public class Ex3 {
	public static void draw(SuperColor s)
	{
		s.parentJob();
		s.draw();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());

	}

}
