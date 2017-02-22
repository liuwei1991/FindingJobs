package astart.leetcode1;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode r = null;
		/**
		 * 注意：r已经被改变，返回的必须是r的头指针。所以要有一个fr记录头指针为主
		 */
		ListNode fr = null;
		int increase = 0;
		while(l1!=null){
			int value = 0;
			if(l2!=null){
				value = (l1.val+l2.val+increase)%10;
				increase = (l1.val+l2.val+increase)/10;
				l2 = l2.next;
			}else{
				value = (l1.val+increase)%10;
				increase = (l1.val+increase)/10;
			}
			if(r==null){
				r = new ListNode(value);
				fr = r;
			}else{
				r.next = new ListNode(value);
				r = r.next;
			}
			l1 = l1.next;
		}
		while(l2!=null){
			int value = (l2.val+increase)%10;
			increase = (l2.val+increase)/10;
			r.next = new ListNode(value);
			r = r.next;
			l2 = l2.next;
		}
		if(increase!=0){
			r.next = new ListNode(increase);
		}
		return fr;
	}
	
	
}
