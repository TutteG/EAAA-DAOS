package monitor;

public class OfficeThread extends Thread {
	Common common;

	public OfficeThread(Common common) {
		// TODO Auto-generated constructor stub
		super();
		this.common = common;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			common.drawCount();
		}
	}
}
