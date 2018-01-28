package org.ek.sample.thread.guarded;

public class GuardedSuspensionMain {

	public static void main(String[] args) {
		RequestQueue q = new RequestQueue();
		new ClientThread(q, "Client", 3141592).start();
		new ServerThread(q, "Server1", 6535897).start();
		new ServerThread(q, "Server2", 6535897).start();

	}

}
