package monitor;

public class mainApp {
	public static void main(String[] args) {
		Common common = new Common();
		OfficeThread o1 = new OfficeThread(common);
		OfficeThread o2 = new OfficeThread(common);
		SocialWorkerThread sw = new SocialWorkerThread(common);

		o1.start();
		o2.start();
		sw.start();
		try {
			o1.join();
			o2.join();
			sw.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
