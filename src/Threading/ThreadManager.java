package Threading;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

	public static void main(String[] args) {
		DBTaskOfProduct createProductUsingGlass = new DBTaskOfProduct();
		createProductUsingGlass.setName("MUTEX");
		DBTaskOfProduct createProductUsingPlastic = new DBTaskOfProduct();
		createProductUsingPlastic.setName("MUTEX");
		DBTaskOfProduct createProductUsingMetal = new DBTaskOfProduct();
		createProductUsingMetal.setName("MUTEX");
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		CompletionService<Product> pool = new ExecutorCompletionService<Product>(threadPool);

		pool.submit(createProductUsingGlass);
		pool.submit(createProductUsingPlastic);
		pool.submit(createProductUsingMetal);

		System.out.println("Submitted the task");
		Product product1 = null;
		Product product2 = null;
		Product product3 = null;
		
		
		try {
			product1 = pool.take().get();
			product2 = pool.take().get();
			product3 = pool.take().get();
			System.out.println("product 1 "+product1);
			System.out.println("product 2 "+product2);
			System.out.println("product 3 "+product3);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
		System.out.println("Submitted the task..ends");

	}
}
