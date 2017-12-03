package Threading;


public class JoinExample {
	static int size=0;
	public static void main(String[] args) {
		Producer prod = new Producer();
		Thread p1= new Thread(prod);
		p1.setName("Producer-1");
		Thread p2= new Thread(prod);
		p1.setName("Producer-2");
		p2.start();
		p1.start();
		try {
			p1.join();
			p2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main ends");
	}

	
	static  class Producer implements Runnable {

		@Override
		public void run() {
			while (size <2){
			System.out.println("Thread name "+Thread.currentThread().getName()+" "+size++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}


	}
}