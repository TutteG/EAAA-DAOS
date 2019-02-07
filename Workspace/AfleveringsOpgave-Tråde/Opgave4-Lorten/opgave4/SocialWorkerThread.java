package opgave4;

public class SocialWorkerThread extends Thread {
	Common common;
	String name;

	public SocialWorkerThread(Common common, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.common = common;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			try {
				common.take(name);
				sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
