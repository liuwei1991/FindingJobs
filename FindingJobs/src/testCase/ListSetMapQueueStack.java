package testCase;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ListSetMapQueueStack {

	public class ListNode{
		public int a;
		public String s;
		ListNode(int a,String s){
			this.a = a;
			this.s = s;
		}
	}
	/***
	 * Stack just this one.
	 */
	public void stackUsage() {
		Stack<String> s = new Stack<String>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("10");
		s.add("11");
		System.out.println(s.peek());
		
		Collections.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int a = Integer.valueOf(o1);
				int b = Integer.valueOf(o2);
				if (a > b) {
					return 1;
				} else {
					return -1;
				}
			}

		});
		System.out.println(s.peek());
	}

	/**
	 * LinkedList: implements Queue interface, so we can use LinkedList as Queue directly.
	 * BlockingQueue: most used for multi-threading programming
	 */
	public void queueUsage() {
		//use LinkedList as a queue
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("10");
		q.add("11");
		int[] a;

		LinkedBlockingQueue<String> bq = new LinkedBlockingQueue<String>();
		
		//ArrayBlockingQueue needs to set the size when created.
		ArrayBlockingQueue<String> aq = new ArrayBlockingQueue<String>(100);
		
		PriorityBlockingQueue<String> pq = new PriorityBlockingQueue<String>();
		
		DelayQueue<String> dq = new DelayQueue<String>(); 
		
	}

	public void listUsage() {

	}

	public void mapUsage() {

	}

	public void setUsage() {

	}

	public static void main(String[] args) {
		ListSetMapQueueStack test = new ListSetMapQueueStack();
		test.stackUsage();
	}
}
