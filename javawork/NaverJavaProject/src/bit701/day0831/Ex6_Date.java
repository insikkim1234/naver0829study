package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex6_Date {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//입력한 연월일에 해당하는 요일 구하기
		System.out.println("연월일을 순서대로 입력");
		//공백으로 3개 구분가능
		int year=sc.nextInt();
		int month=sc.nextInt();
		int day=sc.nextInt();

		//date클래스 생성
		Date date=new Date(year-1900,month-1,day);
		//요일구하기
		int weekint=date.getDay();//0이 일요일~6이 토요일
		System.out.println("요일숫자: "+weekint);


		String week=weekint==0? "일":weekint==1? "월":weekint==2? "화":
			weekint==3? "수":weekint==4? "목":weekint==5? "금":"토";
		System.out.println("오늘은 "+week+"요일입니다");

	}

}
