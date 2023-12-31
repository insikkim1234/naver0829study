package bit701.day0914;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bit701.day0911.MyStudent;

public class Ex15_ListStudent {
	
	//어레이리스트 생성 기본 입출력 선언
	List<Student> list=new ArrayList<Student>();
	Scanner sc=new Scanner(System.in);
	//생성자로 Ex15_ListStudent에 이름 점수 혈액형 점수 받기마지막에는 리스트사이즈로 몇갠지 받기
	public Ex15_ListStudent()
	{
		list.add(new Student("이효리", 90, "ab"));
		list.add(new Student("강호동", 100, "o"));
		list.add(new Student("캔디", 78, "a"));
		list.add(new Student("유재석", 89, "b"));
		list.add(new Student("안쏘니", 91, "a"));
		System.out.println("총 "+list.size()+"명");
		
	}
	
	//메뉴를 만들어서 
	//\n1.학생추가  2.학생삭제 3.학생검색 4.전체출력 5.종료  옵션 입력
	//하여 num에 저장
	//12345가 아닌 다른 모든 걸 받으면 트라이캣치 문으로 
	//캣치 시 num에 4 저장하고 리턴
	public int getMenu()
	{
		int num=0;
		System.out.println("\n1.학생추가  2.학생삭제 3.학생검색 4.전체출력 5.종료");
		System.out.print("선택하세요>");
		try
		{
			num=Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e)
		{
			num=4;//번호에 문자가 들어간 경우 4번. 전체출력으로 하기
		}
		return num;
	}
	
	
	//학생 정보 추가시 함수 학생명name 점수score 입력받고 저장
	//트라이 문으로 스코어를 받고
	//캣치 문으로 점수가 잘못 입력되면 30점으로 초기화
	//혈액형 받아 블러드에 저장
	//student 객체 받아 세터 함수로 저장
	//리스트에 저장 하고 리스트사이즈 출력
	public void addStudent()
	{
		System.out.println("학생 정보를 추가합니다");
		System.out.print("학생명:");
		String name=sc.nextLine();
		System.out.print("점수는:");
		int score=0;
		try {
			score=Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e)
		{
			//점수에 문자로 잘못 입력됐을 경우 3-점
			score=30;
		}
		System.out.println("혈액형:");
		String blood=sc.nextLine();
		
		//Student 객체 생성
		Student s=new Student();
		//setter로 값 넣기
		s.setName(name);
		s.setScore(score);
		s.setBlood(blood);
		//list에 추가
		list.add(s);
		System.out.println(list.size()+"번째 학생정보 추가됨");
	}
	//학생 정보 삭제 삭제할 학생의 이름은?입력받고name에 저장
	//boolean 변수 find 를 false로 초기화
	//저장된리스트 사이즈 만큼 반복하는 반복문
	//s에 저장하고 s의 이름이 name과 같으면
	//true로 부울변수 바꾸고 remove 로 제거하고 반복문 탈출
	//변수가 true면 삭제되었습니다
	//아니면 명단에 없습니다 출력
	public void deleteStudent()
	{
		System.out.println("학생 정보를 삭제합니다");
		//이름을 입력후 for문으로 해당 이름을 찾아서 삭제하기
		System.out.print("삭제할 학생의 이름은?");
		String name=sc.nextLine();
		boolean find=false;
		for (int i=0;i<list.size();i++)
		{
			Student s=list.get(i);
			if(s.getName().equals(name)) {
				find=true;
				list.remove(i);
				break;
			}
		}
		if(find)
			System.out.println("삭제되었습니다");
		else
			System.out.println(name+"님은 명단에 없습니다");
	}
	
	
	public void searchStudent()
	{
		System.out.println("학생 정보를 검색합니다");
		//이름을 입력후 해당 학생이 있는 경우 이름 점수 혈액형 출력하고 만약 없을 경우 
		//"xxx 님은 명단에 없습니다"
		System.out.print("검색할 학생의 이름은?");
		String name=sc.nextLine();
		boolean find=false;
		for (int i=0;i<list.size();i++)
		{
			Student s=list.get(i);
			if(s.getName().equals(name)) {
				find=true;
				System.out.println("이름:"+s.getName()+",점수:"+s.getScore()
				+"혈액형:"+s.getBlood().toUpperCase()+"형");
				break;
			}
		}
		if(!find)
			System.out.println(name+"님은 명단에 업습니다");
	}
	
	public void listStudent()
	{
		System.out.println("학생 정보 출력");
		//번호 이름 점수 혈액형 순으로 출력하는데 단 혈액형은 대문자로 변환해서 출력
		System.out.println("번호\t 이름\t 점수\t 혈액형");
		System.out.println("=".repeat(40));
		for(int i=0;i<list.size();i++)
		{
			Student s=list.get(i);
			System.out.println(i+1+"\t"+s.getName()+"\t"+s.getScore()+"\t"+s.getBlood().toUpperCase());
		}
	}

	public static void main(String[] args) {
		Ex15_ListStudent ex=new Ex15_ListStudent();
		
		Exit:
		while(true)
		{
			switch (ex.getMenu())
			{
			case 1: 
				ex.addStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.searchStudent();
				break;
			case 4:
				ex.listStudent();
				break;
			
			
			default:
				System.out.println("프로그램 종료");
				break Exit;//while 문을 빠져나간다
			}
		}
		

	}

}
