package bit701.day0904;

import java.util.Random;

public class Ex4_Random {

	public static void main(String[] args) {
		Random r=new Random();
		
		//0~9사이의 난수(0부터 10개)
		for (int i=0;i<5;i++)
		{
			int n=r.nextInt(10);
			System.out.println(n);
		}
		
		
		System.out.println("=".repeat(30));
		//1~100사이의 난수(1부터 100개)
		for (int i=0;i<5;i++)
		{
			int n=r.nextInt(100)+1;
			System.out.println(n);
		}
		
		
		
		System.out.println("=".repeat(30));
		//임의의 대문자가 나오게 하는방법
		for (int i=0;i<5;i++)
		{
			int n=r.nextInt(26)+65;
			System.out.println((char)n);
		}

	}

}
