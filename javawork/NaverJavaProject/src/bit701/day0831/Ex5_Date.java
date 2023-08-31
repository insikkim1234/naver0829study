package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		//자바에서 시간이나 날짜 출력하는 방법
		//date 클래스 이용해서 시간 날짜 구하기
		Date date=new Date();
		int year=date.getYear()+1900;//getyear은 1900년 적게 나오므로 +1900
		int month=date.getMonth()+1;//getmonth는 0~11까지 나오므로 +1
		int day=date.getDate();
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("현재 년도 : %d-%2d-%2d\n",year,month,day);
		System.out.printf("현재 년도 : %d-%02d-%02d\n",year,month,day);//02면 두자리 띄우는데 빈공간은 0으로 채움
		System.out.printf("현재 시간 : %02d:%02d:%02d\n",hh,mm,ss);
		
		//calendar 클래스를 이용해서 시간 날짜 구하기
		//Calendar cal=new Calendar(); 오류
		//캘린더 클래스는 Calendar.getInstance();로 사용
		//생성자가 public이 아니기 때문에
		
		Calendar cal=Calendar.getInstance();
		//같은구역 안에서는 선언을 두번할수는 없지만 
		//int 빼고 값변경은 가능
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;
		day=cal.get(Calendar.DATE);
		
		System.out.printf("현재 년도 : %d-%02d-%02d\n",year,month,day);
		
		//요일구하기
		int weekint=date.getDay();//0이 일요일~6이 토요일
		System.out.println("요일숫자: "+weekint);
		
		
		String week=weekint==0? "일":weekint==1? "월":weekint==2? "화":
				weekint==3? "수":weekint==4? "목":weekint==5? "금":"토";
		System.out.println("오늘은 "+week+"요일입니다");
		
		
		
	}

}
