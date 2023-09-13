package Study;
abstract class Tire{
	abstract public void roll();
}
class HankookTire extends Tire
{

	@Override
	public void roll() {
		System.out.println("한국타이어");
		
	}
	
}

class KumhoTire extends Tire
{

	@Override
	public void roll() {
		System.out.println("금호타이어");
		
	}
	
}

class Car{
	public Tire tire;
	public void run()
	{
		tire.roll();
	}
}

public class Book314 {

	public static void main(String[] args) {
		Car car=new Car();
		car.tire=new HankookTire();
		car.run();
		
		car.tire=new KumhoTire();
		car.run();

	}

}
