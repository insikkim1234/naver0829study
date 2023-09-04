package bit701.day0904;

public class Ex3_Random {

	public static void main(String[] args) {
		/*
		 * 난수 발생시키는 방법2가지
		 * 1.Math.random()을 이용
		 * 2.new Random()을 이용
		 */
		for(int i=0;i<=5;i++)
		{
			double r=Math.random();//0.0보다 크거나같고 1.0보다 작은 난수를 발생시킨다
			System.out.println(r);
		}
		System.out.println("=".repeat(30));
		for(int i=0;i<5;i++)
		{
			//int n=(int)(Math.random()*10);//0~9까지 난수
			int n=(int)(Math.random()*10+1);//10 곱하고(0~9) 1더하고(1~10) int로 디모션해서 1~10까지난수 발생
			System.out.println(n);
		}
		
		
		System.out.println("=".repeat(30));
		for(int i=0;i<5;i++)
		{
			//int n=(int)(Math.random()*10);//0~9까지 난수
			int n=(int)(Math.random()*26+65);//65부터 90까지 난수 발생(아스키코드 대문자)//26개이므로 
			System.out.println((char)n);
		}
		
		System.out.println("=".repeat(30));
		for(int i=0;i<5;i++)
		{
			//int n=(int)(Math.random()*10);//0~9까지 난수
			int n=(int)(Math.random()*26+97);//97부터 122까지 난수 발생(아스키코드 소문
			System.out.println((char)n);
		}

	}

}
