package day1109.test6.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainAnnoEx6 {

	public static void main(String[] args) {
		//(12) appcontext2.xml�� ����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("appcontext2.xml");
		
		//(13) id=mycar�� ����
		AnnoCar car1=(AnnoCar)ctx.getBean("mycar");
		car1.myCarInfo();

	}

}
