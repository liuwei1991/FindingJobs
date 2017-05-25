package astart.leetcode1;

public class LinkedListCycleII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(true){
			if(fast==null||fast.next==null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		slow = head;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
    }
}
