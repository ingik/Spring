package com.test03;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("lg tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg tv off");
	}

	@Override
	public void volUp() {
		System.out.println("lg tv vol up");
	}

	@Override
	public void volDown() {
		System.out.println("lg tv vol down");
	}
	
}
