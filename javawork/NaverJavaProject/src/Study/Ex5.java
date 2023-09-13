package Study;


interface InterA
{
	int SCORE=100;
	public void play();
	public void study();
}

class My/*컨트롤1로 오버라이드 생성*/ implements InterA
{
	int myscore=SCORE;

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("SCORE="+SCORE);
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		myscore=80;
		System.out.println("점수 변경함"+myscore);
	}
	
	public void processMy()
	{
		System.out.println("my클래스가 단독으로 가진 메서드");
	}
	
}
public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//InterA=new InterA(); 인터페이스는 뉴로 생성불가
		
		InterA a=new My();
		a.play();
		a.study();
		//a.processMy()얘는 다형서이므로 my로선언시에만 호출가능
		
		System.out.println("-".repeat(30));
		My b=new My();
		b.play();
		b.study();
		b.processMy();

	}

}
