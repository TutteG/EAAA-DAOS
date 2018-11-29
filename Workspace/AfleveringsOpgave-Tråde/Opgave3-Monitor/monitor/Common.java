package monitor;

public class Common {
	private int count = 0;
	private int queueLast = 0;

	public boolean QueueIsEmpty() {
		return queueLast == count;
	}

	public synchronized void drawCount() {
		queueLast++;
	}

	public void yellCount() {
		count++;
		System.out.println("det er nu!: " + count);
	}
}
