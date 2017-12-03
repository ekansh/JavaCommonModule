package Threading;

public class ThreadDeleteme {
	public static void main(String[] args) {
		Work w = new Work();
		Thread t1 = new Thread(w);
		t1.setName("Thread 1 ");
		Thread t2 = new Thread(w);
		t2.setName("Thread 2 ");
		Thread t3 = new Thread(w);
		t3.setName("Thread 3 ");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("ThreadDeleteme.main()");
	}

}

class Work implements Runnable {
	Integer i = 0;

	@Override
	public void run() {
		while (i < 100) {
			System.out.println(Thread.currentThread().getName() + " " + i);
				
				i++;
			}
	}
}
