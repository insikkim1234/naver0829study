package bit701.day0919;
//인터페이스가 함수형으로 구현이 가능한지 검증
//추상메서드가 하나인가 둘인가
@FunctionalInterface
interface Calculable{
	//추상 매서드 추가
	public void calculate(int x,int y);
}

public class Ex1_Book697_Lambda {
	//Calculable conspe
	public static void action(Calculable calculable)
	{
		int x=10;
		int y=4;
		//데이터 처리
		calculable.calculate(x, y);
	}

	public static void main(String[] args) {
		action((x,y)->{
			int result=x+y;
			System.out.println("add result="+result);
		});
		
		action((x,y)->{
			int result=x-y;
			System.out.println("sub result="+result);
		});
	}

}
