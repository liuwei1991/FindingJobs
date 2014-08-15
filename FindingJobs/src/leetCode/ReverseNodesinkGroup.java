package leetCode;

import java.util.Stack;

public class ReverseNodesinkGroup {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null||head.next==null||k<=1){
			return head;
		}
		Stack<Integer> s = new Stack<Integer>();
		ListNode start = head;
		ListNode end = head;
		s.add(head.val);
		
		int step = 1;
		while(end!=null){
			if(step == k){
				s.add(end.val);
				end = end.next;
				while(start!=end){
					start.val=s.pop();
					start=start.next;
				}
				if(start!=null)s.add(start.val);
				step = 1;
			}else{
				s.add(end.val);
				end = end.next;
				step++;
			}
		}
		return head;
	}
	public static void main(String[] args){
		ReverseNodesinkGroup rn = new ReverseNodesinkGroup();
		ListNode head = rn.new ListNode(1);
		head.next = rn.new ListNode(2);
//		head.next.next = rn.new ListNode(3);
//		head.next.next.next = rn.new ListNode(4);
//		head.next.next.next.next = rn.new ListNode(5);
		rn.reverseKGroup(head, 2);
	}
}
