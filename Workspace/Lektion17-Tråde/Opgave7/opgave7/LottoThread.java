package opgave7;

public class LottoThread extends Thread {
	int minRange;
	int maxRange;
	Lottoraek[] rows;
	Lottoraek rigtige;
	int[] antalRigtigeRaekker;

	public LottoThread(int minRange, int maxRange, Lottoraek[] rows, Lottoraek rigtige, int[] antalRigtigeRaekker) {
		super();
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.rows = rows;
		this.antalRigtigeRaekker = antalRigtigeRaekker;
		this.rigtige = rigtige;
	}

	@Override
	public void run() {
		int antal = 0;
		for (int i = minRange; i < maxRange; i++) {
			antal = rows[i].antalrigtige(rigtige);
			antalRigtigeRaekker[antal]++;
		}
	}
}
