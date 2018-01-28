package org.ek.sample.thread.guarded;

import java.util.Random;

public class ClientThread extends Thread {
	private final Random random;
	private final RequestQueue q;

	public ClientThread(RequestQueue q, String name, long seed){
		super(name);
		this.q = q;
		this.random = new Random(seed);
	}

	public void run(){
		for(int i = 0; i< 1000;i++){
			Request req = new Request("No." + i);
			System.out.println(Thread.currentThread().getName() + " requests " + req);
			q.put(req);

			try {
				Thread.sleep(random.nextInt(2500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
