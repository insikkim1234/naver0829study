package bit701.day0913;
//봉인된(sealed) 클래스 지정하는 방법(jdk15에서 추가)
//무분별한 자식클래스 생성 방지
sealed class Person permits Employee,Manager//두개의 서브 클래스만 허용
{
	public String name;
	
	public void work()
	{
		System.out.println("하는 일이 결정되지 않았습니다");
	}
	
}

final/*employee 클래스는 상속 더이상 못함*/ class Employee extends Person{
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println("제품을 생산합니다");
	}
}
//상속이 가능한 클래스
non-sealed class Manager extends Person
{
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println("생산관리를 합니다");
	}
}
public class Book330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person();
		p.work();
		System.out.println();
		
		Employee e=new Employee();
		e.work();
		System.out.println();
		
		Manager m=new Manager();
		m.work();
		System.out.println();
		
		Person p2=new Manager();
		p2.work();
		System.out.println();
	}

}
