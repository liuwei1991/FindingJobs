package astart.leetcode1;

public class ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		head.next = null;  //注意不要弄成循环，head。next一定要赋值null
		while(cur!=null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
