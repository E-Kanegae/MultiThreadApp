package org.ek.sample.thread.guarded;

import java.util.Random;

public class ServerThread extends Thread {
	private final Random random;
	private final RequestQueue q;

	public ServerThread(RequestQueue q, String name, long seed){
		super(name);
		this.q = q;
		this.random = new Random(seed);
	}

	public void run(){
		for(int i = 0; i < 1000; i++){
			Request req = q.get();
			System.out.println(Thread.currentThread().getName() + " handles " + req);

			try {
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
