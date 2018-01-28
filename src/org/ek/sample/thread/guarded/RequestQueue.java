package org.ek.sample.thread.guarded;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue implements Serializable {

	private final Queue<Request> q = new LinkedList<Request>();

	public synchronized Request get(){
		while(q.peek() == null){

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return q.remove();
	}

	public synchronized void put(Request req){
		q.offer(req);
		notifyAll();
	}

}
