package Study;

import java.util.Scanner;

public class Ex2_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			try {
			System.out.println("숫자1입력");
			int su1=Integer.parseInt(sc.nextLine());
			if(su1==0)
				break;
			System.out.println("숫자2입력");
			int su2=Integer.parseInt(sc.nextLine());
			
			int div =su1/su2;
			System.out.printf("%d나누기 %d는 %d입니다",su1,su2,div);
			System.out.println();
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("문자가 입력"+e.getMessage());
			}
			catch(ArithmeticException e)
			{
				System.out.println("두번째 숫자를 0이아닌 값으로 입력"+e.getMessage());
				
			}
			finally
			{
				System.out.println("무조건 실행시킬 코드");
			}
			
			
		}
		System.out.println("정상종료");

	}

}
