package day1108.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx4 {

	public static void main(String[] args) {
		// (10)�����Լ��� (9)���� �ۼ��� beans������ �ҷ�����(������ ����)
		ApplicationContext context=new ClassPathXmlApplicationContext("appcontext1.xml");
		//(11) ����Ŭ����(Bitcamp.java)����
		Bitcamp bit=(Bitcamp)context.getBean("bit");
		//(12) ������ִ� �Լ� ����
		bit.infoProcess();
	}

}
