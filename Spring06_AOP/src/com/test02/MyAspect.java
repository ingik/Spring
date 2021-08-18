package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		//대상 객체 메소드 실행 전코드
		System.out.println("출석카드를 찍는다");
		try {
			//가로챈 대상 객체 메소드 실행
			target = invocation.proceed();
		} catch (Exception e) {
			//대상객체 메소드 실행중 예외 발생 시 코드
			System.out.println("쉬는 날이였다.");
			e.printStackTrace();
		}finally {
			//대상 객체 메서드 실행 후 코드
			System.out.println("집에 간다.");
		}
		
		return target;
	}
	
}
