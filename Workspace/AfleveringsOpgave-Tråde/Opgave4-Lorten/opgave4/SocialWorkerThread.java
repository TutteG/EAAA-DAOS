package opgave4;

public class SocialWorkerThread extends Thread {
	Common common;

	public SocialWorkerThread(Common common) {
		// TODO Auto-generated constructor stub
		super();
		this.common = common;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			try {
				common.take();
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
