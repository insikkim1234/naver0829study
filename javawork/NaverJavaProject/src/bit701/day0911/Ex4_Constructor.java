package bit701.day0911;
//생성자의 규칙
/*
 * 1.반드시 클래스명과 매서드명이 같다
 * 2.리턴타입이 없음
 * 3.오버로딩 가능
 * 4.주로 멤버변수의 초기화를 담당
 */

class Car
{
	private String carName;
	private int carPrice;
	//디폴트 생성자
	Car()
	{
		System.out.println("디폴트 생성자 호출");
		carName="그랜져";
		carPrice=3500;
		
	}
	//생성자를 통해서 외부에서 값을 받아 초기화
	Car(String carName,int carPrice)
	{
		System.out.println("생성자 2 호출");
		this.carName=carName;
		this.carPrice=carPrice;
	}
	
	
	//setter getter 없이 프라이빗 추력
	public void carShow()
	{
		System.out.println("자동차명:"+carName+",단가:"+carPrice);
	}
}

public class Ex4_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		car1.carShow();
		
		Car car2=new Car("아반떼",2700);
		car2.carShow();
				

	}

}
