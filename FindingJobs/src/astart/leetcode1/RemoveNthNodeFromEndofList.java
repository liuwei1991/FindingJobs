package astart.leetcode1;

public class RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < n && fast != null; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList rn = new RemoveNthNodeFromEndofList();
		ListNode head = rn.new ListNode(1);
		head.next = rn.new ListNode(2);
		ListNode result = rn.removeNthFromEnd(head, 1);
		System.out.println("1");
	}
}
