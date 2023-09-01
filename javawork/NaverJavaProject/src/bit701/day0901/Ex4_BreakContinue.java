package bit701.day0901;

public class Ex4_BreakContinue {

	public static void main(String[] args) {
		
		
		for(int a=1;a<=10;a++) {

			System.out.printf("%3d",a);
			if(a==5)
				break;//반복문은 10번 반복되야하지만 a=5일때 탈출

		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		

		for(int a=1;a<=10;a++) {
			if(a%2==0)//짝수일경우 출력하지 않고 다음숫자로 가고자 할경우
				continue;//a++증감식으로 이동
			System.out.printf("%3d",a);

		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		//다중for문일 경우 한번에 두개의 반복문을 빠져나가고자 할 경우 라벨Exit 달기
		Exit:
		for(int i=1;i<=3;i++)
		{
			
			
			for(int j=1;j<=5;j++)
			{
				System.out.printf("%3d",j);
				if (j==3)
					break Exit;//가 3이 되면 두개의 반복문을 모두 빠져나와서 1 2 3만 출력되고 나머지는 출력 안됨
			}
			System.out.println();
		}
		System.out.println("-".repeat(30));

	}

}
