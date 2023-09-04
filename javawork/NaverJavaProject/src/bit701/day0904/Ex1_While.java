package bit701.day0904;

public class Ex1_While {

	public static void main(String[] args) {
		/*
		 * 반복문에는 for while do while
		 * for문은 반복횟수가 정해진경우 사용
		 * while do while 반복횟수가 정해져 있지 않은 경우에 많이 사용
		 * while과  do while차이는 조건을 먼저 주느냐(선조건) 나중에 주느냐(한번 실행후 조건 부여do while) 차이임
		 */
		int a=65;//대문자a의 아스키 코드
		
		while(a<=90)//조건이 참인 동안 실행(a가 90 까지)a가 91이 되는 순간 반복문 탈출
		{
			/*System.out.println((char)a);
			a++;//while문은 증감식이 안에 있음*/
			System.out.print((char)a++);//후치이므로 이렇게 써도 상관없다
				
		}
		System.out.println();
		System.out.println("빠져나온후 a값"+a);
		
		
		a=65;
		while(true)
		{
			System.out.print((char)a++);
			if(a>90) {
				break;
			}
		}
		System.out.println();
		
		
		a=65;
		do {
			System.out.print((char)a++);
		}while(a<=90);//조건뒤에 반드시 ;추가
		
		
		
		
		System.out.println();
		int n=10;
		/*while(n<10)
		{
			System.out.println(n--);
		}//조건이 거짓이기에 n=10인데 10미만만 받으므로 한번도 반복하지 않는다*/
		do {
			System.out.println(n--);
			if(n==0)
				break;
		}while(n<10);//do while은 무조건 한번은  실행하기에 무한루프하기 때문에 0일때 break 문으로 탈출
	}

}
