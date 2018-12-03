package opgave4;

public class mainApp {
	public static void main(String[] args) {
		Common common = new Common(100);
		OfficeThread o1 = new OfficeThread(common, "Niels");
		OfficeThread o2 = new OfficeThread(common, "Arne");
		SocialWorkerThread sw1 = new SocialWorkerThread(common);
		SocialWorkerThread sw2 = new SocialWorkerThread(common);

		o1.start();
		o2.start();
		sw1.start();
		sw2.start();
		try {
			o1.join();
			o2.join();
			sw1.join();
			sw2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
