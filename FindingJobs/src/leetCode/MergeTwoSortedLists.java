package leetCode;

public class MergeTwoSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
        	return l2;
        }
        if(l2==null){
        	return l1;
        }
        ListNode head ;
        ListNode c1 ;
        ListNode c2 ;
        if(l1.val>l2.val){
        	head = l2;
        	c1 = l1;
        	c2 = l2.next;
        }else{
        	head = l1;
        	c1 = l1.next;
        	c2 = l2;
        }
        ListNode c = head;
        while(c1!= null && c2!=null){
        	if(c1.val>c2.val){
        		c.next = c2;
        		c = c2;
        		c2 = c2.next;
        	}else{
        		c.next = c1;
        		c = c1;
        		c1 = c1.next;
        	}
        }
        while(c1!=null){
        	c.next = c1;
        	c = c1;
        	c1 = c1.next;
        }
        while(c2!=null){
        	c.next = c2;
    		c = c2;
    		c2 = c2.next;
        }
        return head;
    }
	
	public static void main(String args[]){
		MergeTwoSortedLists ms = new MergeTwoSortedLists();
		ListNode l1 = ms.new ListNode(1);
		l1.next = ms.new ListNode(3);
		l1.next.next = ms.new ListNode(5);
		l1.next.next.next = ms.new ListNode(6);

		ListNode l2 = ms.new ListNode(2);
		l2.next = ms.new ListNode(4);
//		l2.next.next = ms.new ListNode(5);
//		l2.next.next.next = ms.new ListNode(7);
		ms.mergeTwoLists(l1, l2);
	}
}
