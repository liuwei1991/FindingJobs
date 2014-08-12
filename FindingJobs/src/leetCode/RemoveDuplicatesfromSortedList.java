package leetCode;

public class RemoveDuplicatesfromSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode current = head;
        while(current.next!=null){
        	int a = current.val;
        	int b = current.next.val;
        	if(a==b){
        		current.next = current.next.next;
        	}else{
        		current = current.next;
        	}
        }
        return head;
    }
}
