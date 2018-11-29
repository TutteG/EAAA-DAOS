package opgavemedmutex;

import sun.awt.Mutex;

public class CommonThread extends Thread {
	String navn;
	Common common;
	private static Mutex mut = new Mutex();

	public CommonThread(String name, Common common) {
		super();
		this.navn = name;
		this.common = common;
	}

	@Override
	public void run() {
		mut.lock();
		for (int i = 0; i < 100; i++) {
			common.opdaterGlobal();
			common.TagerRandomTid(22);
		}
		mut.unlock();
	}
}
