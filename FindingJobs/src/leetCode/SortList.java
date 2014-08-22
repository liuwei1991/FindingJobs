package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {
	 class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
	 
	 /**
	  * 投机取巧的方法
	  * @param head
	  * @return
	  */
	public ListNode sortList1(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		if(head ==null){
			return head;
		}
		ListNode ln = head;
		while(ln!=null){
			list.add(ln.val);
			ln=ln.next;
		}
		Collections.sort(list);
		ln = head;
		int i=0;
		while(ln!=null){
			ln.val = list.get(i);
			ln=ln.next;
			i++;
		}
		return head;
	}
	
	public ListNode sortList(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		if(head ==null){
			return head;
		}
		
		return head;
	}
	public static void main(String args[]){
		SortList sl = new SortList();
		ListNode ln = sl.new ListNode(1);
		ListNode tmp = ln;
		tmp.next = sl.new ListNode(3);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(2);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(8);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(9);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(0);
		tmp = tmp.next;
		
		sl.sortList(ln);
		System.out.println("asd");
	}
	
}
