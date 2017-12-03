package Threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<?> future = executorService.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread going to sleep");
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("waking up");
			}
			

		});

		try {
			Object object = future.get();
			System.out.println("-->" + object);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
