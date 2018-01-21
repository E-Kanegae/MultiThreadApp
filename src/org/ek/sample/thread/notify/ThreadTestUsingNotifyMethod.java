package org.ek.sample.thread.notify;

import java.util.Date;

public class ThreadTestUsingNotifyMethod extends Thread {

	// locked by threads object
	static Object lockedObj = new Object();

	// thread run
	public void run(){
		System.out.println(Thread.currentThread().getName() + " was just stared!");

		synchronized (lockedObj) {
			System.out.println(Thread.currentThread().getName() + " locked Object!");
			try {
				lockedObj.wait();
				System.out.println(Thread.currentThread().getName() + " released lock.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("Time is " + new Date(System.currentTimeMillis()));
			System.out.println(" . Thread is " + Thread.currentThread().getName());
		}
	}

	public static void main(String args[]){
		ThreadTestUsingNotifyMethod t1 = new ThreadTestUsingNotifyMethod();
		ThreadTestUsingNotifyMethod t2 = new ThreadTestUsingNotifyMethod();
		ThreadTestUsingNotifyMethod t3 = new ThreadTestUsingNotifyMethod();

		t1.start();
		t2.start();
		t3.start();

		try {
			Thread.sleep(5000); //全てのThreadが待てるように5秒待つ。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (lockedObj) {
			lockedObj.notify();
		}

	}
}
