package leetCode;

public class RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null){
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		for(int i=0;i<n;i++){
			if(fast==null){
				return head;
			}
			fast = fast.next;
		}
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		if(slow==head){
			head = head.next;
		}else{
			if(slow.next==null){
				fast = head.next.next;
				slow = head;
				while(fast!=null){
					fast=fast.next;
					slow= slow.next;
				}
				slow.next=null;
			}else{
				slow.val=slow.next.val;
				slow.next = slow.next.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args){
		RemoveNthNodeFromEndofList rn = new RemoveNthNodeFromEndofList();
		ListNode ln = rn.new ListNode(0);
//		ln.next = rn.new ListNode(1);
//		ln.next.next= rn.new ListNode(2);
//		ln.next.next.next = rn.new ListNode(3);
//		ln.next.next.next.next = rn.new ListNode(4);
//		ln.next.next.next.next.next = rn.new ListNode(5);
		int n = 1;
		rn.removeNthFromEnd(ln, n);
	}
}
