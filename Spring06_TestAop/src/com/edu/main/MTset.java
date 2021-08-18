package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.entity.Shape;

public class MTset {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/edu/main/ApplicationContext.xml");
		Shape rect = factory.getBean("rect", Shape.class);
		Shape tri = factory.getBean("tri", Shape.class);

		rect.viewSize();
		tri.viewSize();
	}
}
