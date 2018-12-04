package opgave4;

public class Common {

	private final String[] buffer;
	private final int capacity;

	private int nextIn;
	private int nextOut;
	private int count;

	public Common(int capacity) {
		super();
		this.capacity = capacity;
		buffer = new String[capacity];
		nextIn = 0;
		nextOut = 0;
		count = 0;
	}

	public synchronized void append(String x) throws InterruptedException {
		try {
			if (count == capacity) {
				wait();
			}
			buffer[nextIn] = x;
			System.out.println(buffer[nextIn] + " har trukket nr. " + (nextIn + 1));
			nextIn = (nextIn + 1) % capacity;
			count++;
		} finally {
			notifyAll();
		}
	}

	public synchronized void take(String x) throws InterruptedException {
		try {
			while (count == 0) {
				wait();
			}
			System.out.println(x + " Råber \"Det er nu nr. " + (nextOut + 1) + ": " + buffer[nextOut] + "!\"");
			nextOut = (nextOut + 1) % capacity;
			count--;
		} finally {
			notify();
		}
	}

}
