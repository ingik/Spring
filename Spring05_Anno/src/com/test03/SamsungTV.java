package com.test03;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("samsungTV on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsungTV off");
	}

	@Override
	public void volUp() {
		System.out.println("samsungTV vol up");
	}

	@Override
	public void volDown() {
		System.out.println("samsungTV vol down");
	}

}
