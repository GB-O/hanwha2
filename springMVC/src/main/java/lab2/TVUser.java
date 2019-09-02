package lab2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab2.xml");
		
		TV tv = (TV)context.getBean("stv");
		tv.powerOn();
		tv.powerOff();
		
		//Resource resource =  new ClassPathResource("lab2.xml"); 
		//BeanFactory factory = new XmlBeanFactory(resource); 
		
	}
}
