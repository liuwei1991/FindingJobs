package testCase;

import java.util.Random;

public class MultiplyThreadThreadLocal {
	public int bufferSize = 10;
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
		public synchronized Integer initialValue(){
			return  0;
		}
	};
	public static void increment(){
		value.set(value.get()+1);
	}
	public static int get(){
		return value.get();
	}
	
	public class ThreadCount implements Runnable{

		@Override
		public void run() {
			while(true){
				Random r = new Random();
				try {
					MultiplyThreadThreadLocal.increment();
					System.out.println("thread "+Thread.currentThread().getName()+","+value.get());
					Thread.sleep(r.nextInt(1000));
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	public static void main(String[] args){
		MultiplyThreadThreadLocal mt = new MultiplyThreadThreadLocal();
		ThreadCount tc = mt.new ThreadCount();
		Thread t = new Thread(tc);
		t.setName("t1");
		t.start();
		t = new Thread(tc);
		t.setName("t2");
		t.start();

		t = new Thread(tc);
		t.setName("t3");
		t.start();

		t = new Thread(tc);
		t.setName("t4");
		t.start();
	}
}
