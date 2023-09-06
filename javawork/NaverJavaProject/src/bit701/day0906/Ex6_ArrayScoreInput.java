package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		/*
		 * score에 5개의 배열할당후 키보드로 직접 점수를 입력하여 배열에 저장 후 총점과 평균을 구하시오
		 */
		Scanner sc=new Scanner(System.in);
		
		int []score=new int[5];
		double avg;
		int sum=0;
		
		
		
		for(int i=0;i<score.length;i++)
		{
			System.out.print(i+"번 점수입력:");
			score[i]=sc.nextInt();
			if(0>score[i]||score[i]>100)
			{
				System.out.println("0~100사이 정수로 입력바람");
				//그냥continue시 i++로 이동
				//미리 1을 감소시킨후 컨티뉴
				i--;
				continue;
				
			}
			
			sum+=score[i];
		}
		
		avg=(double)sum/score.length;
		
		System.out.println("입력한 점수들");
		
		for(int n:score)
			System.out.printf("%5d",n);
		
		System.out.println("\n총점:"+sum);
		System.out.println("평균:"+avg);
		
		

	}

}
