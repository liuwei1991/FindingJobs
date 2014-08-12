package leetCode;

/**
 * 
 * @author Ares
 * You should be careful of the special situation,for example the input is null;
 */
public class SwapNodesinPairs {
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public ListNode swapPairs(ListNode head) 
	{
		ListNode current = head;
		if(head.next==null){
			return head;
		}
	
		ListNode befor = null;
		while(current.next!=null){
			if(befor!=null){
				befor.next = current.next;
				current.next = current.next.next;
				befor.next.next = current;
				current = current.next;
				if(current == null){
					return head;
				}
				befor = befor.next.next; 
			}else{
				head = current.next;
				current.next = current.next.next;
				head.next = current; 
				current = head.next.next;
				if(current == null){
					return head;
				}
				befor = head.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args){
		SwapNodesinPairs snp = new SwapNodesinPairs();
		ListNode l = snp.new ListNode(1);
		l.next = snp.new ListNode(2);
		l.next.next = snp.new ListNode(3);
		l.next.next.next = snp.new ListNode(4);
		l = snp.swapPairs(l);
		while(l!=null){
			System.out.println(l.val);
			l = l.next;
		}
	}
	
}
