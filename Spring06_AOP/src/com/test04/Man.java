package com.test04;

public class Man implements Person{

	@Override
	public String classWork() {
		String s=null;
//		s.length();
		System.out.println("Man 메소드 실행");
		return "스프링";
	}

}
