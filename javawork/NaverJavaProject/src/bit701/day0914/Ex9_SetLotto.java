package bit701.day0914;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex9_SetLotto {

	public static void main(String[] args) {
		//금액을 입력하면 그 금액만큼 로또 숫자 출력하기
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("로또를 구입할 금액");
		try
		{
			money=Integer.parseInt(sc.nextLine());
			if(money<1000) {
				System.out.println("금액이 부족합니다");
				return;}
			
			//입력받은 금액별로돌릴 횟수 구하기
			for(int i=1;i<money/1000;i++)
			{
				//컬랙션 setLotto구하고 오름차순으로 정렬할것임
				Set<Integer> setLotto=new TreeSet<Integer>();
				
				//6개의 난수를 구한다(1~45)
				while(true)
				{
					int n=(int)(Math.random()*45)+1;
					setLotto.add(n);
					if(setLotto.size()==6)
						break;
				}
				//앞쪽에 횟수출력
				System.out.printf("%2d회:",i);
				//앞에서 만든 랜덤 롯또숫자 출력
				for(Integer n:setLotto)
				{
					System.out.printf("%3d",n);
				}
				System.out.println();
			}
		}
		//만약 로또를 구입한 금액이 숫자가 아니게 들어갈 경우예외처리후 출력
		catch (NumberFormatException e) 
		{
			// TODO: handle exception
			System.out.println("금액은 숫자로만 입력"+e.getMessage());
		}

	}

}
