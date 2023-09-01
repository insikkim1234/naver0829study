package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		/*구구단 출력할 시작단 입력
		 * 구구단 출력할 끝단 입력
		 * 		4단		5단		6단//단일 for문으로 구성
		 * 
		 * 		4*1=4 5*1=5	6*1=6//다중 for문으로 구성 뒤에수가 i 앞에수가 j
		 */
		
		System.out.println("시작할 단을 입력하시오");
		int start=sc.nextInt();
		
		System.out.println("마지막단을 입력하시오");
		int end=sc.nextInt();
		
		//start>end의 경우 그 변수의 값을 바꿔보자
		if(start>end) {
			int temp;
			temp=start;
			start=end;
			end=temp;
		}
		//제목 출력하는 반복문
		for(int dan=start;dan<=end;dan++)
		{
			System.out.printf("%7d단",dan);
		}
		System.out.println("\n");
		
		for(int i=1;i<=9;i++) 
		{
			
			for(int dan=start;dan<=end;dan++) 
			{
				System.out.printf("%5dX%d=%2d",dan,i,dan*i);
			}
			System.out.println();
				
		}

}
}
