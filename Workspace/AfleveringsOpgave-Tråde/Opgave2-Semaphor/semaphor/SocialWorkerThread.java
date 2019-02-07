package semaphor;

public class SocialWorkerThread extends Thread {
	Common common;

	public SocialWorkerThread(Common common) {
		super();
		this.common = common;
	}

	@Override
	public void run() {
		try {
			common.yellCount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
