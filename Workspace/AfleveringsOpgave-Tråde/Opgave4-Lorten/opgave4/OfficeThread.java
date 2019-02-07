package opgave4;

public class OfficeThread extends Thread {
	Common common;
	String name;

	public OfficeThread(Common common, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.common = common;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				common.append(name);
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
