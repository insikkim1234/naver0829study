package bit701.day0904;

import java.util.Scanner;

public class Ex2_While {

	public static void main(String[] args) {
		/*
		 * 점수를 입력받아 총점과 평균을 구해보자0이 입력되면 점수 입력 종료
		 */
		Scanner sc=new Scanner(System.in);
		int score=0;;
		int sum=0,count=0;
		double avg=0;
		
		while(true) {
			System.out.println("점수입력:");
			score=sc.nextInt();
			
			if (score==0)
				break;//0입력시 while문 빠져나감
			
			if(score<1||score>100)
			{
				System.out.println("\t1~100사이의 점수만입력해주세요");
				continue;//하던 작업을 멈추고 while문 처음으로 되돌아감
			}
			
			
			count++;//입력한 갯수ㅜ하기
			sum+=score;//총점구하기
			
		}
		//0d입력시 빠져나온후 평균 구하기
		avg=(double)sum/count;
		
		System.out.println("입력된 점수갯수:"+count);
		System.out.println("총합계:"+sum);
		System.out.println("평균"+avg);
		

	}

}
