package Study;
interface InterJobA
{
	public void insertDb();
	public void deleteDb();
}
interface InterJobB extends InterJobA
{
	public void selectJob();
	public void updateJob();
}
class JobOne implements InterJobA
{

	@Override
	public void insertDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 추가 db작업수행");
		
	}

	@Override
	public void deleteDb() {
		// TODO Auto-generated method stub
		System.out.println("학생제거 db작업수행");
	}
	
}
class JobTwo implements InterJobB
{

	@Override
	public void insertDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 추가");
		
	}

	@Override
	public void deleteDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 삭제");
	}

	@Override
	public void selectJob() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 조회");
	}

	@Override
	public void updateJob() {
		// TODO Auto-generated method stub
		System.out.println("학생 정보 수정");
	}
	
}

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterJobA a=new JobOne();
		a.insertDb();
		a.deleteDb();
		System.out.println("-".repeat(30));
		
		InterJobB b=new JobTwo();
		b.insertDb();
		b.deleteDb();
		b.selectJob();
		b.updateJob();

	}

}
