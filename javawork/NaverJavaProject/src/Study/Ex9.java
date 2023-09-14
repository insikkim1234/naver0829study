package Study;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("로또를 구입할 금액");
		
		try
		{
			money=Integer.parseInt(sc.nextLine());
			
			if(money<1000)
			{
				System.out.println("금액이 부족합니다");
				return;
			}
			
			for(int i=1;i<money/1000;i++)
			{
				Set<Integer> setLotto=new TreeSet<Integer>();
				
				while(true)
				{
					int n=(int)(Math.random()*45)+1;
					setLotto.add(n);
					if(setLotto.size()==6)
						break;
				}
				System.out.printf("%2d 회:",i);
				
				for(Integer n:setLotto)
				{
					System.out.printf("%3d",n);
				}
				System.out.println();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("금액은 숫자로만 입력"+e.getMessage());
		}

	}

}
