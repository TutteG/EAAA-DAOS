package opgave9;

import dyrelyd.Rand;

public class CommonThread extends Thread {
	String navn;
	Common common;
	static boolean[] locked = new boolean[2];
	static int turn = 0;

	public CommonThread(String name, Common common) {
		super();
		this.navn = name;
		this.common = common;
	}

	@Override
	public void run() {
		int myTurn = Integer.parseInt(navn);
		int otherTurn = myTurn == 0 ? 1 : 0;
		locked[myTurn] = true;
		while (locked[otherTurn] && turn == otherTurn) {
			// fuck off
			try {
				Rand rand = new Rand(0, 10);
				sleep(rand.randomInRange());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 100; i++) {
			common.opdaterGlobal();
			common.TagerRandomTid(1);
		}
		locked[myTurn] = false;
	}

}
