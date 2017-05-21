package leetCode;

public class InsertionSortList{
	 class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
	 
	public ListNode sortList(ListNode head) {
		if(head==null || head.next ==null){
			return head;
		}
		ListNode currentParent = head;
		ListNode current = head.next;
		while(current != null){
			ListNode compareParent = null;
			ListNode compare = head;
			ListNode currentNext = current.next;
			while(compare!=current){
				if(compare.val > current.val){
					currentParent.next = current.next;
					if(compareParent != null){
						compareParent.next = current;
					}else{
						head = current;
					}
					current.next = compare;
					break;
				}
				if(compareParent == null){
					compareParent = head;
				}else{
					compareParent = compareParent.next;
				}
				compare = compare.next;
			}
			if(compare==current){
				currentParent = currentParent.next;
			}
			current = currentNext;
		}
		return head;
	}
	
	public static void main(String args[]){
		InsertionSortList sl = new InsertionSortList();
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
		
		ln = sl.sortList(ln);
		System.out.println("asd");
	}
	


}
