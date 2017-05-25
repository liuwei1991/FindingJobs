package astart.leetcode1;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode cur = null;
		ListNode c1 = l1;
		ListNode c2 = l2;
		int incre = 0;
		while (c1 != null || c2 != null) {
			int a1 = 0;
			int a2 = 0;
			if (c1 != null) {
				a1 = c1.val;
				c1 = c1.next;
			}
			if (c2 != null) {
				a2 = c2.val;
				c2 = c2.next;
			}
			ListNode nextNode = new ListNode(0);
			if (a1 + a2 + incre < 10) {
				nextNode.val = a1 + a2 + incre;
				incre = 0;
			} else {
				nextNode.val = a1 + a2 + incre - 10;
				incre = 1;
			}
			if (cur == null) {
				result = nextNode;
				cur = nextNode;
			} else {
				cur.next = nextNode;
				cur = cur.next;
			}

		}
		if (incre == 1) {
			cur.next = new ListNode(1);
		}
		return result;
	}

}
