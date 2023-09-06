package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {
		/*
		 * 총 4명의 이름과점수를 입력하면
		 * 이름 점수 등수를 출력하는 프로그램을 작성
		 * 단 점수가 0~100을 벗어날 경우 다시입력
		 * 
		 * 0번 이름:송혜교
		 * 0번 점수:99
		 * 
		 * 1번 이름:강호동
		 * 1변 점수:120
		 * 다시 입력하세요
		 * 1번 이름:강호동
		 * 1변 점수:19
		 * ...
		 * 번호 이름 점수 등수
		 * ===================
		 * 1 송혜교 991
		 */
		int []score=new int[4];
		String []name=new String[4];
		int []rank=new int[4];
		
		Scanner sc=new Scanner(System.in);
		
		//입력
		for(int i=0;i<name.length;i++)
		{
			System.out.println(i+"번이름:");
			name[i]=sc.nextLine();
			System.out.println(i+"번점수:");
			score[i]=Integer.parseInt(sc.nextLine());
			
			if(score[i]<0||score[i]>100)
			{
				System.out.println("\t다시입력");
				i--;
				continue;
			}
			
		}
		//등수구하기
		
		for(int i=0;i<score.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<score.length;j++)
			{
				if(score[i]<score[j])
				{
					rank[i]++;
				}
			}
		}
		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<score.length;i++)
		{
			System.out.println(i+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}

	}

}
