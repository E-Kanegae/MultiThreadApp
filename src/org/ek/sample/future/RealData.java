package org.ek.sample.future;

public class RealData implements IData {
	private final String content;

	public RealData(int count, char c){
		System.out.println("  making RealData(" + count + ", " + c + ") BEGIN");
		char[] buf = new char[count];

		for(int i =0; i < count; i++){
			buf[i] = c;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("  making RealData(" + count + ", " + c + ") END");
		this.content = new String(buf);
	}

	@Override
	public String getContent() {
		return this.content;
	}

}
