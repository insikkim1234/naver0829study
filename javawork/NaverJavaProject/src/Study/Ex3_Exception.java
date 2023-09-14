package Study;

import java.util.Date;
import java.util.Scanner;

public class Ex3_Exception {
	public static void dataInput() throws NullPointerException, NumberFormatException
	{
		Scanner sc=new Scanner(System.in);
		Date date=new Date();
		System.out.println("년도"+(date.getYear()+1900));
		
		System.out.println("두개의 숫자를 입력");
		int su1=Integer.parseInt(sc.nextLine());
		int su2=Integer.parseInt(sc.nextLine());
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try{
//			dataInput();
//		}
//		catch (NumberFormatException e)
//		{
//			System.out.println("숫자로만 입력"+e.getMessage());
//		}
//		catch (NullPointerException e)
//		{
//			System.out.println("날짜 생성이 안됐네요"+e.getMessage());
//		}
		
		try
		{
			dataInput();
		}
		catch(NumberFormatException|NullPointerException e)
		{
			System.out.println("날짜생성이 안됐거나 문자가 입력"+e.getMessage());
		}
		System.out.println("정상종료");
		

	}

}
