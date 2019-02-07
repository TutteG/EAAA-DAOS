package monitor;

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
		try {
			common.yellCount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
