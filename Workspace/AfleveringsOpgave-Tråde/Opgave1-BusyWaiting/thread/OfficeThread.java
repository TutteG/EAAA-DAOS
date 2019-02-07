package thread;

public class OfficeThread extends Thread {
	Common common;
	boolean[] locked = new boolean[2];
	static int turn = 0;
	static int id = 0;
	int myID = 0;

	public OfficeThread(Common common) {
		// TODO Auto-generated constructor stub
		super();
		this.common = common;
		id++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int otherTurn = myID == 0 ? 1 : 0;
		for (int i = 0; i < 50; i++) {
			locked[myID] = true;
			turn = otherTurn;
			while (locked[otherTurn] && turn == otherTurn) {
				try {
					sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			common.drawCount();
			locked[myID] = false;
		}
	}
}
