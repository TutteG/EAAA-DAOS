package opgave10;

import java.util.concurrent.Semaphore;

public class CommonThread extends Thread {
	String navn;
	Common common;
	static Semaphore semaphore = new Semaphore(1);

	public CommonThread(String name, Common common) {
		super();
		this.navn = name;
		this.common = common;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			for (int i = 0; i < 100; i++) {
				common.opdaterGlobal();
				common.TagerRandomTid(22);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		semaphore.release();
	}

}
