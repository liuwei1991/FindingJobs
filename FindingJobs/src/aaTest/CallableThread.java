package aaTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer>{
	private int count = 0;
	
	@Override
	public Integer call() throws Exception {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" : count = "+count);
			count += 1;
		}
		return count;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		CallableThread ct = new CallableThread();
		FutureTask<Integer> task1 = new FutureTask<Integer>(ct);
		FutureTask<Integer> task2 = new FutureTask<Integer>(ct);

		Thread t1 = new Thread(task1,"1");
		Thread t2 = new Thread(task2,"2");
//		Thread t3 = new Thread(task,"3");
		t1.start();
		t2.start();
//		t3.start();
		t1.join();
		t2.join();
//		t3.join();
		System.out.println(task1.get());
		System.out.println(task2.get());
	}
}
