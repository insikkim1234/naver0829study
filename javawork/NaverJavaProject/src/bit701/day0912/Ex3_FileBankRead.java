package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bit701.day0911.Account;

public class Ex3_FileBankRead {
	public static final String BANK_FILE="D:\\naver0829/bank.txt";
	Account []account=new Account[30];//여기에 컨스페 해서 어제거 불러옴
	int count;

	public Ex3_FileBankRead() throws IOException {
		//파일에서 데이터를 읽어서 배열 account에 넣기
		count=0;//데이터 담을배열 번지 초기값은 0
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(BANK_FILE);//컨1try catch   1
			br=new BufferedReader(fr);

			while(true)
			{	
				String accountNo=br.readLine();//컨1 add throw    2
				if(accountNo==null)
					break;
				String accountName=br.readLine();
				int money=Integer.parseInt(br.readLine());

				//count 번지의 배열에 담고 1증가
				account[count]=new Account(accountNo,accountName,money);
				count++;

			}
			System.out.println("총 "+count+"개의 계좌를 읽음!");
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을경우 실행하는 영역
			System.out.println("파일이 없어요");
		}
	}//시작과 동시에 파일 내용 읽어오기

	public static void showTitle()
	{
		System.out.println("-".repeat(20));
		System.out.println("계좌 목록");
		System.out.println("-".repeat(20));
		System.out.println();
		System.out.println("계좌 번호\t계좌명\t잔액");
		System.out.println("-".repeat(30));
	}
	//메모장에 있는 데이터 출력
	public void accountList() 
	{
		//일반 메서드 에서는 static메서드 호출이 가능
		//하지만 static메서드 에서는 일반 메서드 호출 불가
		//같은 static만 호출 가능(this가 없기 때문에)
		showTitle();//제목 출력을 여기서 해서 반복하지 않도록
		for(int i=0;i<count;i++)
		{
			account[i].accountWrite();
		}

	}

	//입금시 호출될 메서드
	public void depositMoney(String accountNo,int money)
	{
		//같은 계좌번호를 찾아서 입금을 한다
		boolean find=false;
		for(int i=0;i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find=true;
				account[i].addMoney(money);
				break;
			}
		}
		if(find)
			System.out.println(accountNo+"계좌에"+money+"원을 입금했어요");
		else
			System.out.println(accountNo+"계좌가 없네요");
	}

	
	//계좌추가시 호출될 메서드
	public void addAccount(String accountNo,String accountName,int money)
	{
		if(count==account.length)
		{
			System.out.println("이미 계좌가 찼어요 삭제후 다시 추가하세요");
			return;//메서드가 여기서 종료
		}
		//같은 계좌가 있는지 일단 파악하기
		boolean find=false;
		for(int i=0;i<count;i++)
		{
			if(account[i].isAccount(accountNo))//계좌번호가 같은게 있는 상황
			{
				find=true;
				break;
			}
		}
		
		if(find)
			System.out.println(accountNo+"계좌는 이미 존재합니다");
		else
		{
			//count번지에 생성자를 틍해서 데이터 전달
			account[count]=new Account(accountNo, accountName, money);
			count++;
			System.out.println(accountNo+"계좌를 추가했습니다");
		}
	}
	//종료시 배열의 내용을 파일에 저장할 메서드
	public void accountFileSave() throws IOException//이걸 호출하는 곳인 가장 아랫부분으로 이동
	{
		FileWriter fw=null;//자동완성
		fw=new FileWriter(BANK_FILE);
		for(int i=0;i<count;i++)
		{
			fw.write(account[i].getAccountNo()+"\n");
			fw.write(account[i].getAccountName()+"\n");
			fw.write(account[i].getMoney()+"\n");
		}
		System.out.println("배열의 계좌정보를 파일에 저장했습니다");
		fw.close();
	}
	//출금시 호출될 메서드
	public void withdrawMoney(String accountNo,int money)
	{
		//같은 계좌번호를 찾아서 출금을 한다
		boolean find=false;
		for(int i=0;i<count;i++)
		{
			if(account[i].isAccount(accountNo))
			{
				find=true;
				account[i].subMoney(money);
				break;
			}
		}
		if(find)
			System.out.println(accountNo+"계좌에"+money+"원을 출금했어요");
		else
			System.out.println(accountNo+"계좌가 없네요");

	}


	public static void main(String[] args) throws IOException {
		Ex3_FileBankRead ex=new Ex3_FileBankRead();//생성자 호출 파일 읽기// 컨1 add throw    3
		//		showTitle();//제목
		//		ex.accountList();//계좌 목록 출력

		Scanner sc =new Scanner(System.in);
		Exit:
			while(true)
			{
				System.out.println("1.계좌추가  2.입금  3.출금  4.종료");
				System.out.print("선택>");
				int num=Integer.parseInt(sc.nextLine());


				switch (num) {
				case 1: {
					//추가할 계좌정보 입력하기
					System.out.print("추가할 계좌번호는?");
					String accountNo=sc.nextLine();
					System.out.print("예금주는?");
					String accountName=sc.nextLine();
					System.out.print("초기 입금액은?");
					int money=Integer.parseInt(sc.nextLine());
					
					//추가할 매서드 호출
					ex.addAccount(accountNo, accountName, money);
					//목록 다시한번 호출
					ex.accountList();
					System.out.println();
					break;
				}
				case 2: {//입금
					System.out.print("입금할 계좌 번호는?");
					String accountNo=sc.nextLine();
					System.out.print("입금할 금액은");
					int money=Integer.parseInt(sc.nextLine());
					//입금 처리할 멤버함수 호출
					ex.depositMoney(accountNo, money);
					//계좌 목록 출력
					ex.accountList();
					break;
				}
				case 3: {
					System.out.print("출금할 계좌 번호는?");
					String accountNo=sc.nextLine();
					System.out.print("출금할 금액은");
					int money=Integer.parseInt(sc.nextLine());
					//출금 처리할 멤버함수 호출
					ex.withdrawMoney(accountNo, money);
					//계좌 목록 출력
					ex.accountList();
					break;
				}
				default:
					ex.accountFileSave();//배열내용을 파일에 저장하기
					System.out.println("파일 저장후 종료");
					break Exit;//while문 빠져나감
				}
			}


	}

}
