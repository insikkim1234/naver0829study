package Study;
sealed class Person permits Employee,Manager
{
	public String name;
	
	public void work()
	{
		System.out.println("하는 일이 결정되지 않았습니다");
	}
}
final class Employee extends Person
{
	@Override
	public void work() {
		
		super.work();
		System.out.println("제품 생산");
	}
}

non-sealed class Manager extends Person
{
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println("생산관리");
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
	}

}
