package opgavemedmutex;

public class CommonThread extends Thread {
	String navn;
	Common common;

	public CommonThread(String name, Common common) {
		super();
		this.navn = name;
		this.common = common;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			common.opdaterGlobal();
			common.TagerRandomTid(22);
		}
	}
}
