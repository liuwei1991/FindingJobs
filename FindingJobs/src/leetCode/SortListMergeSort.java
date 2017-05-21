package leetCode;

public class SortListMergeSort {
	 class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
	 
	public ListNode sortList(ListNode head) {
		
		return head;
	}
	
	public static void main(String args[]){
		SortListMergeSort sl = new SortListMergeSort();
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
