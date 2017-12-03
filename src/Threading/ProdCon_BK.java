package Threading;

public class ProdCon_BK {
	static Integer[] q = new Integer[3];
	final static int MAX = 3;
	static int index = 0;
	static int step = 0;

	public static void main(String[] args) {
		Consumer con = new Consumer();
		Producer prod = new Producer();
		Thread p = new Thread(prod);
		p.setName("Producer");
		Thread c = new Thread(con);
		c.setName("Consumer");
		p.start();
		c.start();
	}

	private static void doWait() {
		System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Waiting....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Consumer implements Runnable {

		@Override
		public synchronized void run() {
			while (true) {
				while (index <= 0) {
					doWait();
				}
				synchronized (q) {
					index--;
					int val = q[index];
					System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Value " + val
							+ " from the index " + index);
					step++;
				}
			}
		}

	}

	static class Producer implements Runnable {

		@Override
		public void run() {
			while (true) {
				while (index >= MAX) {
					doWait();
				}
				int val = (int) (Math.random() * 100);
				synchronized (q) {
					q[index] = val;
					index++;
					step++;
					System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Value " + val
							+ ", now size is " + index);
				}
			}
		}

	}
}