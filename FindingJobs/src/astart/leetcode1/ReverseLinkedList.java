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
		if(head==null){
			return head;
		}
		ListNode pre = head;
		ListNode cur = pre.next;
		pre.next = null;
		
		while(cur!=null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
	
	public static void main(String args[]){
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode head = rl.new ListNode(1);
		head.next = rl.new ListNode(2);
		rl.reverseList(head);
	}
}
