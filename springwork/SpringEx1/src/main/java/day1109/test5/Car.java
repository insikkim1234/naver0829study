package day1109.test5;

public class Car {
	//(4)타이어 인터페이스 선언(tire)
	Tire tire;
	
	//(5)tire만 받는 기본생성자 선언
	public Car(Tire tire) {
		// TODO Auto-generated constructor stub
		this.tire=tire;
	}
	
	//(6)내 차의 타이어는 ???입니다 출력
	public void myCarInfo()
	{
		System.out.println("내 차의 타이어는 "+tire.getTireName()+"입니다");
	}
}
