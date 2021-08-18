package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		//getBean을 통해 생성된 bean(myNickNamePrn 클래스 빈) 확인
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test01/ApplicationContext.xml");
		MyNickNamePrn my = factory.getBean("myNickNamePrn",MyNickNamePrn.class);
		System.out.println(my);
	}

}
