package version2;

import dyrelyd.Rand;

public class CommonThread extends Thread {
	String navn;
	Common common;

	public CommonThread(String name, Common common) {
		super();
		this.navn = name;
		this.common = common;
	}

	@Override
	public void run() {
		int myTurn = Integer.parseInt(navn);
		int otherTurn = myTurn == 0 ? 1 : 0;
		common.locked[myTurn] = true;
		common.turn = otherTurn;
		while (common.locked[otherTurn] && common.turn == otherTurn) {
			// fuck off
			try {
				Rand rand = new Rand(10, 0);
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
		common.locked[myTurn] = false;
	}

}
