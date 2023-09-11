package bit701.day0911.study;

class Car
{
	private String carName;
	private int carPrice;
	
	Car()
	{
		System.out.println("디폴트 생성자 호출");
		carName="그랜져";
		carPrice=3500;
		
	}
	
	Car(String carName,int carPrice)
	{
		System.out.println("생성자 2 호출");
		this.carName=carName;
		this.carPrice=carPrice;	
	}
	public void carShow()
	{
		System.out.println("자동차명:"+carName+"단가:"+carPrice);
	}
	
	
}

public class Ex4_Constructor {

	public static void main(String[] args) {
		Car car1=new Car();
		car1.carShow();
		
		Car car2=new Car("아반떼",2900);
		car2.carShow();
		

	}

}
