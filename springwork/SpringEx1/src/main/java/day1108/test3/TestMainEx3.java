package day1108.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	//(4)bean �� ����� �����͸� appcontext1.xml�� �ۼ�
public class TestMainEx3 {

	public static void main(String[] args) {
		//(5)appcontext1.xml�� ���� 
		ApplicationContext context=new ClassPathXmlApplicationContext("appcontext1.xml");
		//(6)Person�� ���� �����͸� appcontext1.xml�κ��� �޾ƿ�
		Person p=(Person)context.getBean("person");
		//(7)���
		p.writeProcee();
	}

}
