package bit701.day0914;

import java.util.Scanner;



//사용자 정의 익셉션
//exception(예외가 모여있는 클래스) 으로 부터 상속받고 출발
class NicknameException extends Exception
{
	public NicknameException(String msg)
	{
		super(msg);
	}
}
public class Ex4_UserException {
	
	public static void dataInput() throws NicknameException, InterruptedException
	{
		//기본 입출력
		Scanner sc=new Scanner(System.in);
		System.out.println("닉네임이 무엇인가요");
		String nickName=sc.nextLine();
		
		
		if(nickName.equals("바보")||nickName.equals("이놈"))
		{
			//datainput옆에 throw NicknameException 컨1로선언
			throw new NicknameException("고운말을 씁시다");//강제로 사용자 정의 예외 발생//여기서 오류가 발생하게 되는데 try catch 하던가 throw
		}
		//thread 친datainput 옆에 InterrputedException 컨1로 선언
		Thread.sleep(1000);//1초를 딜레이 해서 밑걸 전달하는데 throws 해서 예외 줘야함
		System.out.println("당신의 이름이"+nickName+"이군요");
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//datainput 을 입력한뒤 앞의 두가지 예외에 대하여 처리
		try {
			dataInput();
		} catch (NicknameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
