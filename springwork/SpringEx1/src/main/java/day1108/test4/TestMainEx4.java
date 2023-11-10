package day1108.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx4 {

	public static void main(String[] args) {
		// (10)메인함수에 (9)에서 작성한 beans파일을 불러오기(데이터 저장)
		ApplicationContext context=new ClassPathXmlApplicationContext("appcontext1.xml");
		//(11) 메인클래스(Bitcamp.java)연결
		Bitcamp bit=(Bitcamp)context.getBean("bit");
		//(12) 출력해주는 함수 실행
		bit.infoProcess();
	}

}
