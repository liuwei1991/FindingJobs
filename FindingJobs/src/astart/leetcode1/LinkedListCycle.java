package astart.leetcode1;

public class LinkedListCycle {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast != slow) {
			if (fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast==null){
			return false;
		}
		return true;
	}

}
