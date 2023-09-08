package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayBaseball {

	public static void main(String[] args) {
		int []com=new int[3];
		int []user=new int[3];
		String strNum="";
		Scanner sc=new Scanner(System.in);
		int ball,strike;
		
		//1부터 9사이에 중복되지 않는 숫자를 배열에 담음
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		System.out.printf("%d%d%d",com[0],com[1],com[2]);
		//게임
		while(true)
		{
			System.out.println(">>");
			strNum=sc.nextLine();
			//strNum의 각 숫자를 user배열에 정수형태로 넣기
			
			//종료
			if(strNum.equalsIgnoreCase("q"))
			{
				System.out.println("게임종료");
				break;
			}
			user[0]=strNum.charAt(0)-'0';//문자1은 정수로 49이므로(아스키코드참조) 그래서 '1'-'0'=1(49-48)
			user[1]=strNum.charAt(1)-'0';
			user[2]=strNum.charAt(2)-'0';
			System.out.printf("%d,%d,%d\n",user[0],user[1],user[2]);
			
			
			
			//user와com을 비교하여 숫자가 있지만 자릿수가 안맞을 경우는 ball자릿수까지 맞을 경우에는 strike 증가
			//strike=3이면 축하합니다 정답입니다 출력 후 종료
			ball=0;
			strike=0;
			
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j])
					{
						if(i==j)
						{
							strike++;
						}
						else
						{
							ball++;
						}
					}
					
				}
			}
			System.out.printf("%d 스트라이크 %d볼\n",strike,ball);
			if(strike==3)
			{
				System.out.println("축하합니다 정답");
				break;
			}
			
				
			
			
			
		}
	}

}
