package astart.leetcode1;

public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode pre = null;
		for (int i = 1; i < m; i++) {
			if (pre == null) {
				pre = head;
			} else {
				pre = pre.next;
			}
		}
		ListNode cur = null;
		if (pre == null) {
			cur = head;
		} else {
			cur = pre.next;
		}
		
		ListNode pre1 = cur;
		cur = cur.next;
		ListNode firstRev = pre1;
		for (int i = m; i < n; i++) {
			ListNode tmp = cur.next;
			cur.next = pre1;
			pre1 = cur;
			cur = tmp;
		}
		if(pre==null){
			head = pre1;
		}else{
			pre.next = pre1;
		}
		firstRev.next = cur;
		
		return head;
	}
}
