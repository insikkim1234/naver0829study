package bit701.day0907;

import java.util.Scanner;

public class Ex3_ArrayBingo {

	public static void main(String[] args) {
		//3행 3열의 배열 선언 후 1~3사이의 난수 넣고 
		//가로 세로 대각선으로 비교하여 같은숫자가 나온 갯수를 구한다
		Scanner sc=new Scanner(System.in);
		int [][]data=new int [3][3];
		int binggo;
		int count;
		
		while(true)
		{
			binggo=0;
			
			//3행 3열의 1부터 3까지 숫자 임의로 넣기
			for(int i=0;i<data.length;i++)
			{
				for(int j=0;j<data[i].length;j++)
				{
					data[i][j]=(int)(Math.random()*3)+1;
				}
			}
			
			//출력
			for(int i=0;i<data.length;i++)
			{
				for(int j=0;j<data[i].length;j++)
				{
					System.out.printf("%3d",data[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			//빙고 숫자 계산 꽝~올빙고
			for(int i=0;i<data.length;i++)
			{
				if
				( data[i][0]==data[i][1]&&data[i][1]==data[i][2]) 
				{
					binggo++;
				}
				 if(data[0][i]==data[1][i]&&data[1][i]==data[2][i])
				{
					binggo++;
				}
				
			}
			if(data[0][0]==data[1][1]&&data[1][1]==data[2][2])
				binggo++;
			if(data[0][2]==data[1][1]&&data[1][1]==data[2][0])
				binggo++;
			
			if(binggo==0)
				System.out.println("꽝");
			else
				System.out.println("빙고개수는 :"+binggo);
			
			
			
			
			//종료
			System.out.println("종료 : >q");
			String ans=sc.nextLine();
			if(ans.equalsIgnoreCase("q")) {
				System.out.println("=".repeat(10));
				break;
			}
			else 
				continue;
			
			
		}
		
		System.out.println("끝");

	}

}
