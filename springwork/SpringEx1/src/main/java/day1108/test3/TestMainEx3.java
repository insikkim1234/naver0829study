package day1108.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	//(4)bean 에 사용할 데이터를 appcontext1.xml에 작성
public class TestMainEx3 {

	public static void main(String[] args) {
		//(5)appcontext1.xml과 연결 
		ApplicationContext context=new ClassPathXmlApplicationContext("appcontext1.xml");
		//(6)Person에 관한 데이터를 appcontext1.xml로부터 받아옴
		Person p=(Person)context.getBean("person");
		//(7)출력
		p.writeProcee();
	}

}
