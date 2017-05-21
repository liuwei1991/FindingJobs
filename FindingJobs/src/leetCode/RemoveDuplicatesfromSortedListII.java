package leetCode;

public class RemoveDuplicatesfromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head==null||head.next == null) {
			return head;
		}
		ListNode past = head;
		ListNode current = head.next;
		boolean goon = true;
		while (current != null) {
			if (past.val == current.val) {
				goon = false;
			} else {
				if (goon) {
					past = past.next;
				} else {
					goon = true;
					past.val = current.val;
					past.next = current.next;
				}
			}
			current = current.next;
		}

		if (!goon) {
			if (head.next == null) {
				return null;
			}
			ListNode ln = head;
			current = head.next;
			while (current != past) {
				if(current==null)break;
				ln = ln.next;
				current = current.next;
			}
			if(current==null){
				return null;
			}
			ln.next= null;
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII rd = new RemoveDuplicatesfromSortedListII();
		ListNode head = rd.new ListNode(2);
		head.next = rd.new ListNode(1);
		head.next.next = rd.new ListNode(1);
//		head.next.next.next = rd.new ListNode(4);
//		head.next.next.next.next = rd.new ListNode(4);
//		head.next.next.next.next.next= rd.new ListNode(6);
		rd.deleteDuplicates(null);
	}
}
