package Study;

import java.util.Scanner;

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
		Scanner sc=new Scanner(System.in);
		System.out.println("닉네임이 무엇인가요?");
		String nickName=sc.nextLine();
		if(nickName.equals("바보")|nickName.equals("이놈"))
		{
			throw new NicknameException("고운말을 씁시다");
		}
		Thread.sleep(1000);
		System.out.println("당신의 이름이"+nickName+"이군요");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
