package bit701.day0913;

abstract class Tire{
	abstract public void roll();
}

class HankookTire extends Tire
{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국타이어가 회전합니다");
	}
}

class KumhoTire extends Tire//괄호까지 친 후 ㅓ컨1로 추상함수 받아주기
{

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호타이어가 회전합니다");
	}
	
}

class Car{
	public Tire tire;
	public void run()
	{
		tire.roll();//tire에 new 로 생성을 안한상태에서 호출시 null pointer exception 발생
	}
}



public class Book314 {

	public static void main(String[] args) {
		Car car=new Car();
		//car.run();//예외 나옴 왜냐하면 일반 변수의 경우 객체생성시 초기값이 널
		car.tire=new HankookTire();
		car.run();
		
		car.tire=new KumhoTire();
		car.run();
		
		

	}

}

