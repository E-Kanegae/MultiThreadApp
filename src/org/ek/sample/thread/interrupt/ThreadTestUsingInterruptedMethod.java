package org.ek.sample.thread.interrupt;

import java.util.Date;

public class ThreadTestUsingInterruptedMethod {

	public static void main(String[] args) {

		Thread t = new Thread(){
			public void run(){
				while(!Thread.interrupted()){
					System.out.println("Not yet interrupted. Time is " + new Date(System.currentTimeMillis()).toString());
				}
				System.out.println("Just now, interrupted. Time is " + System.currentTimeMillis());
				// 一度、interruptされてからはフラグがfalseになることの確認
				System.out.println("Thread interrupt flag is " + isInterrupted());
			}
		};

		t.start();

		try {
			Thread.sleep(5000); // 5秒後にinterrupt
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}

}
