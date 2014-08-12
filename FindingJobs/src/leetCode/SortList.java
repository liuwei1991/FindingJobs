package leetCode;

public class SortList {
	 class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
	 
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode mark = head;
		ListNode current = head.next;
		ListNode leftHead = null;
		ListNode rightHead = null;
		
		while(current != null){
			ListNode tmp = current.next;
			if(current.val < mark.val){
				if(leftHead == null){
					leftHead = current;
					leftHead.next = null;
				}else{
					current.next = leftHead;
					leftHead = current;
				}
			}else{
				if(rightHead == null){
					rightHead = current;
					rightHead.next = null;
				}else{
					current.next = rightHead;
					rightHead = current;
				}
			}
			current = tmp;
		}
		
		leftHead = sortList(leftHead);
		rightHead = sortList(rightHead);
		if(leftHead == null){
			leftHead = mark;
		}else{
			ListNode tmp = leftHead;
			while(tmp.next!=null){
				tmp = tmp.next;
			}
			tmp.next = mark;
		}
		
		mark.next = rightHead;
		return leftHead;
	}
	
	public static void main(String args[]){
		SortList sl = new SortList();
		ListNode ln = sl.new ListNode(1);
		ListNode tmp = ln;
		tmp.next = sl.new ListNode(3);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(2);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(8);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(9);
		tmp = tmp.next;
		tmp.next = sl.new ListNode(0);
		tmp = tmp.next;
		
		sl.sortList(ln);
		System.out.println("asd");
	}
	
}
