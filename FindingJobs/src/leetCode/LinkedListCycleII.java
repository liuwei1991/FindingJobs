package leetCode;

public class LinkedListCycleII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
        if(head == null){
        	return null;
        }
        if(head.next == null){
        	return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(true){
        	if(fast == slow){
        		break;
        	}
        	if(fast.next!= null){
        		if(fast.next.next!=null){
        			fast = fast.next.next;
        		}else{
        			return null;
        		}
        	}else{
        		return null;
        	}
        	slow = slow.next;
        }
        slow = head;
        fast = fast.next;
        while(true){
        	if(slow==fast){
        		break;
        	}
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
	
	public static void main(String[] args){
		LinkedListCycleII lc = new LinkedListCycleII();
		ListNode ln = lc.new ListNode(1);
		ln.next = lc.new ListNode(2);
		ln.next.next = lc.new ListNode(3);
		ListNode start = lc.new ListNode(90);
		ln.next.next.next = start;
		start.next = lc.new ListNode(5);
		start.next.next = start;
		System.out.println(lc.detectCycle(ln).val);
	}
}
