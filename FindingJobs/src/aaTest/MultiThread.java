package aaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class MultiThread{
	private int a = 1;
	
	public class MyThread1 extends Thread{
		private int count = 0;
		private String s = "";
		private ReentrantLock lock = new ReentrantLock();
		private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		private ReadLock rlock = rwLock.readLock();
		private WriteLock wLock = rwLock.writeLock();
		
		public synchronized void fun1(){
			rwLock.readLock();
			for(int i=0;i<5;i++){
				count += 1;
				System.out.print(count);
			}
		}
		
		public void fun2(){
			
		}
		
		public void run(){
			for(int i=0;i<10;i++){
				synchronized(this){
					System.out.println(Thread.currentThread().getName()+':'+String.valueOf(count));
					count+=1;
				}
			}
		}
	}
	
	public void testMythread1() throws InterruptedException{
		MyThread1 t1 = new MyThread1();
		Thread t2 = new Thread(t1,"t2");
		Thread t3 = new Thread(t1,"t3");
		t2.start();
		t3.start();
		t2.join();
		t3.join();
	}
	
	public class MyThread2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void testExecuterPool(){
		ThreadPoolExecutor pool = new ThreadPoolExecutor(a, a, a, null, null);
//		pool.
	}
	
	public static void main(String[] args) throws InterruptedException{
//		MultiThread m = new MultiThread();
//		m.testMythread1();
//		String s1 = new String("ada");
//		String s2 = new String("ada");
//		System.out.println(s1==s2);
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.compareTo(s2));
		int[] s = {1,2,3,5,2,1};
		String[] ss = {};
		List<String> list = Arrays.asList(ss);
		ss = (String[]) list.toArray();
		
		Comparator<Integer> cmp = new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1<o2){
					return -1;
				}
				return 1;
			}
		};
//		Arrays.sort(s);
		Collections.sort(s,cmp);
		
	}
}
