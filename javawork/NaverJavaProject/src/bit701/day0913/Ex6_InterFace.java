package bit701.day0913;
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
{//jobone에 커서대고 컨1누르면 밑에 오버라이드 함수 나옴

	@Override
	public void insertDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 추가 db작업을 수행함");
		
	}

	@Override
	public void deleteDb() {
		// TODO Auto-generated method stub
		System.out.println("학생 제거 db작업을 수행함");
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

public class Ex6_InterFace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterJobA a=new JobOne();
		a.insertDb();
		a.deleteDb();
		System.out.println("-------");
		
		InterJobB b=new JobTwo();
		b.insertDb();
		b.deleteDb();
		b.selectJob();
		b.updateJob();

	}

}
