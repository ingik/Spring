package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BeanTest {
	private MyClass myClass;
	public BeanTest() {
		System.out.println("기본생성자(no-args)");
	}
	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date: "+date+ ")");
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass() 호출: "+myClass);
		
	}
	public void setDate(Date date) {
		System.out.println("setDate() 호출: "+date);
	}
	public void setNumber(int num) {
		System.out.println("setNumber() 호출:"+num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("setArray() 호출: ");
		for(String value:arr) {
			System.out.println("이름: "+value);
		}
	}
	public void setList(List<String> list) {
		System.out.println("setList() 호출");
		for(String value:list) {
			System.out.println(value);
		}
	}
	public void setMap(Map<String,String> map) {
		System.out.println("setMap() 호출");
		Collection<String> values = map.values();
		for(String value: values) {
			System.out.println(value);
		}
	}
	public void setScore(List<Score> list) {
		System.out.println("setScore() 호출: ");
		for(Score sc :list) {
			System.out.println(sc);
		}
	}
}
