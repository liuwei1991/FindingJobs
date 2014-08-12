package leetCode;

public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null){
        	return false;
        }
        if(head.next == null){
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(true){
        	if(fast == slow){
        		return true;
        	}
        	if(fast.next!= null){
        		if(fast.next.next!=null){
        			fast = fast.next.next;
        		}else{
        			return false;
        		}
        	}else{
        		return false;
        	}
        	slow = slow.next;
        }
    }
	
	public static void main(String[] args){
		LinkedListCycle lc = new LinkedListCycle();
		ListNode ln = lc.new ListNode(1);
		ln.next = lc.new ListNode(2);
		ln.next.next = lc.new ListNode(3);
//		ListNode start = lc.new ListNode(90);
//		ln.next.next.next = start;
//		start.next = lc.new ListNode(5);
//		start.next.next = start;
		System.out.println(lc.hasCycle(ln));
	}
}