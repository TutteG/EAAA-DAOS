package application.model;

public class MainApp {
	public static void main(String[] args) {
		Lottoraek[] rows = new Lottoraek[10000000];

		for (int i = 0; i < 10000000; i++) {
			rows[i] = new Lottoraek();
		}

		Lottoraek rigtigRow = new Lottoraek();
		int antal = 0;
		int[] antalRigtigeRaekker = new int[8];
		long startTime = System.nanoTime();
		for (int i = 0; i < rows.length; i++) {
			antal = rows[i].antalrigtige(rigtigRow);
			antalRigtigeRaekker[antal]++;
		}

		long endTime = System.nanoTime();
		for (int i = 0; i < antalRigtigeRaekker.length; i++) {
			System.out.println(i + " Rigtige: " + antalRigtigeRaekker[i]);
		}
		System.out.println("Total tid brugt: " + ((endTime - startTime) / 1000000));
	}
}
