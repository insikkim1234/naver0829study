package bit701.day0901;

public class Ex4_For {

	public static void main(String[] args) {
		for (int a=1; a<0;a++) {//초기값이 1인데 0보다 작아야만 실행하므로 실행 안되는 문장
			System.out.println("a="+a);
		}
		System.out.println("=".repeat(30));//.repeat앞에있는걸 30번 반복 
		
		
		for(int a=1;a<=10;a++)//int a=1은 for문안에서만 사용가능한 지역변수
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		
		for(int a=1;a<=20;a+=3)//1 4 7 10....
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		for(int a=10;a>=1;a--)
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		//다중  for문
		for(int i=1;i<=3;i++)
		{
			System.out.println("i="+i);
			
			for(int j=1;j<=5;j++) {
				System.out.printf("%3d",j);
			}
			System.out.println();
		}
		System.out.println("=".repeat(30));
		
		
				

	}

}
