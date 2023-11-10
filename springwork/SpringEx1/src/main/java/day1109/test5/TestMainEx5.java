package day1109.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx5 {

	public static void main(String[] args) {
		//(7) appcontext2.xml안에 
		//CanadaTire과 연동시키는 ctire
		//KoreaTire과 연동시키는 ktire 선언후 연결
		ApplicationContext ctx=new ClassPathXmlApplicationContext("appcontext2.xml");
		
		//(8) appcontext2.xml안에 Car.java와 연결시키기 위한
		// ctire과 연결시키는 car1
		// ktire과 연결시키는 car2 선언 후 연결
		Car car1=(Car)ctx.getBean("car1");
		car1.myCarInfo();
		
		Car car2=(Car)ctx.getBean("car2");
		car2.myCarInfo();

	}

}
