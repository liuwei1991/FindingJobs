package testCase;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultilyThreadsSynchronized {
	private Integer count = 0;
	public class AddThread implements Runnable{
		@Override
		public void run() {
			while(true){
				synchronized(count){
					count ++;
					System.out.println(Thread.currentThread().getName()+", count = "+count);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	public static void main(String args[]){
		MultilyThreadsSynchronized mt = new MultilyThreadsSynchronized();
		int i=0;
		AddThread t = mt.new AddThread();
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(30, 30, 30,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());
		for(i=0;i<3;i++){
			Thread t1 = new Thread(t);
			t1.setName("t"+i);
			tpe.execute(t1);
//			t1.start();
		}
		
	}
}
