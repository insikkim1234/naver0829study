package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감연산자 :++1씩 증가 --1씩감소
		//변수앞에 붙일경우 1순위 전치
		//변수뒤에붙일경우 끝순위후치
		//단,단항으로 사용할경우 상관없음
		int a=5;
		int b=5;
		//단항으로 연산할경우 
		++a;
		System.out.println(a);//1증가
		b++;
		System.out.println(b);//1증가
		System.out.println(++a);//먼저 증가후 출력
		System.out.println(b++);//먼저 출력후 증가
		//출력은 6으로 b값은 7
		System.out.println("a="+a+",b="+b);//7 7
		
		a=b=5;
		int m=++a;//증가후대입
		int n=b++;//대입후증가
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
	}

}
