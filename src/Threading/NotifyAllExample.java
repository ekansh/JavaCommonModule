package Threading;

import java.util.LinkedList;
import java.util.Queue;

public class NotifyAllExample {

	public static void main(String[] args) {
		Queue<Integer> q= new LinkedList<>();
		Producer2 task = new Producer2(q);
		Thread t1= new Thread (task);

		Thread t2= new Thread (task);

		Thread t3= new Thread (task);
		t1.start();t2.start();t3.start();
		
	}

}
class Producer2 implements Runnable {
	Object lock = new Object();
	Queue<Integer>  q;
	public Producer2(Queue<Integer>  q) {
		this.q=q;
	}
	@Override
	public void run() {
		int size=0;
		while(size++<=5){
			synchronized (q) {
				System.out.println(Thread.currentThread().getName()+" acquired the lock");
				q.notifyAll();
			}
		}
	}

}



class Consumer2 implements Runnable {
	Object lock = new Object();
	Queue<Integer>  q;
	public Consumer2(Queue<Integer>  q) {
		this.q=q;
	}
	@Override
	public void run() {
		int size=0;
		while(size++<=5){
			synchronized (q) {
				System.out.println(Thread.currentThread().getName()+" acquired the lock");
				q.notifyAll();
			}
		}
	}

}
