package org.ek.sample.future;

public class FutureMain {

	public static void main(String[] args) {
		System.out.println("Future main BEGIN");
		FutureHost host = new FutureHost();

		IData data1 = host.request(10, 'A');
		IData data2 = host.request(100, 'B');
		IData data3 = host.request(300, 'C');

		System.out.println("data1 is " + data1.getContent());
		System.out.println("data2 is " + data2.getContent());
		System.out.println("data3 is " + data3.getContent());
		System.out.println("Future main END");
	}

}
