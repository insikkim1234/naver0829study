package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bit701.day0914.Ex15_ListStudent;

public class Ex15 {
	
	List<Student> list=new ArrayList<Student>();
	Scanner sc=new Scanner(System.in);
	
	public Ex15()
	{
		list.add(new Student("이효리",90,"ab"));
		list.add(new Student("강호동",100,"o"));
		list.add(new Student("캔디",78,"a"));
		list.add(new Student("유재석",91,"a"));
		list.add(new Student("안쏘니",90,"a"));
		System.out.println("총 "+list.size()+"명");
	}
	
	public int getMenu()
	{
		int num=0;
		System.out.println("1.학생추가 2.학생삭제 3.학생검색 4.전체출력 5.종료");
		System.out.println("선택하세요>");
		try
		{
			num=Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e)
		{
			num=4;
		}
		return num;
	}
	public void addStudent()
	{
		System.out.println("학생 정보 추가");
		System.out.print("학생명:");
		String name=sc.nextLine();
		System.out.print("점수는");
		int score=0;
		try
		{
			score=Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e)
		{
			score=30;
		}
		System.out.println("혈액형:");
		String blood=sc.nextLine();
		
		Student s=new Student();
		s.setName(name);
		s.setBlood(blood);
		s.setScore(score);
		
		list.add(s);
		System.out.println(list.size()+"번째 학생정보 추가됨");
	}
	
	public void deleteStudent()
	{
		System.out.println("학생 정보를 삭제");
		System.out.println("삭제할 학생의 이름은");
		String name=sc.nextLine();
		boolean find=false;
		for(int i=0;i<list.size();i++)
		{
			Student s=list.get(i);
			if(s.getName().equals(name))
			{
				find=true;
				list.remove(i);
				break;
			}
		}
		if(find)
			System.out.println("삭제");
		else
			System.out.println(name+"님은 명단에 없습니다");
		
	}
	
	public void serachStudent()
	{
		System.out.println("학생 정보검색");
		System.out.println("검색할 학생의 이르믄?");
		String name=sc.nextLine();
		boolean find=false;
		for(int i=0;i<list.size();i++)
		{
			Student s=list.get(i);
			if(s.getName().equals(name))
			{
				find=true;
				System.out.println("이름:"+s.getName()+",점수:"+s.getScore()
				+"혈액형:"+s.getBlood().toUpperCase()+"형");
				break;
			}
		}
		if(!find)
			System.out.println(name+"님은 명단에 없습니다");
	}
	public void listStudent()
	{
		System.out.println("학생 정보 출력");
		System.out.println("번호\t 이름\t 점수\t 혈액형");
		for (int i=0;i<list.size();i++)
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
				switch(ex.getMenu())
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
					break Exit;
				}
			}



	}

}
