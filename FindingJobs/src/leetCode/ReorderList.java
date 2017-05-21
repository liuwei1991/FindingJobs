package leetCode;

import java.util.ArrayList;

public class ReorderList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {
		if(head == null) return ;
        ArrayList<ListNode> p = new ArrayList<ListNode>();
        int length = 0;
        ListNode ln = head;
        while(ln!=null){
        	p.add(ln);
        	ln = ln.next;
        	length ++;
        }
        ListNode current = head;
        for(int i=1;i<(length+1.0)/2;i++){
       		if(length-i>i){
       			current.next = p.get(length-i);
       			current = current.next;
       		}
       		current.next = p.get(i);
       		current = current.next;
        }
        current.next = null;
    }
	
	public static void main(String[] args){
		ReorderList rl = new ReorderList();
		ListNode ln = rl.new ListNode(1);
		ln.next = rl.new ListNode(2);
		ln.next.next = rl.new ListNode(3);
		ln.next.next.next = rl.new ListNode(4);
		ln.next.next.next.next = rl.new ListNode(5);
		rl.reorderList(ln);
	}
	
}
