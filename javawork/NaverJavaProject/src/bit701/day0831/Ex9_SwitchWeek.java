package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//년도와 월을 입력하면 몇일 까지 있는지 출력해보자
		//일단 해당 년도가 윤년인지 아닌지부터 판단해보자
		System.out.println("년도 4자리 숫자 입력");
		int year=sc.nextInt();
		System.out.println("월1~12 입력");
		int month=sc.nextInt();
		//잘못 월을  입력한경우 종료
		if(1>month || month>12)
		{
			System.out.println("월을 잘못 입력했어요");
			return;
		}
		
		System.out.printf("입력한 연도와 월: %d년 %d 월 \n\n",year,month);
		
		int days=0;
		//윤년인지 아닌지 알아보는법
		//변수 b는 boolean 변수이므로 true아니면 false다
		boolean b=year%4==0 && year%100!=0||year%400==0;
		if(b) System.out.println("윤년");//(b)와 (b==true는 같은말)
		else System.out.println("평년");
		
		//윤년 평년을 받은 후 달별로 몇일 있는지 출력해줌
		switch(month)
		{
		case 2:
			days=b?29:28;//b가 true이면윤년이므로 29일 b가 false이면 평년이므로 해당숫자를 days에 저장
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
			break;
		default:
			days=31;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있어요\n",year,month,days);
	}

}
