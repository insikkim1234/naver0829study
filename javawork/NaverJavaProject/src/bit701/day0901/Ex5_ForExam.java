package bit701.day0901;

import java.util.Scanner;

public class Ex5_ForExam {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//1.숫자 n을 입력받은후 1부터 n까지의 총 합계를 출력하시오
		
		/*System.out.println("자연수를 입력하시오");
		int n=sc.nextInt();

		int total=0;

		for(int i=1; i<=n; i++)
			total+=i;

		System.out.printf("1~%d까지 총 합은 %d",n ,total);*/
		




		/*2.구구단 숫자 2~9까지의 숫자를 입력받은후 범위를 벗어날경우
		"잘못 입력하여종료합니다"출력
		제대로 입력시 해당 구구단 출력

			5단
			5 * 1 = 5
			~
			5 * 9 = 45

		 */
		System.out.println("구구단 몇단?");
		int dan=sc.nextInt();

		if(dan<2||dan>9){
			System.out.println("잘못 입력하여 종료");
			return;
		} 
		
		System.out.println("\t**"+dan+"단**\n" );
		
		
		for(int i=1;i<=9;i++) {
			
			System.out.printf("%6d  X  %d = %2d\n",dan,i,dan*i);
		}



	}

}
