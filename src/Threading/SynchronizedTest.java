package Threading;

public class SynchronizedTest {
	static Integer index = 0;
	static int[] q = new int[8];
	static Object lock = new Object();
	public static void main(String[] args) {
		
		Producer prod = new Producer();
		Thread p1 = new Thread(prod);
		p1.setName("Producer-1");
		Thread p2 = new Thread(prod);
		p2.setName("Producer-2");
		p2.start();
		p1.start();

		System.out.println("main ends");
	}

	static class Producer implements Runnable {
		@Override
		public  void run() {
			int j=0;
			while (j++<3) {
				int val =(int) (Math.random() * 100);
				synchronized (lock) {
					q[index] =val ;
					index++; 
					System.out.println("Thread name " + Thread.currentThread().getName() + " writing at " + index+" val = "+val);
					
				}
			}
		}

	}
}