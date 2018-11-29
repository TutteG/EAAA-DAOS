package thread;

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
		while (true) {
			if (!common.QueueIsEmpty()) {
				common.yellCount();
			} else {
				try {
					System.out.println("zzzzzzzz");
					sleep(5000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
