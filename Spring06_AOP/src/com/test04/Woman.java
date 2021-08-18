package com.test04;

public class Woman implements Person {

	@Override
	public String classWork() {
		System.out.println("Woman 메소드 실행");
		return "스프링";
	}

}
