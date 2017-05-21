package testCase;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerComsumer {
	public class Food{
		int value = 1;
		public Food(int v){
			this.value = v;
		}
	}
	
	private BlockingQueue<Food> foods = new ArrayBlockingQueue<Food>(10);
	
	public class Producer implements Runnable{
		@Override
		public void run() {
			while(true){
				Random r = new Random();
				try {
					int a = r.nextInt(100);
					foods.put(new Food(a));
					System.out.println("producer:"+a);
					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	public class Reducer implements Runnable{
		@Override
		public void run() {
			while(true){
				Random r = new Random();
				try {
					Food f = foods.take();
					System.out.println("reducer:"+f.value);
					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	public static void main(String[] args){
		ProducerComsumer pc = new ProducerComsumer();
		Thread t = new Thread(pc.new Producer());
		t.start();
		t = new Thread(pc.new Reducer());
		t.start();
	}
}
