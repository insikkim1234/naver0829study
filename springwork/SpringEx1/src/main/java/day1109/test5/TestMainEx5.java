package day1109.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx5 {

	public static void main(String[] args) {
		//(7) appcontext2.xml�ȿ� 
		//CanadaTire�� ������Ű�� ctire
		//KoreaTire�� ������Ű�� ktire ������ ����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("appcontext2.xml");
		
		//(8) appcontext2.xml�ȿ� Car.java�� �����Ű�� ����
		// ctire�� �����Ű�� car1
		// ktire�� �����Ű�� car2 ���� �� ����
		Car car1=(Car)ctx.getBean("car1");
		car1.myCarInfo();
		
		Car car2=(Car)ctx.getBean("car2");
		car2.myCarInfo();

	}

}
