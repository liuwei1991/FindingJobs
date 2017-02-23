package astart.leetcode1;

public class RemoveDuplicatesfromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode tmp = head;
		while(tmp!=null){
			if(tmp.next!=null){
				if(tmp.val==tmp.next.val){
					tmp.next = tmp.next.next;
				}else{
					tmp = tmp.next;
				}
			}else{
				break;
			}
		}
		return head;
	}
}
