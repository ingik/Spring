package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 1.인터페이스Tv를 상속받아 LgTV, SamsungTV 완성
		// 2.bean 설정 관련 anotation을 작성 한 다음
		// 3.main에서 설정 파일을 읽어 bean을 등록 한뒤
		// 4. getBean()을 통해 생성된 bean을 확인

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/ApplicationContext.xml");
		TV tv = factory.getBean("lgTV", TV.class);
		tv.powerOn();
		tv.powerOff();
		tv.volUp();
		tv.volDown();

		tv = factory.getBean("samsung", TV.class);
		tv.powerOn();
		tv.powerOff();
		tv.volUp();
		tv.volDown();

	}
}
