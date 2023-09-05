package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		String juminNo;
		while(true)
		{
			System.out.println("주민번호입력970102-1234567");
			juminNo=sc.nextLine();
			//q나 Q입력시 종료
			if(juminNo.equalsIgnoreCase("q"))
			{
				System.out.println("program end");
				break;
			}
			
			
			String yearStr=juminNo.substring(0,2);
			String monthStr=juminNo.substring(2,4);
			String dayStr=juminNo.substring(4,6);
			
			System.out.println(yearStr+"년"+monthStr+"월"+dayStr+"일");
			
			char gender=juminNo.charAt(7);
			
			
			if(gender=='1'||gender=='2'||gender=='3'||gender=='4')
			{
				System.out.println("내국인");
			}
			else if(gender=='5'||gender=='6')
				System.out.println("외국인");
			else {
				System.out.println("8번째 값을 잘못 입력했어요");
				continue;}
			
			switch(gender)
			{
			case '1':case '3':case '5':
				System.out.println("남자");
				break;
			case '2':case '4':case '6':
				System.out.println("여자");
				break;
			default:
				System.out.println("성별 알수없음");
			}
				
		
		/*String str=sc.nextLine();
		String run;
		String year,month,day;
		
		while(true)
		{
			year=str.substring(0,2);
			month=str.substring(2,4);
			day=str.substring(4,6);
			
			System.out.printf("%s년 %s월 %s일생",year,month,day);
			switch(str.charAt(7))
			{
			case '1':
			case '3':
				System.out.println("내국인\n남성");
				break;
			case '2':
			case '4':
				System.out.println("내국인\n여성");
				break;
			default:
				System.out.println("외국인");
			}
			System.out.println("프로그램을 종료하시겠습니까?");
			run=sc.nextLine();
			if(run.equalsIgnoreCase("q"))
			{
				break;
			}
			else
			{
				continue;
			}
			
			
		}
		System.out.println("프로그램 종료");
		
		
		
		/*String ssn="9804051234567";
		char sex=ssn.charAt(6);
		
		switch(sex) 
		{
		case '1':
		case '3':
			System.out.println("남자입니다");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다");
			break;
			
			
		}*/

	}

}}
