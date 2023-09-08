package bit701.day0908;
import bit701.day0908.hello.*;
public class Ex1Object {

	public static void main(String[] args) {
		//다른 패키지의 클래스를 생성해보자
		MyHello my=new MyHello();
		my.hello();
		//같은 패키지에 있는 클래스 선언
		//다른 클래스라도 같은 패키지일경우 private 제외하고 모두 접근가능
		//패키지가 다를경우는 상속관계가 아닐경우 public만 유일하게 접근가능
		Test t=new Test();
		System.out.println("퍼블릭 맴버변수 출력"+t.str1);
		System.out.println("프로텍티드 맴버변수 출력"+t.str2);
		System.out.println("디폴트 맴버변수 출력"+t.str3);
		//System.out.println("프라이빗 맴버변수 출력"+t.str4);//여기만 에러발생
	}

}
