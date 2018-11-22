package opgave7;

public class MainApp {
	public static void main(String[] args) {
		int something = 10000000;
		Lottoraek[] rows = new Lottoraek[something];

		for (int i = 0; i < something; i++) {
			rows[i] = new Lottoraek();
		}

		Lottoraek rigtigRow = new Lottoraek();
		int[] antalRigtigeRaekker1 = new int[8];
		int[] antalRigtigeRaekker2 = new int[8];
		LottoThread t1 = new LottoThread(0, rows.length / 2, rows, rigtigRow, antalRigtigeRaekker1);
		LottoThread t2 = new LottoThread(rows.length / 2, rows.length, rows, rigtigRow, antalRigtigeRaekker2);
		long startTime = System.nanoTime();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		for (int i = 0; i < antalRigtigeRaekker1.length; i++) {
			System.out.println(i + " Rigtige: " + (antalRigtigeRaekker1[i] + antalRigtigeRaekker2[i]));
		}
		System.out.println("Total tid brugt: " + ((endTime - startTime) / 1000000));
	}
}
