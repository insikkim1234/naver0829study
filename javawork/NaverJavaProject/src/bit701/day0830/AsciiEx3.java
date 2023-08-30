package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		//char과 int는 같은 타입이라고 봐도됨
		char a1=65;
		//char하고 숫자를 입력하면 그 숫자에
		//대응되는 문자가 나온다
		int a2='b';
		System.out.println(a1);
		System.out.println(a2);
		//원래대로 숫자로 나오게 하는법
		System.out.println((int)a1);
		System.out.println((char)a2);
		System.out.printf("%d의 아스키문자는 %c이다\n",(int)a1,a1);

		char b1='C';
		int b2=68;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1+1);
		//C는 67이므로 거기다1더하면 68
		System.out.println(b1+2);
		//묵시적 형변환(이때 +는 마냥 더하는게 아니라 연산을 의미)
		//에 의해서 char+int=int
		//그러므로 E가 아니라 69가 나온다
		/*char+int=int
		 * int+int=int
		 * long+int=long<<정수 정수이면 무조건 큰거따름
		 * double+int=double
		 * String+int=String
		 * String+double=String
		 * <묵시적 형변환의 예>
		 */
		System.out.println((char)(b1+2));
		//b1+2는 69인데 이는 int 타입인데 
		//char로 강제 형변환해서 출력한 예시
		
		System.out.println(5/2);
		//2로 나옴 왜냐면 int 와 int의 연산이므로
		System.out.println(5.0/2);
		//2.5로 나옴 왜냐면더블과 인트의 연산이므로
		System.out.println((double)5/2);
		//2.5로 나옴 왜냐면 5만 더블로 인식되는것이기 때문
		System.out.println((double)(5/2));
		//5/2를(int+int=int) 더블로 바꾸는 것이기 때문에 2.0
	    //print나 println은 모든 타입 출력이 가능하다
		//이유는 타입별로 여러개ㅇ를 같은 이름으로 만들어놔서
		//이런 메서드를 중복함수(overloading method)라고 한다
	
	}

}
