package leetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
				10,new Comparator<ListNode>(){

			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val-l2.val;
			}
			
		});
		for(ListNode l:lists){
			if(l!=null){
				pq.offer(l);
			}
		}
		ListNode pre = null;
		ListNode result = null;
		while(!pq.isEmpty()){
			ListNode cur = pq.poll();
			if(result==null){
				result = cur;
				pre = cur;
			}else{
				pre.next = cur;
				pre = cur;
			}
			if(cur.next!=null){
				pq.offer(cur.next);
			}
		}
		return result;
	}
	public static void main(String[] args){
		
	}
}
