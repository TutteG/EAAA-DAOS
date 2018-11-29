package semaphor;

import java.util.concurrent.Semaphore;

public class Common {
	private int count = 0;
	private int queueLast = 0;
	Semaphore sema = new Semaphore(1);

	public boolean QueueIsEmpty() {
		return queueLast == count;
	}

	public void drawCount() throws InterruptedException {
		sema.acquire();
		queueLast++;
		sema.release();
	}

	public void yellCount() {
		count++;
		System.out.println("det er nu!: " + count);
	}
}
