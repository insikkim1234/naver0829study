package bit701.day0907;

import java.util.Scanner;

public class Ex1_Array {

	public static void main(String[] args) {
		System.out.println("배열 복습 예제");
		/*
		 * 처음에 인원수를(count) 입력후그 인원수만큼
		 * names kor eng를 배열 할당한후
		 * 인원수만큼 국어 영어점수를 입력
		 * 
		 * 아래와 같이 출력되도록 프로그램 작성
		 * 
		 * 번호  이름  국어  영어  총점  평균
		 * -----------------------------------
		 * 1	김	89		90		179		89.5
		 * 2	이	100	100			200		100
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int count=0;
		
		
		System.out.println("인원수");
		count=Integer.parseInt(sc.nextLine());
		String []names=new String[count];
		
		int []kor=new int[count];
		int []eng=new int[count];
		int []sum=new int[count];
		double []avg=new double[count];
		
		
		for(int i=0;i<count;i++)
		{
			System.out.println("이름입력");
			names[i]=sc.nextLine();
			System.out.println("국어점수 입력");
			kor[i]=Integer.parseInt(sc.nextLine());
			System.out.println("영어점수 입력");
			eng[i]=Integer.parseInt(sc.nextLine());
			
			sum[i]=kor[i]+eng[i];
			avg[i]=(double)sum[i]/2;
			
		}
		for(int i=0;i<count;i++)
		{
			System.out.println(i+1+"\t"+kor[i]+"\t"+eng[i]+"\t"+sum[i]+"\t"+avg[i]);
			
		}
		
		
		
		

	}

}
