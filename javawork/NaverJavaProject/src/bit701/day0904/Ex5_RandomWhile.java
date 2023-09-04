package bit701.day0904;

import java.util.Scanner;

public class Ex5_RandomWhile {

	public static void main(String[] args) {
		/*
		 * 1부터 100까지 난수 발생시킨후 숫자 알아맞추기
		 * 
		 * 65가 발생시
		 * 1:60
		 * 60보다 큽니다
		 * 2:70
		 * 70보다 작습니다
		 * 
		 * 
		 * 
		 * 5:65
		 * 정답입니다(65)-맞출경우 종료
		 */
		
		Scanner sc=new Scanner(System.in);
		//1부터 100사이의 난수 결정
		int rnd=(int)(Math.random()*100)+1;
		//횟수 구할 변수
		int count=0;
		//입력 받은 변수
		int num;
		
		//조건식이 true인 while문을 이용하여 맞출때까지 반복시킨다
		
		while(true)
		{
			System.out.print(++count+":");
			num=sc.nextInt();
			if(num>rnd)
				System.out.println("\t"+num+"보다 적습니다");
			else if(num<rnd)
				System.out.println("\t"+num+"보다큽니다");
			else {
				System.out.println("\t정답입니다("+rnd+")");
				break;
			}
		}
		System.out.println("**프로그램 종료**");
		

	}

}
