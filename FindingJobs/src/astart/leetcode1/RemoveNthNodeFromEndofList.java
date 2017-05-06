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
		ListNode fast = head;
		ListNode slow = head;
		int step = 0;
		for (; step <n && fast!=null; step++) {
			fast = fast.next;
		}
		if(step==n && fast==null){
			return head.next;
		}else if(fast==null){
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
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
