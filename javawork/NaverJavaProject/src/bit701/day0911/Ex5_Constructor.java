package bit701.day0911;
class Car2
{
	String carName;
	String carColor;
	
	private Car2()
	{
		carName="아우디";
		carColor="검정색";
	}
	//toString 누르고 엔터
	//생성자가 private이므로 생성해서 반환해줄 static 함수 필요
	//private으로 생성해놓고 이렇게 불러올 수 있다
	public static Car2 getInstance()
	{
		return new Car2();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return"자동차명:"+carName+",색상:"+carColor;
	}
}

public class Ex5_Constructor {

	public static void main(String[] args) {
		//Car2 car1=new Car2();//오류발생 왜냐하면 private이라 같은 멤버만 호출 가능
		//근데 static함수 생성해놓으면 바로 불러올수있음
		Car2 car1=Car2.getInstance();
		//System.out.println(car1.toString()); 이렇게 하거나
		System.out.println(car1);//이렇게 바로 출력해줘도 상관없음
		
	}

}
