package lab4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lab4Test {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab4.xml");
		
		Car c = context.getBean("car", Car.class);
		System.out.println(c);
		
		People p = context.getBean("people", People.class);
		System.out.println(p);
		
	}
}
