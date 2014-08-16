package leetCode;

public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || head.next==null||n==0) return head;
		int len = 0;
		ListNode node = head;
		ListNode last = null;
		while(node!=null){
			if(node.next==null){
				last = node;
			}
			len++;
			node=node.next;
		}
		if(n%len ==0) return head;
		n = len- n%len;
		node = head;
		ListNode cur = head;
		int m = 1;
		while(m<n){
			cur = cur.next;
			m++;
		}
		head = cur.next;
		last.next=node;
		cur.next = null;
		return head;
	}
	
	public static void main(String args[]){
		RotateList rl = new RotateList();
		ListNode head = rl.new ListNode(1);
		head.next= rl.new ListNode(2);
		rl.rotateRight(head, 3);
	}
}
