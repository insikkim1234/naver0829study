package day1108.test2;

public class Message2 implements MessageInter {

	//(3)인터페이스에서 만든 함수 오버라이드 한 후
	//당신의 이름은 name입니다 출력해주는 함수 작성
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("당신의 이름은"+name+"입니까");
	}

}
