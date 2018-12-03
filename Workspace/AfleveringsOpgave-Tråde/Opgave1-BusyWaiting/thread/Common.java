package thread;

public class Common {
	public volatile int count = 0;
	public volatile int queueLast = 0;

	public boolean QueueIsEmpty() {
		return queueLast == count;
	}

	public int drawCount() {
		queueLast++;
		System.out.println(queueLast + " Er nu trukket");
		return queueLast;
	}

	public void yellCount() {
		count++;
		System.out.println("det er nu!: " + count);
	}
}
