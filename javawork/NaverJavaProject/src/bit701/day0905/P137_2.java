package bit701.day0905;

import java.util.Scanner;

public class P137_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean run=true;
		int money=0;
		
		while(run) {
			System.out.println("--------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("--------------");
			System.out.println("선택>>");
			
			int strNum=sc.nextInt();
			
			if(strNum==1)
			{
				System.out.println("예금액>>");
				money+=sc.nextInt();
			}
			else if(strNum==2)
			{
				System.out.println("출금액>>");
				money-=sc.nextInt();
			}
			else if(strNum==3)
			{
				System.out.printf("잔고>>%d\n",money);
				
			}
			else if(strNum==4)
			{
				System.out.println("프로그램 종료");
				run=false;
			}
			else
				System.out.println("다시 입력:");
				continue;
			
		}
		
	

	}

}
