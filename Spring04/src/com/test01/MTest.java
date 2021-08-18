package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
			new ClassPathXmlApplicationContext("com/test01/ApplicationContext.xml");
		MyClass my = (MyClass) factory.getBean("myClass");
		my.prn();
		
		BeanTest bean = factory.getBean("beanTest",BeanTest.class);
		
	}

}
