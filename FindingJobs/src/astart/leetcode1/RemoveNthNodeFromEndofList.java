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
		if(head==null ||n<=0){
			return head;
		}
		ListNode ahead = head;
		ListNode behind = head;
		int step = 0;
		while(ahead!=null && step<n){
			ahead = ahead.next;
			step+=1;
		}
		if(ahead==null && step==n){
			return head.next;
		}else if(ahead==null){
			return head.next;
		}
		while(ahead.next!=null){
			ahead=ahead.next;
			behind = behind.next;
		}
		behind.next = behind.next.next;
		return head;
	}
	
	public static void main(String[] args){
		RemoveNthNodeFromEndofList rn = new RemoveNthNodeFromEndofList();
		ListNode head = rn.new ListNode(1);
		head.next =  rn.new ListNode(2);
		ListNode result = rn.removeNthFromEnd(head, 1);
		System.out.println("1");
	}
}
