package org.ek.sample.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements IData {

	public FutureData(Callable<RealData> callable) {
		super(callable);
	}

	@Override
	public String getContent() {
		String string = null;
		try {
			string = get().getContent();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return string;
	}

}
