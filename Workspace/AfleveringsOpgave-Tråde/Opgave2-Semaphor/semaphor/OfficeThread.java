package semaphor;

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
			try {
				common.drawCount();
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
