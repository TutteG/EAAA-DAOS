package dyrelyd;

public class threadClass extends Thread {

	String dyrelyd;

	public threadClass(String dyrelyd) {
		super();
		this.dyrelyd = dyrelyd;
	}

	@Override
	public void run() {
		Rand rand = new Rand(0, 100);
		for (int i = 0; i < 5; i++) {
			try {
				sleep(rand.randomInRange());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dyrelyd);
		}

	}

}
