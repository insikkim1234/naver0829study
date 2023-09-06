package bit701.day0906;

import java.util.Scanner;

public class Ex4_ArraySum {

	public static void main(String[] args) {
		//배열에 5개의 정수 저장 후 총점과 평균 구하기
		int []score= {78,100,90,89,68,100,100};
		int sum=0;
		double avg=0;
		
		
		//방법1
		/*for(int i=0;i<score.length;i++)
		{
			sum+=score[i];
			
		}*/
		for(int i:score)
		{
			sum+=i;
		}
		//sum 계산이 끝난후 평균구하기
		avg=(double)sum/score.length;
		System.out.println("총점수갯수:"+score.length);
		System.out.println("총점"+sum);
		System.out.println("평균"+avg);
		
		

	}

}
