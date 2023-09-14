package bit701.day0914;

import java.util.Scanner;

public class Ex2_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//numberformatexception arithmeticexception 두개 발생
		while(true)
		{
			try {
			//첫번째 숫자를 입력받는다 
			//이때 숫자가 아니면 NumberFormatException실행 
			//숫자가 0이면 게임 종료
			//숫자면 두번째 숫자 입력받음	
			System.out.println("숫자1입력");
			int su1=Integer.parseInt(sc.nextLine());
			if(su1==0)
			{
				break;
			}
			System.out.println("숫자2입력");
			int su2=Integer.parseInt(sc.nextLine());
			
			
			
			int div=su1/su2;
			System.out.printf("%d 나누기 %d는 %d입니다\n",su1,su2,div);
			System.out.println();
			
			}
			
			
			catch (NumberFormatException e) {
				System.out.println("문자가 입력되었어요"+e.getMessage());
			}
			catch (ArithmeticException e) {
				// TODO: handle exception
				System.out.println("두번째 숫자를 0이 아닌값으로 입력"+e.getMessage());
			}
			//0을 넣든 문자를 넣든 두번째에 0을 넣든 무조건 실행됨
			finally
			{
				System.out.println("무조건 실행시킬 코드를 넣는곳");
			}
		}
		System.out.println("정상종료");

	}

}
