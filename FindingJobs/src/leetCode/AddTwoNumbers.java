package leetCode;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = null;
		ListNode pre = null;
		ListNode c1 = l1;
		ListNode c2 = l2;
		int inc = 0;
		while (c1 != null && c2 != null) {
			if(pre==null){
				if(c1.val+c2.val+inc>=10){
					pre=new ListNode(c1.val+c2.val+inc-10);
					inc =1;
				}else{
					pre=new ListNode(c1.val+c2.val+inc);
					inc =0;
				}
				result = pre;
				c1 = c1.next;
				c2=c2.next;
				continue;
			}
			pre.next = new ListNode(0);
			if(c1.val+c2.val+inc>=10){
				pre.next.val=c1.val+c2.val+inc-10;
				inc =1;
			}else{
				pre.next.val=c1.val+c2.val+inc;
				inc =0;
			}
			c1=c1.next;
			c2=c2.next;
			pre = pre.next;
		}
		while(c1!=null){
			if(c1.val+inc<10){
				pre.next = new ListNode(c1.val+inc);
				inc =0;
			}else{
				pre.next = new ListNode(c1.val+inc-10);
				inc =1;
			}
			pre = pre.next;
			c1 = c1.next;
		}
		while(c2!=null){
			if(c2.val+inc<10){
				pre.next = new ListNode(c2.val+inc);
				inc =0;
			}else{
				pre.next = new ListNode(c2.val+inc-10);
				inc =1;
			}
			pre=pre.next;
			c2=c2.next;
		}
		if(inc==1){
			pre.next= new ListNode(inc);
		}
		return result;
	}
	public static void main(String[] args){
		AddTwoNumbers at = new AddTwoNumbers();
		ListNode l1 = at.new ListNode(5);
//		l1.next = at.new ListNode(4);
//		l1.next.next = at.new ListNode(3);
		ListNode l2 = at.new ListNode(5);
//		l2.next = at.new ListNode(6);
//		l2.next.next = at.new ListNode(4);
		at.addTwoNumbers(l1, l2);
		
	}
}
