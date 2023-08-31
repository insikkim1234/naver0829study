package bit701.day0831;

import java.util.Scanner;

public class Ex1_KeyInput {

	public static void main(String[] args) {
		//System.out 
		//System.in입력 
		//변수나 메서드가 스태틱인 경우 클래스명으로 가져옴
		Scanner sc=new Scanner(System.in);
		//<변수 메서드 생성시new를 써야할때와 말아야할때>
		//sc는 인스턴스 변수(스태틱이 안붙ㄴ은 변수)
		//new로 객체를 생성하고 이 변수를 인스턴스 변수라고 함
		//static 변수나 메서드는 new로 객체생성하지 않고 호출
		//대표적으로 Math ㅋ클래스의 모든 메서드는 Static
		//System.out.println("3의 5승: "+Math.pow(3, 5));
		//math 작성후 도움말 누르면 자동완성
		//System.out.println("5와 7중 더큰값은"+Math.max(5, 7));
		
		
		System.out.println("당신의 나이를 입력하세요");
		int age=sc.nextInt();
		//이때 한글로 이십오세 라고 치면 안됨
		System.out.println("응 나는 "+age+"세야");
		
		
		
		
		//nextInt 먼저 받고nextLine받으면 이름을 입력받을수 없게됨
		//숫자 입력후 문자열을 입력받는 경우 입력 안되는 현상발생
		//왜냐하면 숫자 입력후 발생하는 엔터값이 버퍼에 저장되는데 
		//문자열 입력시 이 버퍼를 먼저읽고 없을경우 키보드로 읽기 때문
		//(숫자 숫자 입력시에는 상관없음)32
		
		//방법1 버퍼의 엔터문자를 먼저 읽어서 없앤다sc.nextLine();사용
		//방법2 숫자를 읽을경우도 무조건 nextLine으로 문자열로 입력후 변환해서 사용한다 23줄에 nextLine으로 읽음
		sc.nextLine();
		
		System.out.println("당신의 이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("내이름은 "+name+"입니다");
		
		
	}

}
