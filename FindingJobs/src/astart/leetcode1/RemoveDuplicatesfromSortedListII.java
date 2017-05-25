package astart.leetcode1;

public class RemoveDuplicatesfromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = new ListNode(0);
		ListNode r = p;
		p.next = head;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int tmp = p.next.val;
				while(p.next!=null && p.next.val==tmp){
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}

		return r.next;
	}

}
