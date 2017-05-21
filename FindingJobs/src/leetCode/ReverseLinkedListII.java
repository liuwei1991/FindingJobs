package leetCode;

import java.util.Stack;

public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
        	return head;
        }
        if(head ==null){
        	return head;
        }
        Stack<Integer> s = new Stack<Integer>();
        ListNode start = null ;
        ListNode current = head;
        int count = 1;
        while(true){
        	if(count >= m && count<=n){
        		if(count==m){
        			start = current;
        		}
        		s.add(current.val);
        	}else if(count>n){
        		for(int i=0;i<=n-m;i++){
        			start.val=s.pop();
        			start = start.next;
        		}
        		return head;
        	}
        	current = current.next;
        	count ++;
        }
    }
	public static void main(String[] args){
		ReverseLinkedListII rl = new ReverseLinkedListII();
		ListNode ln = rl.new ListNode(1);
		ln.next = rl.new ListNode(2);
		ln.next.next = rl.new ListNode(3);
		ln.next.next.next = rl.new ListNode(4);
		rl.reverseBetween(ln, 2, 4);
	}
}
