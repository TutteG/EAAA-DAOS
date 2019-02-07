package monitor;

public class Common {
	private int count = 0;
	private int queueLast = 0;

	public boolean QueueIsEmpty() {
		return queueLast == count;
	}

	public synchronized void drawCount() throws InterruptedException {
		queueLast++;
		notifyAll();
	}

	public synchronized void yellCount() throws InterruptedException {
		while (true) {
			while (QueueIsEmpty()) {
				System.out.println("sleep");
				wait();
			}
			count++;
			System.out.println("det er nu!: " + count);
		}
	}
}
