package opgave11;

public class Common {
	int global = 0;

	public Common() {
		// TODO Auto-generated constructor stub

	}

	public int getGlobal() {
		return global;
	}

	public void TagerRandomTid(int max) {
		for (int i = 0; i < max; i++) {
			int tal = 0;
			for (int j = 0; j < max; j++) {
				String abe = "Abe";
				String kat = "kat";
				String abekat = abe + kat + (tal = tal + 1 * max);
			}
		}
	}

	public synchronized void opdaterGlobal() {
		int temp;
		temp = global;
		TagerRandomTid(10);
		global = temp + 1;

	}
}
