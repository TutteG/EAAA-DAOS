package opgave10;

public class mainApp {
	public static void main(String[] args) {
		Common common = new Common();
		CommonThread t1 = new CommonThread("Niels", common);
		CommonThread t2 = new CommonThread("Jens", common);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(common.getGlobal());

	}
}
