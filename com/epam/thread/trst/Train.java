package com.epam.thread.trst;


public class Train {


	private boolean direction;
	
	public Train(boolean direction) {
		this.direction = direction;
	}
	
	public boolean getDirection(){
		return direction;
	}
	
	public void busyGo(){
		try {
			Thread.sleep(3_000);
		} catch (InterruptedException e) {
		}
	}
	
	public void restGo(){
		try {
			Thread.sleep(7_000);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public String toString() {
		return "Train [direction=" + direction + "]";
	}
	
}
