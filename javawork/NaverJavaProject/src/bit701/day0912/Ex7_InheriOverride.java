package bit701.day0912;

class SuperB
{
	public void processA()
	{
		System.out.println("부모가 가진 메서드A");
	}
}
class SubB extends SuperB
{//pr치고 컨스페이스 오버라이드 에서 어노테이션으로 오버라이드 생성
	@Override
	public void processA() {
		// TODO Auto-generated method stub
		super.processA();//부모가 먼저 작업을 하고
		//나머지는 자식 클래스에서 작업을 완성하겠다
		System.out.println("자식이 가진 오버라이드메서드A");
	}
	public void processB()
	{
		System.out.println("자식만이 갖고있는 메서드B");
	}
}

public class Ex7_InheriOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB sub1=new SubB();
		sub1.processA();
		sub1.processB();
		
		//다형성
		//선언은 부모클래스로 생성은 자식클래스로
		SuperB sub2=new SubB();
		sub2.processA();//여기서 오버라이드된 자식의 매서드 실행
		//process b는 호출할 수 없음
		//자식이 가진것중 오버라이드된거만 호출이 가능하기 때문
	}

}
