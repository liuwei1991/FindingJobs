package testCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultilyThreadReentrantLock {
	Lock lock = new ReentrantLock();
	private int count =0;
	public class ThreadCount implements Runnable{

		@Override
		public void run() {
			while(true){
				lock.lock();
				count ++;
				System.out.println(Thread.currentThread().getName()+" count="+count);
				lock.unlock();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		MultilyThreadReentrantLock mt = new MultilyThreadReentrantLock();
		ThreadCount tc = mt.new ThreadCount();
		for(int i=0;i<3;i++){
			Thread t1 = new Thread(tc);
			t1.setName("t"+i);
			t1.start();
		}
	}
}
