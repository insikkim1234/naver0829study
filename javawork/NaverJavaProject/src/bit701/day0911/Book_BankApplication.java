package bit701.day0911;

import java.util.Scanner;

public class Book_BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account []account =new Account[10];
		Scanner sc=new Scanner(System.in);
		int idx=0;
		//배열 10개가 꽉차면 더이상 생성이 안됩니다 출력
		while(true)
		{
			System.out.println("-".repeat(40));
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("-".repeat(40));
			System.out.print("선택>");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==5)
			{
				System.out.println("종료");
				break;
			}
			switch(num)
			{
			case 1:
				{
					if(idx>=10) {
						System.out.println("**계좌 생성 불가");
						break;
					}
				System.out.println("------\n계좌생성\n-------");
				System.out.print("계좌번호>");
				String accountNo=sc.nextLine();
				System.out.print("계좌주>");
				String accountName=sc.nextLine();
				System.out.print("초기입금액>");
				int money=Integer.parseInt(sc.nextLine());
				
				account[idx]=new Account(accountNo,accountName,money);
				System.out.println("결과: 계좌 생성");
				idx++;
				break;
				}
			case 2:
				System.out.println("----\n계좌목록\n----");
				for(int i=0;i<idx;i++)
				{
					account[i].accountWrite();
				}
				break;
			case 3:
			{
				System.out.println("----\n예금\n----");
				System.out.print("계좌번호");
				String accountNo=sc.nextLine();
				System.out.print("예금액:");
				int money=Integer.parseInt(sc.nextLine());
				
				//계좌번호를 찾은 후 그 배열변지의 money에 추가
				
				for(int i=0;i<idx;i++)
				{
					if(account[i].isAccount(accountNo))
					{
						account[i].addMoney(money);
						break;
					}
				}
				System.out.println("결과:예금되었습니다");
				break;
				
			}
			case 4:
			{
				System.out.println("----\n출금\n----");
				System.out.print("계좌번호");
				String accountNo=sc.nextLine();
				System.out.print("출금액:");
				int money=Integer.parseInt(sc.nextLine());
				
				//계좌번호를 찾은 후 그 배열변지의 money에 추가
				
				for(int i=0;i<idx;i++)
				{
					if(account[i].isAccount(accountNo))
					{
						account[i].subMoney(money);
						break;
					}
				}
				System.out.println("결과:출금되었습니다");
				break;
			}
			default:
				System.out.println("종료");
			
			
			}//switch
			System.out.println();
		}//while

	}//main

}//class
