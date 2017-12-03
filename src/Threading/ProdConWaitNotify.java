package Threading;

public class ProdConWaitNotify {
	static Integer[] q = new Integer[5];
	static int size = 5;
	static int step = 0;

	public static void main(String[] args) {
		Consumer1 con = new Consumer1();
		Producer1 prod = new Producer1();
		Thread p = new Thread(prod);
		p.setName("Producer");
		Thread c = new Thread(con);
		c.setName("Consumer");
		p.start();
		c.start();
	}

	static class Consumer1 implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (q) {
					step++;
					while (size == 0) {
						System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Waiting....");
						try {
							q.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					int val = q[size];
					size--;

					System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Value " + val);
					q.notify();
				}
			}

		}
	}

		static class Producer1 implements Runnable {

			@Override
			public void run() {
				while (true) {
					synchronized (q) {
						step++;
						while (size == 5) {
							System.out
									.println("Step " + step + " " + Thread.currentThread().getName() + " Waiting....");
							try {
								q.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						int val = (int) (Math.random() * 100);
						q[size]=val;
						size++;
						System.out.println("Step " + step + " " + Thread.currentThread().getName() + " Value " + val);
						q.notify();
					}
				}
			}
		}
	}
