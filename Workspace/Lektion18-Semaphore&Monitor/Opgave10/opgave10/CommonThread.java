package opgave10;

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
			try {
				common.opdaterGlobal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			common.TagerRandomTid(22);
		}

	}

}
