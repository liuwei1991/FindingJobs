package testCase;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultiplyThreadsReentrantReadWriteLock {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	int itemCount = 0;
	int bufferSize = 10;

	public class Producer implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					lock.writeLock().lock();
					if (itemCount >= bufferSize) {
						System.out.println("producer wait....");
						lock.wait();
					}
					if (itemCount == 0) {
						System.out.println("producer notify....");
						lock.notifyAll();
					}
					itemCount++;
					System.out
							.println("producer item count up to " + itemCount);
					Random r = new Random(1000);

					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				} finally{
					lock.writeLock().unlock();
				}
			}
		}
	}

	public class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					lock.writeLock().lock();
					if (itemCount <= 0) {
						System.out.println("Consumer wait....");
						lock.wait();
					}
					if (itemCount == bufferSize) {
						System.out.println("Consumer notify....");
						lock.notifyAll();
					}
					itemCount--;
					System.out.println("Comsumer: " + itemCount);
					lock.writeLock().unlock();
					Random r = new Random(1000);

					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		MultiplyThreadsReentrantReadWriteLock mp = new MultiplyThreadsReentrantReadWriteLock();
		Consumer c = mp.new Consumer();
		Producer p = mp.new Producer();
		Thread t = new Thread(c);
		t.setName("Consumer");
		t.start();
		t = new Thread(p);
		t.setName("Producer");
		t.start();

	}
}
